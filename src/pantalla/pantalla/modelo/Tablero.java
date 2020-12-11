package pantalla.modelo;

import java.awt.Color;

import javax.swing.JButton;

import Helpers.Tamanno;
import comunicacion.Comando;

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
		JButton boton;
		for (int i = 0; i < botones.length; i++) {
            
            for (int j = 0; j < botones[0].length; j++) {
            	boton = new JButton();
            	botones[i][j] = boton;
			}
		}
	}

	public void actualizar(Comando comando) {
		for (Casilla casilla : comando.pixeles) {
			botones[casilla.posicionX][casilla.posicionY].
				setBackground(
						new Color(casilla.color));
			
			botones[casilla.posicionX][casilla.posicionY].setContentAreaFilled(false);
			botones[casilla.posicionX][casilla.posicionY].setOpaque(true);

		}
	}
}
