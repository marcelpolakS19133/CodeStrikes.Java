package net.codestrikes.bots;

import net.codestrikes.sdk.BotBase;
import net.codestrikes.sdk.*;

import java.util.Arrays;
import java.util.Random;

public class Boxer extends BotBase {
    private Area attack1 = Area.HookKick;
    private Area attack2 = Area.HookPunch;
    private Area defence = Area.HookKick;

    private int myScoreTotal = 0;
    private int opponentScoreTotal = 0;

    private Area ChangeDefence(Area oldDefence)
    {
        return (oldDefence == Area.HookKick) ? Area.HookPunch : Area.HookKick;
    }

    private Area CreateRandomAttack()
    {
        return new Random().nextDouble() > 0.5d ? Area.LowKick : Area.HookPunch;
    }

    public MoveCollection nextMove(RoundContext context)
    {
        myScoreTotal += context.getMyDamage();
        opponentScoreTotal += context.getOpponentDamage();

        context.getMyMoves()
                .addAttack(attack1)
                .addAttack(attack2);

        if ((context.getLastOpponentMoves() != null) && !Arrays.stream(context.getLastOpponentMoves().getAttacks()).anyMatch(x -> x.getArea() == defence))
        {
            defence = ChangeDefence(defence);
        }

        if (myScoreTotal >= opponentScoreTotal)
            context.getMyMoves().addAttack(CreateRandomAttack()); // 3 attacks, 0 defence
        else
            context.getMyMoves().addDefence(defence);

        return context.getMyMoves();
    }

    public String toString()
    {
        return "Boxer";
    }
}
