package _4_7_BuildOrder;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    public static Graph buildGraph(String[] projects, String[][] dependencies) {

        Graph graph  = new Graph();

        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }

    public static Project[] orderProjects(ArrayList<Project> projects) {

        Project[] order = new Project[projects.size()];

        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];

            // circular dependency -- no remaining projects with zero dependencies
            if (current == null) {
                return null;
            }

            ArrayList<Project> children = current.getChildren();
            for (Project child : children) {
                child.decrementDependencies();
            }

            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }

        return order;
    }

    public static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {

        for (Project project : projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }

    public static void main(String[] args) {

        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = { {"f", "c"},
                                    {"f", "b"},
                                    {"f", "a"},
                                    {"c", "a"},
                                    {"b", "a"},
                                    {"a", "e"},
                                    {"d", "g"} };

        Project[] projectOrder = findBuildOrder(projects, dependencies);

        System.out.println(Arrays.toString(projectOrder));

    }

}
