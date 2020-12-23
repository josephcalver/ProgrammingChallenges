package _4_7_BuildOrder;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {

    private ArrayList<Project> neighbours = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public enum State {COMPLETE, PARTIAL, BLANK}; // DFS version only
    private State state = State.BLANK; // DFS version only

    public Project(String n) {
        this.name = n;
    }

    public void addNeighbour(Project node) {
        if (!map.containsKey(node.getName())) {
            neighbours.add(node);
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

    public ArrayList<Project> getNeighbours() {
        return this.neighbours;
    }

    public int getNumberDependencies() {
        return this.dependencies;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
