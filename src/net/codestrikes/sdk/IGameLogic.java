package net.codestrikes.sdk;

public interface IGameLogic {
    int getLifePoints();

    int getMaxMoveTime();

    boolean validate(ReadonlyMoveCollection moveCollection);

    boolean validateRound(int roundNumber, int f1Points, int f2Points);

    int calculateScore(ReadonlyMoveCollection attacker, ReadonlyMoveCollection defender);
}
