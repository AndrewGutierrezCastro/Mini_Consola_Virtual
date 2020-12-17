package pacman.modelo;

import java.awt.Color;

public class MuroPacman extends CasillaPacman{

	public MuroPacman(int posicionX, int posicionY, String nombreImagen) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.nombreImagen = nombreImagen;
		this.color = Color.RED.getRGB();
	}
}
