package net.codestrikes.bots;

import net.codestrikes.sdk.*;

import java.util.Arrays;
import java.util.Random;

public class Kickboxer extends BotBase {
    private Area attack1 = Area.HookPunch;
    private Area defence = Area.HookKick;

    private Area CreateRandomArea()
    {
        double random = new Random().nextDouble();
        if (random<0.3)
            return Area.HookKick;

        if (random<0.7)
            return Area.HookPunch;

        if (random<0.9)
            return Area.LowKick;

        return Area.LowKick;
    }

    public MoveCollection nextMove(RoundContext context)
    {
        if ((context.getLastOpponentMoves() != null) && Arrays.stream(context.getLastOpponentMoves().getDefences()).anyMatch(x -> x.getArea() == this.attack1))
        {
            this.attack1 = CreateRandomArea();
        }

        Area attack2 = CreateRandomArea();

        context.getMyMoves()
                .addAttack(attack1)
                .addAttack(attack2)
                .addDefence(defence);
        return context.getMyMoves();
    }

    public String toString()
    {
        return "Kickboxer";
    }
}
