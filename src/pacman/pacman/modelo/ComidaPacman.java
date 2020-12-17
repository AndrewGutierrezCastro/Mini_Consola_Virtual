package pacman.modelo;

import java.awt.Color;

public class ComidaPacman extends CasillaPacman{
	
	public ComidaPacman(int posicionX, int posicionY, String nombreImagen) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.nombreImagen = nombreImagen;
		this.color = Color.GRAY.getRGB();
	}
}
