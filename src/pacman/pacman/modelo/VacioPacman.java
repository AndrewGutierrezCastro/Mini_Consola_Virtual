package pacman.modelo;

import java.awt.Color;

public class VacioPacman extends CasillaPacman{

	public VacioPacman(int posicionX, int posicionY, String imagen) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.nombreImagen = imagen;
		this.color = Color.GRAY.getRGB();
		
	}
}
