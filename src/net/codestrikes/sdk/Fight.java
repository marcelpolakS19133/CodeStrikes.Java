package net.codestrikes.sdk;

import java.util.ArrayList;

public class Fight
{
    private BotBase bot1, bot2;
    private IGameLogic gameLogic;

    public Fight(BotBase bot1, BotBase bot2, IGameLogic gameLogic)
    {
        this.bot1 = bot1;
        this.bot2 = bot2;
        this.gameLogic = gameLogic;
    }

    public FightResults execute()
    {
        ReadonlyMoveCollection f1Move = null;
        ReadonlyMoveCollection f2Move = null;

        int score1 = 0;
        int score2 = 0;
        int round = 0;

        int f1Lifepoints, f2Lifepoints = f1Lifepoints = gameLogic.getLifePoints();
        ArrayList<RoundResult> roundResults = new ArrayList<RoundResult>();

        while (f1Lifepoints > 0 && f2Lifepoints > 0)
        {
            round++;

            RoundContext bot1Context = new RoundContext(f2Move, score1, score2, f1Lifepoints, f2Lifepoints);

            MoveCollection moves = null;

            try
            {
                moves = bot1.nextMove(bot1Context);
                bot1Context.setMoves(moves);
            }
            catch (Exception exc)
            {
                return FightResults.Error(FightResultErrorType.Runtime, FightResultType.Lost, exc.getMessage()).SetRoundResults(roundResults).SetRoundResults(roundResults);
            }

            if (!gameLogic.validate(moves))
                return FightResults.Error(FightResultErrorType.IllegalMove, FightResultType.Lost, bot1 + " made an illegal move").SetRoundResults(roundResults);


            RoundContext bot2Context = new RoundContext(f1Move, score2, score1, f2Lifepoints, f1Lifepoints);
            try
            {
                moves = bot2.nextMove(bot2Context);
                bot2Context.setMoves(moves);
            }
            catch (Exception exc)
            {
                return FightResults.Error(FightResultErrorType.Runtime, FightResultType.Win, exc.getMessage()).SetRoundResults(roundResults);
            }
            if (!gameLogic.validate(moves))
                return FightResults.Error(FightResultErrorType.IllegalMove, FightResultType.Win, bot2 + " made an illegal move").SetRoundResults(roundResults);

            f1Move = bot1Context.getMyMoves();
            f2Move = bot2Context.getMyMoves();

            score1 = gameLogic.calculateScore(f1Move, f2Move);
            score2 = gameLogic.calculateScore(f2Move, f1Move);

            f1Lifepoints -= score2;
            f2Lifepoints -= score1;

            RoundResult roundResult = new RoundResult(round, f1Move, f2Move, score1, score2);
            roundResults.add(roundResult);

            if (!gameLogic.validateRound(round, f1Lifepoints, f2Lifepoints))
            {
                return FightResults.Draw(f1Lifepoints, f2Lifepoints).SetRoundResults(roundResults);
            }
        }

        if (f1Lifepoints <= 0 && f2Lifepoints <= 0)
        {
            return FightResults.Draw(f1Lifepoints, f2Lifepoints).SetRoundResults(roundResults);
        }
        else if (f1Lifepoints > f2Lifepoints)
        {
            return FightResults.Win(f1Lifepoints, f2Lifepoints).SetRoundResults(roundResults);
        }
        else if (f1Lifepoints == f2Lifepoints)
        {
            return FightResults.Draw(f1Lifepoints, f2Lifepoints).SetRoundResults(roundResults);
        }
        return FightResults.Lost(f1Lifepoints, f2Lifepoints).SetRoundResults(roundResults);
    }
}

