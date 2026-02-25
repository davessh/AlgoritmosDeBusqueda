import java.util.*;

public class BFS {

    public static boolean buscar(Grafo g, Nodo inicio, Nodo objetivo) {
        // 1) Declarar estructura FIFO o cola
        ColaSimple cola = new ColaSimple();

        // Estructura auxiliar: “descubiertos / no visitados”
        LinkedHashSet<Nodo> descubiertos = new LinkedHashSet<>();

        // 2) Agregamos el nodo raíz a la cola
        cola.enqueue(inicio);
        descubiertos.add(inicio);

        int iter = 0;

        // 3) Mientras la cola NO esté vacía
        while (!cola.isEmpty()) {
            iter++;

            System.out.println("\n================ BFS - ITERACIÓN " + iter + " ================");
            // RÚBRICA: en cada iteración ver LAS 2 ESTRUCTURAS
            System.out.println(cola.toVisualString());
            System.out.println("DESCUBIERTOS " + new ArrayList<>(descubiertos));

            // 3.1) Sacar un nodo de la cola
            Nodo actual = cola.dequeue();
            System.out.println("VISITANDO: " + actual);

            // 3.2) SI el nodo es el que estamos buscando
            if (actual.equals(objetivo)) {
                System.out.println("OBJETIVO ENCONTRADO: " + objetivo);
                return true;
            }

            // 3.3) SI NO:
            // a) Marcar como visitado e imprimir (aquí ya imprimimos “VISITANDO”)
            // b) Incluir en la cola a sus hijos del siguiente nivel NO DESCUBIERTOS
            List<Nodo> vecinos = g.vecinos(actual);
            List<Nodo> agregados = new ArrayList<>();

            for (Nodo hijo : vecinos) {
                if (!descubiertos.contains(hijo)) {
                    descubiertos.add(hijo);
                    cola.enqueue(hijo);
                    agregados.add(hijo);
                }
            }

            System.out.println("VECINOS(" + actual + "): " + vecinos);
            System.out.println("AGREGADOS A COLA (NO DESCUBIERTOS): " + agregados);
        }

        System.out.println("OBJETIVO NO ENCONTRADO: " + objetivo);
        return false;
    }
}