package ChainOfResponsibility;

public class FatalLogProcessor extends LogProcessor {
    public FatalLogProcessor(int level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.println("Fatal "+message);
    }
}
