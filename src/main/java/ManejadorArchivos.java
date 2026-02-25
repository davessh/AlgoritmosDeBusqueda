import java.io.*;
import java.nio.charset.StandardCharsets;

public class ManejadorArchivos {

    public static Grafo cargarDesdeCSV(String ruta, boolean noDirigido) throws IOException {
        Grafo g = new Grafo(noDirigido);

        // 1) Intentar como archivo normal (ruta del sistema)
        File f = new File(ruta);
        BufferedReader br;

        if (f.exists()) {
            br = new BufferedReader(new FileReader(f));
        } else {
            // 2) Intentar como recurso en src/main/resources
            InputStream is = ManejadorArchivos.class.getClassLoader().getResourceAsStream(ruta);
            if (is == null) {
                throw new FileNotFoundException(ruta + " (No existe como archivo ni como resource)");
            }
            br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        }

        try (br) {
            String line;
            int numLinea = 0;

            while ((line = br.readLine()) != null) {
                numLinea++;
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                String[] p = line.split(",");
                if (p.length < 2) {
                    throw new IllegalArgumentException("Línea inválida en CSV en línea " + numLinea + ": " + line);
                }

                Nodo u = new Nodo(p[0].trim());
                Nodo v = new Nodo(p[1].trim());
                g.agregarArista(u, v);
            }
        }

        g.ordenarVecinos();
        return g;
    }
}