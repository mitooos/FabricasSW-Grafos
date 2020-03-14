package factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import grafo.Grafo;
import grafo.GrafoDirigido;
import grafo.GrafoDirigidoConPeso;
import grafo.GrafoNoDirigidoConPeso;
import grafo.GrafoNoDrigido;

public class GrafoFactory {

	public static Grafo getOpcionConfiguada() {

		Properties opciones = new Properties();

		try {
			opciones.load(new FileReader("config.properties"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		boolean dirigido =  opciones.getProperty("dirigido").equals("true");
		
		boolean noDirigido =  opciones.getProperty("noDirigido").equals("true");
		
		boolean sinPeso = opciones.getProperty("sinPeso").equals("true");
		
		boolean conPeso = opciones.getProperty("conPeso").equals("true");
		
		boolean dfs = opciones.getProperty("dfs").equals("true");
		
		boolean bfs = opciones.getProperty("bfs").equals("true");
		
		Grafo grafo = null;
		
		if(dirigido && sinPeso) {
			System.out.println("Usando grafo dirigido sin peso");
			grafo = new GrafoDirigido(dfs, bfs);
		
		}
		else if(noDirigido && sinPeso) {
			System.out.println("Usando grafo no dirigido sin peso");
			grafo = new GrafoNoDrigido(dfs, bfs);
		}
		else if (dirigido && conPeso) {
			System.out.println("Usando grafo dirigido con peso");
			grafo = new GrafoDirigidoConPeso(dfs, bfs);
		}
		else if(noDirigido && conPeso) {
			System.out.println("Usando grafo no dirigido con peso");
			grafo = new GrafoNoDirigidoConPeso(dfs, bfs);
		}
		
		if(dfs) {
			System.out.println("Usando algoritmo dfs");
		}
		else if(bfs) {
			System.out.println("Usando algoritmo bfs");
		}
		
		return grafo;
	}

}
