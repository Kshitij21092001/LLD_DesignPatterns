package Splitwise.Group;

import Splitwise.User.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    public List<Group> groupList=new ArrayList<>();

    public Group createNewGroup(String groupID, String groupName, User createdBy){
        Group newGroup=new Group(groupID,groupName);
        groupList.add(newGroup);
        newGroup.addGroupUsers(createdBy);
        return newGroup;
    }

    public Group getGroup(String groupID){
        for(Group group:groupList){
            if(group.getGroupID().equals(groupID)){
                return group;
            }
        }
        return null;
    }
}
