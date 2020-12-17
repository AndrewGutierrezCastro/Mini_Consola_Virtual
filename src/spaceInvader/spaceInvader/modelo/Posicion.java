package spaceInvader.modelo;


public	class Posicion {
	
	public int x = 0, y = 0;

	public Posicion(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Posicion() {
		super();
		this.x = 19;
		this.y = 0;
	}
	public Posicion Copy() {
		Posicion copia = new Posicion(this.x, this.y);
		return copia;
	}

	public Posicion Mover(Direccion pDireccion) {
		
		Posicion resultado = Copy();
		this.Sumar(pDireccion);
		return resultado;
	}
	public void Sumar(Direccion a) {
		this.x += a.x;
		this.y += a.y;
	}
	public double distancia(Posicion posicion) {
		double resultado = 0.0;
		resultado = Math.sqrt(Math.pow((posicion.x - this.x),2) + Math.pow((posicion.y-this.y),2));
		return  resultado;
	}
	public double distancia(int x, int y) {
		double resultado = 0.0;
		resultado = Math.sqrt(Math.pow((x - this.x),2) + Math.pow((y-this.y),2));
		return  resultado;
	}
	@Override
	public boolean equals(Object obj) {
	
		return ((Posicion)obj).x == this.x & ((Posicion)obj).y == this.y;
	}

	@Override
	public String toString() {
		return "Posicion X: " + x + " Y: " + y;
	}
	public Direccion getDireccion(Posicion posicion) {
		//System.out.println(this+" => "+posicion);
		if(x > posicion.x ) {
			return Direccion.ARRIBA;
		}else if(x < posicion.x) {
			return Direccion.ABAJO;
		}else if(y < posicion.y) {
			return Direccion.DERECHA;
		}else{
			return Direccion.IZQUIERDA;
		}
	}
	
	
	
}

