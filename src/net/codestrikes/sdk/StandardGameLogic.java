package net.codestrikes.sdk;

public class StandardGameLogic implements IGameLogic {
    public StandardGameLogic() {

    }

    public int getLifePoints() {
        return 200;
    }

    public int getEnergy() {
        return 12;
    }

    public int getMaxRounds() {
        return 100;
    }

    public int getMaxMoveTime() {
        return 500;
    }

    public int calculateScore(ReadonlyMoveCollection attacker, ReadonlyMoveCollection defender) {
        int points = 0;

        for(Move attack: attacker.getAttacks())
        {
            if (!defender.hasDefence(attack.getArea()))
            {
                points += attack.getAttackPower();
            }
        }

        return points;
    }

    public boolean validate(ReadonlyMoveCollection moveCollection) {
        return moveCollection.sumEnergy() <= getEnergy();
    }

    public boolean validateRound(int roundNumber, int f1Points, int f2Points) {
        if (roundNumber >= getMaxRounds() && f1Points > 0 && f2Points > 0) return false;
        if (f1Points < 0 && f2Points < 0) return false;
        return true;
    }
}
