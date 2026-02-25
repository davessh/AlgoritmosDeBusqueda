import java.util.Objects;

public class Nodo {
    private final String id;

    public Nodo(String id) {
        this.id = id.trim();
    }

    public String getId() { return id; }

    @Override
    public String toString() { return id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nodo)) return false;
        Nodo node = (Nodo) o;
        return Objects.equals(id, node.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}