package pantalla.modelo;

import java.io.IOException;

import Helpers.Tamanno;
import comunicacion.Servidor;
import controlador.ConstantesComunicacion;

public class ModeloPantalla {
	/* Esta clase es el modelo del MVC de la pantalla
	 * */
	protected Tablero tablero;
	
	//recibe informacion entonces debe usar servidor
	public Servidor servidor;
	public ModeloPantalla() {
		tablero = new Tablero(Tamanno.NORMAL);
		try {
			servidor = new Servidor(ConstantesComunicacion.Consola_Pantalla);
		} catch (IOException e) {
			System.out.println("No se puede crear el servidor en Modelo de pantalla");
		}
	}
	
	public void cambiarTamannoTablero(Tamanno tamanno) {
		tablero.crearTablero(tamanno);
	}
	
	
}
