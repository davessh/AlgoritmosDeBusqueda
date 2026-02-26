import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String rutaCSV = "grafo.csv";
        String inicio;
        String objetivo;
        String modo;
        boolean undirected = false;

        // Si NO se pasan argumentos → pedirlos por consola
        if (args.length < 4) {
            //System.out.println("No se proporcionaron argumentos.");
            System.out.println("Ingrese los datos manualmente:\n");

            System.out.print("Nodo inicio: ");
            inicio = sc.nextLine();

            System.out.print("Nodo objetivo: ");
            objetivo = sc.nextLine();

            System.out.print("Modo (dfs/bfs): ");
            modo = sc.nextLine();

            System.out.print("¿Grafo NO dirigido? (s/n): ");
            String resp = sc.nextLine();
            if (resp.equalsIgnoreCase("s")) {
                undirected = true;
            }

        } else {
            // Si se pasan argumentos desde terminal o configuración del IDE
            rutaCSV = args[0];
            inicio = args[1];
            objetivo = args[2];
            modo = args[3];

            if (args.length >= 5 && args[4].equalsIgnoreCase("undirected")) {
                undirected = true;
            }
        }

        try {
            Nodo nodoInicio = new Nodo(inicio);
            Nodo nodoObjetivo = new Nodo(objetivo);

            System.out.println("Cargando grafo...");
            System.out.println("Archivo: " + rutaCSV);
            System.out.println("Tipo: " + (undirected ? "NO DIRIGIDO" : "DIRIGIDO"));
            System.out.println("Inicio: " + inicio);
            System.out.println("Objetivo: " + objetivo);
            System.out.println("Modo: " + modo.toUpperCase());


            Grafo g = ManejadorArchivos.cargarDesdeCSV(rutaCSV, undirected);

            boolean encontrado;

            if (modo.equalsIgnoreCase("dfs")) {
                encontrado = DFS.buscar(g, nodoInicio, nodoObjetivo);
            } else if (modo.equalsIgnoreCase("bfs")) {
                encontrado = BFS.buscar(g, nodoInicio, nodoObjetivo);
            } else {
                System.out.println("Modo inválido. Use: dfs o bfs");
                return;
            }

            if (encontrado) {
                System.out.println("RESULTADO: OBJETIVO ENCONTRADO");
            } else {
                System.out.println("RESULTADO: OBJETIVO NO ENCONTRADO");
            }

        } catch (Exception e) {
            System.out.println("Error al cargar el grafo:");
            System.out.println(e.getMessage());
        }
    }
}