import java.util.*;

public class Grafo {
    private final Map<Nodo, List<Nodo>> ady = new HashMap<>();
    private final boolean noDirigido;

    public Grafo(boolean noDirigido) {
        this.noDirigido = noDirigido;
    }

    public void agregarArista(Nodo u, Nodo v) {
        ady.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        ady.computeIfAbsent(v, k -> new ArrayList<>());

        if (noDirigido) {
            ady.get(v).add(u);
        }
    }

    public List<Nodo> vecinos(Nodo u) {
        return ady.getOrDefault(u, Collections.emptyList());
    }

    public boolean contiene(Nodo n) {
        return ady.containsKey(n);
    }

    public Set<Nodo> nodos() {
        return ady.keySet();
    }

    public void ordenarVecinos() {
        for (List<Nodo> lista : ady.values()) {
            lista.sort(Comparator.comparing(Nodo::getId));
        }
    }
}