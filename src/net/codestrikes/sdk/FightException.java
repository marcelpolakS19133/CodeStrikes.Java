package net.codestrikes.sdk;

public class FightException extends Exception {
    private FightExceptionReason reason;

    private BotBase errorBot;

    public FightException(String message, FightExceptionReason reason, BotBase errorBot, Exception innerException) {
        super(message, innerException);
        this.reason = reason;
        this.errorBot = errorBot;
    }

}
