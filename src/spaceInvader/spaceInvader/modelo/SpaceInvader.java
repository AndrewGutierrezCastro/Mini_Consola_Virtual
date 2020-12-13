package spaceInvader.modelo;

import java.util.ArrayList;
import comunicacion.Comando;
import comunicacion.Comando.TipoComando;
import consola.Consola;
import pantalla.modelo.Casilla;

public class SpaceInvader extends Consola {
	
	
	public SpaceInvader() {
		super();
		ArrayList<Casilla> arr = new ArrayList<Casilla>();
		arr.add(new Casilla(0, 1, 255, "SpaceShip"));
		this.colaComandos.add(new Comando(TipoComando.ACTUALIZARPANTALLA, arr , null));
	}
	
	
	
	
}
