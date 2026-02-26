import java.util.*;

public class DFS {

    public static boolean buscar(Grafo g, Nodo inicio, Nodo objetivo) {
        // 1) Obtener el grafo (ya viene en 'g')
        // 2) Declarar estructura LIFO o pila
        Pila pila = new Pila();

        // Estructura auxiliar para visualizar nodos descubiertos/visitados
        LinkedHashSet<Nodo> descubiertos = new LinkedHashSet<>();

        // 3) Agregamos el nodo raíz a la pila
        pila.push(inicio);
        descubiertos.add(inicio);

        int iter = 0;

        // 4) Mientras la pila NO esté vacía
        while (!pila.isEmpty()) {
            iter++;

            System.out.println("\n================ DFS - ITERACIÓN " + iter + " ================");
            // RÚBRICA: al inicio del while se vean LAS 2 ESTRUCTURAS
            System.out.println(pila.toVisualString());
           // System.out.println("DESCUBIERTOS " + new ArrayList<>(descubiertos));
            System.out.println(mostrarDescubiertosOrdenados(descubiertos));
            // 4.1) Sacar un nodo de la pila (visitamos el nodo)
            Nodo actual = pila.pop();
            System.out.println("VISITANDO: " + actual);

            // 4.2) SI el nodo es el que estamos buscando
            if (actual.equals(objetivo)) {
                // a) Imprimir nodo en pantalla
                System.out.println("OBJETIVO ENCONTRADO: " + objetivo);
                // b) Salir
                return true;
            }

            // 4.3) SI NO, entonces: incluir en la pila (pre-orden) a sus hijos del siguiente nivel
            // Para que sea “pre-orden” consistente: si vecinos están ordenados A,B,C
            // al ser pila, conviene empujarlos al revés para que se procese primero el menor.
            List<Nodo> vecinos = g.vecinos(actual);
            List<Nodo> rev = new ArrayList<>(vecinos);
            Collections.reverse(rev);

            List<Nodo> agregados = new ArrayList<>();

            for (Nodo hijo : rev) {
                if (!descubiertos.contains(hijo)) {
                    descubiertos.add(hijo);
                    pila.push(hijo);
                    agregados.add(hijo);
                }
            }

            System.out.println("VECINOS(" + actual + "): " + vecinos);
            System.out.println("AGREGADOS A PILA (pre-orden): " + agregados);
        }

        System.out.println("OBJETIVO NO ENCONTRADO: " + objetivo);
        return false;
    }
    private static String mostrarDescubiertosOrdenados(java.util.Set<Nodo> set) {
        java.util.List<Nodo> lista = new java.util.ArrayList<>(set);
        lista.sort(java.util.Comparator.comparing(Nodo::getId));
        return "DESCUBIERTOS(ABC) " + lista;
    }
}