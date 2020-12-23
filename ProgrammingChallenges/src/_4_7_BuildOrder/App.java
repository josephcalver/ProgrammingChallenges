package _4_7_BuildOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

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

            // circular dependency -- no projects with zero dependencies
            if (current == null) {
                return null;
            }

            ArrayList<Project> neighbours = current.getNeighbours();
            for (Project neighbour : neighbours) {
                neighbour.decrementDependencies();
            }

            endOfList = addNonDependent(order, neighbours, endOfList);
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
                                    {"b", "h"},
                                    {"a", "e"},
                                    {"d", "g"} };

        Project[] projectOrder = findBuildOrder(projects, dependencies);

        System.out.println(Arrays.toString(projectOrder));
        System.out.println();

        Stack<Project> projectOrder2 = findBuildOrderDFS(projects, dependencies);

        System.out.println(projectOrder2.size());

        for (int i = projectOrder2.size() - 1; i > 0; i--) {
            System.out.print(projectOrder2.get(i) + " --> ");
        }

    }

    // DFS version

    public static Stack<Project> findBuildOrderDFS(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjectsDFS(graph.getNodes());
    }

    public static Stack<Project> orderProjectsDFS(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project : projects) {
            if (!doDFS(project, stack)) {
                return null;
            }
        }
        return stack;
    }

    public static boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == Project.State.PARTIAL) {
            return false; // cycle detected
         }

        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            ArrayList<Project> neighbours = project.getNeighbours();
            for (Project neighbour : neighbours) {
                if (!doDFS(neighbour, stack)) {
                    return false;
                }
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }

}
