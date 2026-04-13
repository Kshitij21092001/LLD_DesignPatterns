package ChainOfResponsibility;

public class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(int level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.println("Error "+message);
    }
}
