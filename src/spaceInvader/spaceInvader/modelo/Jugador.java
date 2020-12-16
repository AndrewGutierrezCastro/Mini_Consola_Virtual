package spaceInvader.modelo;

public class Jugador extends Nave{
	public String nombreImagenDisparo;
	public Jugador(Posicion posicion) {
		super(posicion, nombreImagenNave);
		nombreImagenDisparo = nombreImagenMisilArriba;
	}
	
	
	
}
