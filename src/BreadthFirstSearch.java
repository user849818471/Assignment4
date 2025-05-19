import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<Vertex<V>, Vertex<V>> pathMap = new HashMap<>();

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        pathMap.put(start, null);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    pathMap.put(neighbor, current);
                }
            }
        }
    }

    public List<Vertex<V>> getPath(Vertex<V> destination) {
        List<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> at = destination; at != null; at = pathMap.get(at)) {
            path.add(0, at);
        }
        return path;
    }
}
