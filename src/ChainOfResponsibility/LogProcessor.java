package ChainOfResponsibility;

public abstract class LogProcessor {
    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int ERROR = 3;
    public static final int FETAL =4;
    int level;
    public LogProcessor nextLogProcessor;

    public void setNextLogProcessor(LogProcessor nextLogProcessor){
        this.nextLogProcessor = nextLogProcessor;
    }

    public void logMessage(int level,String message){
        if(this.level==level){
            write(message);
            return;
        }

        if(nextLogProcessor!=null){
            nextLogProcessor.logMessage(level,message);
        }
    }

    public abstract void write(String message);
}
