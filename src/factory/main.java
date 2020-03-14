package factory;

import java.util.List;

import grafo.Grafo;
import grafo.Nodo;

public class main {

	public static void main(String[] args) {

		Grafo g = GrafoFactory.getOpcionConfiguada();

		g.addNodo("A");
		g.addNodo("B");
		g.addNodo("C");

		g.addArco("A", "B");
		g.addArco("B", "C");
		g.addArco("A", "C");

		List<Nodo> camino = g.buscarRuta("C", "A");

		if (camino == null) {
			System.out.println("Camino A -> C no encontrado");
		} else {
			System.out.println("Camino A -> C encontrado");
			for (Nodo nodo: camino) {
				System.out.println(nodo.getNombre());
			}				
		}
		System.out.println();



	}

}
