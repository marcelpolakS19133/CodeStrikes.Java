package net.codestrikes;

import net.codestrikes.bots.Boxer;
import net.codestrikes.bots.Kickboxer;
import net.codestrikes.sdk.Fight;
import net.codestrikes.sdk.FightResults;
import net.codestrikes.sdk.StandardGameLogic;

public class Main {

    public static void main(String[] args) {
        PlayerBot playerBot = new PlayerBot();
        Kickboxer kickboxer = new Kickboxer();
        Boxer boxer = new Boxer();

        System.out.println(String.format("Executing fight: %s vs %s", playerBot, kickboxer));
        Fight fight = new Fight(playerBot, kickboxer, new StandardGameLogic());
        FightResults result = fight.execute();

        System.out.println(String.format("Result: %s", result));
        System.out.println();

        System.out.println(String.format("Executing fight: %s vs %s", playerBot, boxer));
        fight = new Fight(playerBot, boxer, new StandardGameLogic());
        result = fight.execute();
        System.out.println(String.format("Result: %s", result));

        System.out.println();
    }
}
