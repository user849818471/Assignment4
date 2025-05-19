import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");

        graph.addEdge(a, b, 1);
        graph.addEdge(a, c, 4);
        graph.addEdge(b, c, 2);
        graph.addEdge(b, d, 5);
        graph.addEdge(c, d, 1);
        graph.addEdge(d, e, 3);

        Search<String> bfs = new BreadthFirstSearch<>(graph, a);
        List<Vertex<String>> bfsPath = bfs.getPath(e);
        System.out.println("BFS Path: " + bfsPath);

        Search<String> dijkstra = new DijkstraSearch<>(graph, a);
        List<Vertex<String>> dijkstraPath = dijkstra.getPath(e);
        System.out.println("Dijkstra Path: " + dijkstraPath);
    }
}
