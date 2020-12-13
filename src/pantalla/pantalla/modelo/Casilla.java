package pantalla.modelo;
import javax.swing.ImageIcon;

public class Casilla{
	public int posicionX, posicionY;
	public int color;
	public String nombreImagen;
	public Casilla(int posicionX, int posicionY, int color) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.color = color;
	}
	
	public Casilla(int posicionX, int posicionY, int color, String nombreImagen) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.color = color;
		this.nombreImagen = nombreImagen;
	}

	@Override
	public String toString() {
		return "Casilla [posicionX=" + posicionX + ", posicionY=" + posicionY + ", color=" + color + "]";
	}

	
}
