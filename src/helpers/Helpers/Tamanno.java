package Helpers;

public enum Tamanno {
	NORMAL(50,50),
	GRANDE(75,100);
	
	public int x,y;
	Tamanno(int i, int j) {
		this.x = i; this.y = j;
	}
}
