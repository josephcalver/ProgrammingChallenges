package _4_7_BuildOrder;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {

    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public Project(String n) {
        this.name = n;
    }

    public void addNeighbour(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    public void incrementDependencies() {
        this.dependencies++;
    }

    public void decrementDependencies() {
        this.dependencies--;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Project> getChildren() {
        return this.children;
    }

    public int getNumberDependencies() {
        return this.dependencies;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
