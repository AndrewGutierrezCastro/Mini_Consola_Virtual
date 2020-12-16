package pantalla.modelo;

public class Casilla{
	public int X, Y;
	public int c;
	public String nI;
	public Casilla(int posicionX, int posicionY, int color) {
		super();
		this.X = posicionX;
		this.Y = posicionY;
		this.c = color;
	}
	
	public Casilla(int posicionX, int posicionY, int color, String nombreImagen) {
		super();
		this.X = posicionX;
		this.Y = posicionY;
		this.c = color;
		this.nI = nombreImagen;
	}

	@Override
	public String toString() {
		return "Casilla [posicionX=" + X + ", posicionY=" + Y + ", color=" + c + ", nombreImagen="
				+ nI + "]";
	}

	
}
