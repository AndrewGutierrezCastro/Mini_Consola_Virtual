package spaceInvader.modelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import Helpers.Tupla;
import pantalla.modelo.Casilla;

public class MovimientoNaves implements Runnable, TiemposHilos{
	
	private SpaceInvader spaceInvader;
	private Direccion direccion;
	public MovimientoNaves(SpaceInvader spaceInvader) {
		super();
		this.spaceInvader = spaceInvader;
		direccion = Direccion.DERECHA;
	}
	
	private void revisarYmover() throws InterruptedException {
		switch (direccion) {
		case DERECHA:
			//revisar si la nave de mas a la derecha puede moverse a la derecha antes de ir hacia abajo
			if(spaceInvader.enemigos.get(spaceInvader.enemigos.size()-1).posicion.y >= spaceInvader.tamanno.y-1) {
				direccion = Direccion.ABAJO;
				moverEnemigos();
				direccion = Direccion.IZQUIERDA;
			}else {
				moverEnemigos();
			}
			
			
			break;		
		case IZQUIERDA:
			//revisar si la nave de mas a la izquierda puede moverse a la izquierda antes de ir hacia abajo
			if(spaceInvader.enemigos.get(0).posicion.y <= 0) {
				direccion = Direccion.ABAJO;
				moverEnemigos();
				direccion = Direccion.DERECHA;
			}else {
				moverEnemigos();
			}
			break;
		}
	}
	
	private void moverEnemigos() throws InterruptedException {
		/* Este metodo mueve los enemigos en su movimento predeterminado 
		 * izq-der y abajo
		 * */
		ArrayList<Casilla> casillasAborrar = new ArrayList<Casilla>(),
						   casillasApintar = new ArrayList<Casilla>();

		HashMap<String, Posicion> posicionesAnteriores = new HashMap<String, Posicion>();
		HashMap<String, Nave> posicionesNuevas = new HashMap<String, Nave>();
		Posicion posicionAnterior;
		//Primero mover a las naves vivas
		//y cargar los maps con las posiciones antiguas y nuevas
		for (Nave nave : spaceInvader.enemigos) {
			if(nave.isVivo()) {
				posicionAnterior = nave.posicion.Mover(direccion);
				posicionesNuevas.put(nave.posicion.x+","+nave.posicion.y, nave);
				posicionesAnteriores.put(posicionAnterior.x+","+posicionAnterior.y, posicionAnterior);			
			}
			
		}
		//Revisar si una posicion vieja no esta presente en las posiciones nuevas
		//se debe borrar
		for (String posicionVieja : posicionesAnteriores.keySet()) {
			if(!posicionesNuevas.containsKey(posicionVieja)) {
				posicionAnterior = posicionesAnteriores.get(posicionVieja);
				casillasAborrar.add(new Casilla(posicionAnterior.x, posicionAnterior.y, Color.DARK_GRAY.getRGB()));
			}
			
		}
		//Si una posicion nueva no esta en las posiciones viejas entonces
		//es una posicion jamas antes enviada, por lo tanto pintarla
		for (String posicionNueva : posicionesNuevas.keySet()) {
			if(!posicionesAnteriores.containsKey(posicionNueva)) {
				Nave nave = posicionesNuevas.get(posicionNueva);
				casillasApintar.add(new Casilla(nave.posicion.x, nave.posicion.y,Color.DARK_GRAY.getRGB(), nave.nombreImagen));
			}
		}
		//Con estos 3 procesos se reduce el trafico del socket de toda una matriz de enemigos a un par de columnas
		spaceInvader.enviarPixeles(casillasAborrar);
		Thread.sleep(100);
		spaceInvader.enviarPixeles(casillasApintar);
		//System.out.println(casillasAborrar);
		//System.out.println(casillasApintar);
	}

	@Override
	public void run() {
		while (true) {
			
			try {
				Thread.sleep(velocidadMovimiento);
				revisarYmover();
			} catch (InterruptedException e) {
				System.out.println("Sleep de movimientoNaves fallo");
				e.printStackTrace();
			}
			
			
			//spaceInvader.mostrarEnemigos();
		}
		
		
	}

}
