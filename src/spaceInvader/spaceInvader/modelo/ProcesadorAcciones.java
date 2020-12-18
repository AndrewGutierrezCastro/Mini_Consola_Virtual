package spaceInvader.modelo;

import java.awt.Color;

import comunicacion.Comando;
import comunicacion.CreadorObjetos;
import pantalla.modelo.Casilla;

public class ProcesadorAcciones implements Runnable, TiemposHilos{
	/* Esta clase es un runnable para estar revisando la cola de comando provenientes
	 * del control y mover la nave del jugador
	 * */
	private SpaceInvader spaceInvader;
	
	public ProcesadorAcciones(SpaceInvader spaceInvader) {
		super();
		this.spaceInvader = spaceInvader;
	}

	@Override
	public void run() {
		Comando comando;
		while(!spaceInvader.juegoTerminado) {
			try {
				Thread.sleep(hiloControl_Consola);
				if(spaceInvader.colaRawComandos.size() > 0) {
					comando = CreadorObjetos.getComando(spaceInvader.colaRawComandos.remove(0));
					ejecutarComando(comando);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void ejecutarComando(Comando comando) {
		switch (comando.a.get(0)) {
		case "DERECHA":
			moverNave(Direccion.DERECHA);
			break;
		case "IZQUIERDA":
			moverNave(Direccion.IZQUIERDA);
			break;
		case "X"://A
			
			break;
		case "Z"://B
			//System.out.println("Zeta");
			Thread disparo = new Thread(new Disparo(spaceInvader, 0));
			disparo.start();
			break;
		case "S"://Select
			
			break;
		case "A"://Start
			
			break;
		default:
			break;
		}
		
	}

	private void moverNave(Direccion direccion) {
		Posicion posicionAnterior = spaceInvader.jugador.posicion.Mover(direccion);
		if(spaceInvader.jugador.posicion.y < 0 || spaceInvader.jugador.posicion.y > spaceInvader.tamanno.y-1) {
			spaceInvader.jugador.posicion = posicionAnterior;
			return;
		}
		spaceInvader.enviarPixel(
				new Casilla(
						posicionAnterior.x,
						posicionAnterior.y,
						Color.DARK_GRAY.getRGB()));
		spaceInvader.enviarPixel(
				new Casilla(
						spaceInvader.jugador.posicion.x,
						spaceInvader.jugador.posicion.y,
						Color.DARK_GRAY.getRGB(),
						spaceInvader.jugador.nombreImagen));
		
	}

}
