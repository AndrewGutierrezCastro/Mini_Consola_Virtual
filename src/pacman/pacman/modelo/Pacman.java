package pacman.modelo;

import java.awt.Color;
import java.util.ArrayList;

import Helpers.ManejoArchivo;
import comunicacion.Comando;
import comunicacion.CreadorObjetos;
import comunicacion.Comando.TipoComando;
import consola.Consola;
import pantalla.modelo.Casilla;

public class Pacman extends Consola implements Runnable{

	private Thread hiloAccion;
	private CasillaPacman[][] matrizPacman;
	private JugadorPacman jugador;
	
	public Pacman() {
		
		super();
		this.matrizPacman = new CasillaPacman[50][50];
		
		this.cargarComida();
		this.cargarMapa();
		this.cargarJugador();
		
		this.hiloAccion = new Thread(this);
		this.hiloAccion.start();
	}
	
	private void cargarComida() {
		
		ArrayList<Casilla> arr = new ArrayList<Casilla>();
		for (int i = 0; i < matrizPacman.length; i++) {
			
			for (int j = 0; j < matrizPacman.length; j++) {
				this.matrizPacman[i][j] = new ComidaPacman(i, j, "");
				arr.add(new Casilla(i, j,this.matrizPacman[i][j].color, ""));
			}
		}
		Comando comando = new Comando(TipoComando.AP, arr , null);
		this.colaComandos.add(comando);
	}
	
	private void cargarMapa() {
		/*
		 * Carga los muros del juego
		 */
		
		Comando comando = CreadorObjetos.getComando(ManejoArchivo.readJson("PACMANMURO"));
		System.out.println(comando);
		for (Casilla casilla : comando.p) {
			
			casilla.nI = "";
			this.matrizPacman[casilla.X][casilla.Y] = new MuroPacman(casilla.X, 
					casilla.Y,"muroPacman");
		}
		
		this.colaComandos.add(comando);
	}
	
	private void cargarJugador() {
		/*
		 * Carga al jugador o pacman
		 */
		this.jugador = new JugadorPacman(25, 25, "");
		this.matrizPacman[this.jugador.posicionX][this.jugador.posicionY] = this.jugador;
		this.colaComandos.add(crearComando(this.jugador));
		this.jugador.casillas = this.matrizPacman;
	}
	
	private Comando crearComando(CasillaPacman casilla) {
		/*
		 * Crea un comando
		 */
		ArrayList<Casilla> arr = new ArrayList<Casilla>();
		arr.add(new Casilla(casilla.posicionX, casilla.posicionY, casilla.color, casilla.nombreImagen));
		Comando comando = new Comando(TipoComando.AP, arr , null);
		return comando;
	}

	@Override
	public void run() {
		
		Comando comando;
		while(true) {	
			
			try {
				Thread.sleep(500);
				
				if (this.colaRawComandos.size() > 0) {
					
					comando = CreadorObjetos.getComando(this.colaRawComandos.remove(0));		
					this.jugador.setDireccion(comando.a.get(0));
					
//					CasillaPacman[] casillas = this.jugador.moverse();
//					if (casillas[0] != null) {
//						this.colaComandos.add(crearComando(casillas[0]));
//						this.colaComandos.add(crearComando(casillas[1]));
//					}
					
				}
				
				CasillaPacman[] casillas = this.jugador.moverse();
				if (casillas[0] != null) {
					this.colaComandos.add(crearComando(casillas[0]));
					this.colaComandos.add(crearComando(casillas[1]));
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
