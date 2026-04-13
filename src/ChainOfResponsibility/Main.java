package ChainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = getChainOfLoggers();

        System.out.println("Demo of Chain of responsibility");
        System.out.println("==Logging Debug msg==");
        logProcessor.logMessage(LogProcessor.DEBUG, "This is debug msg");
        System.out.println("==Logging Info msg==");
        logProcessor.logMessage(LogProcessor.INFO, "This is info msg");
        System.out.println("==Logging fatal msg==");
        logProcessor.logMessage(LogProcessor.FETAL, "This is fetal msg");
        System.out.println("==Logging Warn msg==");
        logProcessor.logMessage(LogProcessor.ERROR, "This is error msg");

    }

    public static LogProcessor getChainOfLoggers() {
        LogProcessor debugLogger = new DebugLogProcessor(LogProcessor.DEBUG);
        LogProcessor infoLogger = new InfoLogProcessor(LogProcessor.INFO);
        LogProcessor errorLogger = new ErrorLogProcessor(LogProcessor.ERROR);
        LogProcessor fatalLogger = new FatalLogProcessor(LogProcessor.FETAL);

        debugLogger.setNextLogProcessor(infoLogger);
        infoLogger.setNextLogProcessor(errorLogger);
        errorLogger.setNextLogProcessor(fatalLogger);

        return debugLogger;
    }
}
