package spaceInvader.modelo;

import java.util.ArrayList;

public class Jugador extends Nave{
	public String nombreImagenDisparo;
	public ArrayList<Disparo> listaDisparos;
	public Jugador(Posicion posicion) {
		super(posicion, nombreImagenNave);
		nombreImagenDisparo = nombreImagenMisilArriba;
		this.listaDisparos = new ArrayList<Disparo>();
	}
	
	
	
}
