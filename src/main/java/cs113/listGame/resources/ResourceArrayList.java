package cs113.listGame.resources;

import cs113.listGame.gamecore.GameObject;

import java.util.ArrayList;
import java.util.List;

public class ResourceArrayList implements ResourceList {

    public ArrayList<ResourceObject> resourceList;

    public ResourceArrayList() {
        resourceList = new ArrayList<>();
    }

    @Override
    public void add(ResourceObject resource) {
        if (resource != null) {
            resourceList.add(resource);
        }
    }

    @Override
    public void remove(ResourceObject resource) {
        if (resource != null) {
            resourceList.remove(resource);
        }
    }

    @Override
    public void truncate(ResourceObject resource) {
        for (int i = 0; i < resourceList.size(); i++) {
            if(resourceList.get(i).equals(resource)){
                resourceList.remove(i);
                break;
            }
        }

    }

    @Override
    public void follow(GameObject leader) {
        for (ResourceObject resource : resourceList) {
            if (resource != null) {
                resource.moveTowards(leader.getEchoCenter());
                leader = resource; }
        }
    }
}
