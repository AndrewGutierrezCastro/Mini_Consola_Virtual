package spaceInvader.modelo;

public class Nave implements ConstantesNave{
	public Posicion posicion;
	private Boolean vivo;
	public String nombreImagen;
	
	public Nave(Posicion posicion, String nombreImagen) {
		super();
		this.posicion = posicion;
		this.nombreImagen = nombreImagen;
		this.vivo = true;
	}
	public Nave(Posicion posicion) {
		super();
		this.posicion = posicion;
		this.nombreImagen = nombreImagenEnemigo;
		this.vivo = true;
	}
	public Boolean isVivo() {
		return vivo;
	}
	public void setVivo(Boolean vivo) {
		this.vivo = vivo;
	}
	@Override
	public String toString() {
		return "Nave" + posicion + ", vivo: " + vivo;
	}
	public String getPosicionToString() {
		return posicion.toString();
	}
	
}
