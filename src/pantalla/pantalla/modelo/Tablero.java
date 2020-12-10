package pantalla.modelo;

import javax.swing.JButton;

import Helpers.Tamanno;

public class Tablero implements ConstantesPantalla{
	/*
	 * La clase tablero tiene un tablero de componentes graficos
	 * */
	public JButton botones[][];
	
	public Tablero(Tamanno tamanno) {
		crearTablero(tamanno);
	}
	
	public void crearTablero(Tamanno tamanno) {
		switch (tamanno) {
		case NORMAL:
			botones = new JButton[normal.x][normal.y];
			break;
		case GRANDE:
			botones = new JButton[grande.x][grande.y];
			break;

		default:
			break;
		}
	}
}
