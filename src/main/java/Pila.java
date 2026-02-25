import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Pila {
    private final Deque<Nodo> stack = new ArrayDeque<>();

    public void push(Nodo n) { stack.push(n); }
    public Nodo pop() { return stack.pop(); }
    public boolean isEmpty() { return stack.isEmpty(); }

    public String toVisualString() {
        List<Nodo> list = new ArrayList<>(stack);
        return "PILA(TOP->BOTTOM) " + list;
    }
}