package spaceInvader.modelo;

import java.awt.Color;
import java.util.ArrayList;
import Helpers.Tamanno;
import comunicacion.Comando;
import comunicacion.Comando.TipoComando;
import consola.Consola;
import pantalla.modelo.Casilla;

public class SpaceInvader extends Consola {
	
	//Lista de enemigos
	public ArrayList<Nave> enemigos;
	
	public Jugador jugador;
	private MovimientoNaves movimientoNaves;
	private ProcesadorAcciones procesadorAcciones;
	private Thread hiloMovimientoEnemigos;
	private Thread hiloProcesadorAcciones;
	public Tamanno tamanno;
	public final int filasEnemigos = 2, colEnemigos = 8;
	
	
	public SpaceInvader(Tamanno tamanno) {
		super();
		this.tamanno = tamanno;
		enemigos = new ArrayList<Nave>();
		crearEnemigos();
		//mostrarEnemigos();
		
		movimientoNaves = new MovimientoNaves(this);
		hiloMovimientoEnemigos = new Thread(movimientoNaves);
		
		procesadorAcciones = new ProcesadorAcciones(this);
		hiloProcesadorAcciones = new Thread(procesadorAcciones);
		
		crearJugador();
		
		hiloMovimientoEnemigos.start();
		hiloProcesadorAcciones.start();
	}
	
	private void crearJugador() {
		/* Este metodo instancia los enemigos en la posicion predeterminada
		 * 
		 * */
		jugador = new Jugador(new Posicion(49, 24));
		
		ArrayList<Casilla> arr = new ArrayList<Casilla>();
		arr.add(new Casilla(jugador.posicion.x, jugador.posicion.y, Color.DARK_GRAY.getRGB(), jugador.nombreImagen));
		enviarPixeles(arr);
		
		
	}

	private void crearEnemigos() {
		/*
		 * Este metodo instancia los enemigos en la posicion predeterminada
		 * */
		Nave enemigo;
		for (int i = 0; i < filasEnemigos; i++) {
			for (int j = 41; j < colEnemigos+41; j++) {
				enemigo = new Nave(new Posicion(i,j));
				enemigos.add(enemigo);
				
			}
		}
	}
	
	public void mostrarEnemigos() {
		/* Este metodo crea el comando para enviar la posicion actual de los enemigos
		 * */
		ArrayList<Casilla> enemigosComando = new ArrayList<Casilla>();
		for (Nave nave : enemigos) {
			enemigosComando.add(new Casilla(nave.posicion.x, nave.posicion.y, Color.DARK_GRAY.getRGB(), nave.nombreImagen));
		}
		this.colaComandos.add(new Comando(TipoComando.AP, enemigosComando, null));
	}
	
	public void enviarPixeles(ArrayList<Casilla> pPixeles) {
		this.colaComandos.add(new Comando(TipoComando.AP, pPixeles , null));
		System.out.println(colaComandos.get(colaComandos.size()-1));
	}
	
	public void enviarPixel(Casilla pCasilla) {
		ArrayList<Casilla> pPixeles = new ArrayList<Casilla>();
		pPixeles.add(pCasilla);
		this.colaComandos.add(new Comando(TipoComando.AP, pPixeles , null));
	}

}
