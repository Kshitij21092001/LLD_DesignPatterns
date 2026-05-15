package CompositeDesignPattern.FileStructure.Solution;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent {
    String directoryName;
    List<FileSystemComponent> componentList;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.componentList = new ArrayList<>();
    }

    public void addToDirectory(FileSystemComponent component){
        this.componentList.add(component);
    }

    public void removeFromDirectory(FileSystemComponent component){
        this.componentList.remove(component);
    }

    @Override
    public void ls(){
        System.out.println("Directory Name is: "+directoryName);

        for(FileSystemComponent component : componentList){
            component.ls();
        }
    }
}
