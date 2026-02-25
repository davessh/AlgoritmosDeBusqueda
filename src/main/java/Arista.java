public class Arista {
    private final Nodo origen;
    private final Nodo destino;

    public Arista(Nodo origen, Nodo destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public Nodo getOrigen() { return origen; }
    public Nodo getDestino() { return destino; }
}
