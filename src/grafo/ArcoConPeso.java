package grafo;

public class ArcoConPeso implements Arco{

	private Nodo origen;

	private Nodo destino;
	
	private int peso;

	@Override
	public Nodo getOrigen() {
		return origen;
	}

	@Override
	public void setOrigen(Nodo origen) {
		this.origen = origen;		
	}

	@Override
	public Nodo getDestino() {
		return destino;
	}

	@Override
	public void setDestino(Nodo destino) {
		this.destino = destino;		
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}
