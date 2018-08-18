package net.codestrikes.sdk;

public class RoundResult
{
    private int roundNumber;
    private ReadonlyMoveCollection playerMoves;
    private ReadonlyMoveCollection opponentMoves;
    private int playerScore;
    private int opponentScore;

    public RoundResult(int roundNumber, ReadonlyMoveCollection playerMoves, ReadonlyMoveCollection opponentMoves, int playerScore, int opponentScore)
    {
        this.roundNumber = roundNumber;
        this.playerMoves = playerMoves;
        this.opponentMoves = opponentMoves;
        this.playerScore = playerScore;
        this.opponentScore = opponentScore;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public ReadonlyMoveCollection getPlayerMoves() {
        return playerMoves;
    }

    public ReadonlyMoveCollection getOpponentMoves() {
        return opponentMoves;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }
}
