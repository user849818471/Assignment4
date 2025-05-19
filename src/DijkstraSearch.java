import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private Map<Vertex<V>, Vertex<V>> pathMap = new HashMap<>();
    private Map<Vertex<V>, Double> distances = new HashMap<>();

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> start) {
        for (Vertex<V> vertex : graph.getVertices()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);

        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparing(distances::get));
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double newDist = distances.get(current) + entry.getValue();
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    pathMap.put(neighbor, current);
                    queue.remove(neighbor);
                    queue.add(neighbor);
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
