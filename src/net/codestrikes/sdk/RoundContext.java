package net.codestrikes.sdk;

public class RoundContext {
    private MoveCollection myMoves;
    private ReadonlyMoveCollection lastOpponentMoves;
    private int myDamage;
    private int opponentDamage;

    public RoundContext(ReadonlyMoveCollection lastOpponentMoves, int myDamage, int opponentDamage) {
        this.lastOpponentMoves = lastOpponentMoves;
        this.myDamage = myDamage;
        this.opponentDamage = opponentDamage;
        this.myMoves = new MoveCollection();
    }

    public void setMoves(MoveCollection moves) {
        myMoves = moves;
    }

    public MoveCollection getMyMoves() {
        return myMoves;
    }

    public ReadonlyMoveCollection getLastOpponentMoves() {
        return lastOpponentMoves;
    }

    public int getMyDamage() {
        return myDamage;
    }

    public int getOpponentDamage() {
        return opponentDamage;
    }
}
