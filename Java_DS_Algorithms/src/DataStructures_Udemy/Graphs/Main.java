package DataStructures_Udemy.Graphs;

public class Main {
    public static void main(String[] args) {
        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");
        myGraph.addVertex("E");
        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "E");
        myGraph.removeEdge("B", "A");

        myGraph.printGraph();
    }
}
