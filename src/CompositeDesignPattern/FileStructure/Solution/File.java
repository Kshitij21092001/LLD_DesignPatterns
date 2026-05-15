package CompositeDesignPattern.FileStructure.Solution;

public class File implements FileSystemComponent {
    String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void ls(){
        System.out.println("File Name is: "+fileName);
    }
}
