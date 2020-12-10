package pantalla.modelo;

import javax.swing.JButton;

import Helpers.Tamanno;

public class Tablero implements ConstantesPantalla{
	/*
	 * La clase tablero tiene un tablero de componentes graficos
	 * */
	public JButton casillas[][];
	
	public Tablero(Tamanno tamanno) {
		crearTablero(tamanno);
	}
	
	public void crearTablero(Tamanno tamanno) {
		switch (tamanno) {
		case NORMAL:
			casillas = new JButton[normal.x][normal.y];
			break;
		case GRANDE:
			casillas = new JButton[grande.x][grande.y];
			break;

		default:
			break;
		}
	}
}
