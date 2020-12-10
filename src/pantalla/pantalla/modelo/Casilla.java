package pantalla.modelo;

public class Casilla{
	private int posicionX, posicionY;
	private int color;
	public Casilla(int posicionX, int posicionY, int color) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Casilla [posicionX=" + posicionX + ", posicionY=" + posicionY + ", color=" + color + "]";
	}

	
}
