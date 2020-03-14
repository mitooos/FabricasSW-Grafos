package grafo;

public class ArcoNormal implements Arco{
	
	private Nodo origen;
	
	private Nodo destino;

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

}
