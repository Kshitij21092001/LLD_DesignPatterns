package ChainOfResponsibility;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(int leve) {
        this.level = leve;
    }

    public void write(String message) {
        System.out.println("Info "+message);
    }
}
