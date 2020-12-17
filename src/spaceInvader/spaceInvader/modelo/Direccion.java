package spaceInvader.modelo;

public enum Direccion {

	ARRIBA(-1,0),
	ABAJO(1,0),
	DERECHA(0,1),
	IZQUIERDA(0,-1);
	
	public int x;
	public int y;
	private Direccion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
