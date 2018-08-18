package net.codestrikes.sdk;

import java.util.ArrayList;

public class FightResults
{
    private int playerScore;
    private int opponentScore;
    private FightResultType result;
    private boolean isError;
    private String errorMessage;
    private FightResultErrorType errorType;
    private ArrayList<RoundResult> roundResults;

    private FightResults()
    {
        roundResults = new ArrayList<RoundResult>();
    }

    private FightResults(int playerScore, int opponentScore, FightResultType result)
    {
        this();
        this.playerScore = playerScore;
        this.opponentScore = opponentScore;
        this.result = result;
    }

    private FightResults(FightResultErrorType errorType, FightResultType result, String errorMessage)
    {
        this();
        this.errorType = errorType;
        this.result = result;
        this.errorMessage = errorMessage;
        this.isError = true;
    }

    public static FightResults Draw(int playerScore, int opponentScore)
    {
        return new FightResults(playerScore, opponentScore, FightResultType.Draw);
    }

    public static FightResults Win(int playerScore, int opponentScore)
    {
        return new FightResults(playerScore, opponentScore, FightResultType.Win);
    }

    public static FightResults Lost(int playerScore, int opponentScore)
    {
        return new FightResults(playerScore, opponentScore, FightResultType.Lost);
    }

    public static FightResults Error(FightResultErrorType errorType, FightResultType result, String errorMessage)
    {
        return new FightResults(errorType, result, errorMessage);
    }

    public FightResults SetRoundResults(ArrayList<RoundResult> results)
    {
        this.roundResults = results;
        return this;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }

    public FightResultType getResult() {
        return result;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public FightResultErrorType getErrorType() {
        return errorType;
    }

    public ArrayList<RoundResult> getRoundResults() {
        return roundResults;
    }

    public String toString() {
        if (isError)
        {
            return String.format(
                "%s with error : %s - message: %s",
                result,
                errorType,
                errorMessage
            );
        }

        return String.format(
            "%s: PlayerScore: %s, OpponentScore: %s",
            result,
            playerScore,
            opponentScore
        );
    }
}

