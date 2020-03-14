package grafo;

import java.util.ArrayList;
import java.util.List;

import busqueda.BFS;
import busqueda.DFS;

public class GrafoNoDrigido implements Grafo{

	List<Nodo> nodos = new ArrayList<>();

	List<Arco> arcos = new ArrayList<>();

	private boolean dfs;

	private boolean bfs;

	public GrafoNoDrigido(boolean dfs, boolean bfs) {
		this.dfs = dfs;
		this.bfs = bfs;
	}

	@Override
	public void addNodo(String nombre) {
		Nodo nodo = new Nodo();
		nodo.setNombre(nombre);
		nodos.add(nodo);

	}

	@Override
	public Nodo buscarNodo(String nombre) {
		for (Nodo nodo: nodos) {
			if (nodo.getNombre().equals(nombre)) {
				return nodo;
			}
		}
		return null;
	}

	@Override
	public boolean existeRuta(String origen, String destino) {
		if (buscarRuta(origen, destino) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Nodo> buscarRuta(String origen, String destino) {
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);
		List<Nodo> nodosRuta = new ArrayList<>();

		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if(this.dfs) {
			if (DFS.buscarRutaDFS(nodosRuta, nodoOrigen, nodoDestino)) {
				return nodosRuta;
			} else {
				return null;
			}
		}
		else if(this.bfs){
			if (BFS.buscarRutaBFS(nodosRuta, nodoOrigen, nodoDestino)) {
				return nodosRuta;
			} else {
				return null;
			}
		}
		else {
			throw new RuntimeException("Error en la Búsqueda: No hay un algoritmo de busqueda seleccionado");
		}
	}

	@Override
	public void addArco(String origen, String destino) {
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);

		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}

		addArco(nodoOrigen, nodoDestino);

	}

	public void addArco(Nodo nodoOrigen, Nodo nodoDestino)
	{
		Arco arco = new ArcoNormal();
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);

		arco = new ArcoNormal();
		arco.setOrigen(nodoDestino);
		arco.setDestino(nodoOrigen);
		arcos.add(arco);
		nodoDestino.agregarArco(arco);
	}

	@Override
	public void addArco(String origen, String destino, int peso) {
		throw new UnsupportedOperationException();
		
	}

}
