package spaceInvader.modelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.collections4.MapUtils;

import pantalla.modelo.Casilla;

public class Disparo implements Runnable, TiemposHilos{
	/* La clase disparo es un disparo que se genera de la posicion del jugador
	 * avanza hacia arriba por un timepo predeterminado hasta llegar a la fila -1 
	 * o bien chocar con alguna nave
	 * 
	 * */
	private SpaceInvader spaceInvader;
	private ArrayList<Nave> enemigos;
	private HashMap<String, Nave> posiciones;
	private Posicion posicion;
	private int bordeDisparo;
	private Jugador jugador;
	
	public Disparo(SpaceInvader pSpaceInvader, int pBordeDisparo) {
		super();
		this.bordeDisparo = pBordeDisparo;
		this.spaceInvader = pSpaceInvader;
		this.enemigos = spaceInvader.enemigos;
		this.posicion = spaceInvader.jugador.posicion.Copy();
		this.jugador = spaceInvader.jugador;
		this.jugador.listaDisparos.add(this);
	}


	@Override
	public void run() {
		posiciones = new HashMap<String, Nave>();
		Posicion posicionAnterior;
		posicionAnterior = posicion.Mover(Direccion.ARRIBA);
		while(Math.abs(bordeDisparo - posicion.x) > 0) {
			
			try {
				MapUtils.populateMap(posiciones, enemigos, Nave::getPosicionToString);//mapear las naves con la posicion
				if(posiciones.get(posicion.toString()) != null && posiciones.get(posicion.toString()).isVivo()) {
					//existe una nave en esa posicion
					spaceInvader.enviarPixel(new Casilla(posicion.x, posicion.y, Color.RED.getRGB()));
					posiciones.get(posicion.toString()).setVivo(false);
					jugador.listaDisparos.remove(this);
					break;
				}
				posicionAnterior = posicion.Mover(Direccion.ARRIBA);
				posiciones.clear();
				//Borrar el pixel anterior 
				spaceInvader.enviarPixel(new Casilla(posicionAnterior.x, posicionAnterior.y, Color.DARK_GRAY.getRGB()));
				//Pintar el nuevo pixel
				spaceInvader.enviarPixel(new Casilla(posicion.x, posicion.y, Color.DARK_GRAY.getRGB(), spaceInvader.jugador.nombreImagenDisparo));
				
				Thread.sleep(velocidadDisparo);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		spaceInvader.enviarPixel(new Casilla(posicion.x, posicion.y, Color.RED.getRGB()));
		
	}
	
}
