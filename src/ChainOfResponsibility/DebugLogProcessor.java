package ChainOfResponsibility;

public class DebugLogProcessor extends LogProcessor{
    public DebugLogProcessor(int level){
        this.level=level;
    }

    @Override
    public void write(String message) {
        System.out.println("Debug " + message);
    }
}
