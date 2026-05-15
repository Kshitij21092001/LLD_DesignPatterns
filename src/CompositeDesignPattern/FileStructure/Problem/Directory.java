package CompositeDesignPattern.FileStructure.Problem;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    String directoryName;
    List<Object> objectList;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.objectList = new ArrayList<>();
    }

    public void addToDirectory(Object object){
        objectList.add(object);
    }

    public void removeFromDirectory(Object object){
        objectList.remove(object);
    }

    public void ls(){
        System.out.println("Directory Name is: "+directoryName);

        for(Object object : objectList){
            if(object instanceof Directory){
                ((Directory)object).ls();
            }
            else if(object instanceof File){
                ((File)object).ls();
            }
        }
    }
}
