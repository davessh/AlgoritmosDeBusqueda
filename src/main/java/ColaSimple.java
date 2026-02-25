import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ColaSimple {
    private final ArrayDeque<Nodo> queue = new ArrayDeque<>();

    public void enqueue(Nodo n) { queue.add(n); }
    public Nodo dequeue() { return queue.remove(); }
    public boolean isEmpty() { return queue.isEmpty(); }

    public String toVisualString() {
        List<Nodo> list = new ArrayList<>(queue);
        return "COLA(FRONT->BACK) " + list;
    }
}