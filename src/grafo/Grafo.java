package grafo;

import java.util.ArrayList;
import java.util.List;

public interface Grafo {

	
	public void addNodo(String nodo);
	
	public Nodo buscarNodo(String nombre);
	
	public boolean existeRuta(String origen, String detino);
	
	public List<Nodo> buscarRuta(String origen, String detino);
	
	public void addArco(String origen, String destino);
	
	public void addArco(String origen, String destino, int peso);

}
