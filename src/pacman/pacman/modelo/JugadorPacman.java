package pacman.modelo;

import java.awt.Color;
import java.util.ArrayList;

import comunicacion.Comando;

public class JugadorPacman extends CasillaPacman{

	private VacioPacman espaciovacio;
	public CasillaPacman[][] casillas;
	public String direccionMovimiento;
	
	public JugadorPacman(int posicionX, int posicionY, String nombreImagen) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.nombreImagen = nombreImagen;
		this.color = Color.YELLOW.getRGB();
		this.espaciovacio = new VacioPacman(this.posicionX,this.posicionY,"");
		this.direccionMovimiento = "LEFT";
		// TODO Auto-generated constructor stub
	}

	public CasillaPacman[] moverse() {
		
		CasillaPacman[] casillas = new CasillaPacman[2];
		
		Integer[] posicion = this.obtenerXY();
		CasillaPacman casilla = this.casillas[posicion[0]][posicion[1]];
		if (!this.isMuro(casilla)) {
			
			this.casillas[this.posicionX][this.posicionY] = new VacioPacman(this.posicionX, this.posicionY, "");
			casillas[0] = this.casillas[this.posicionX][this.posicionY];
			
			this.setXY(casilla.posicionX, casilla.posicionY, this);
			this.casillas[this.posicionX][this.posicionY] = this;
			casillas[1] = this.casillas[this.posicionX][this.posicionY];
			
		}
		return casillas;
	}

	private Integer[] obtenerXY(){
		Integer[] posicion = new Integer[2];
		int x = this.posicionX;
		int y = this.posicionY;
		
		System.out.println(direccionMovimiento);
		switch(this.direccionMovimiento) {
		case "UP":
			x--;
			break;
		case "DOWN":
			x++;
			break;
		case "LEFT":
			y--;
			break;
		case "RIGHT":
			y++;
			break;
		}
		posicion[0] = x;
		posicion[1] = y;
		return posicion;
	}
	
	private void setXY(int x, int y , CasillaPacman casilla) {
		casilla.posicionX = x;
		casilla.posicionY = y;
	}
	
	public void setDireccion(String direccion) {
		this.direccionMovimiento = direccion;
	}
	
	private boolean isMuro(CasillaPacman casilla) {

		if ((casilla.getClass().getSimpleName()).equals("MuroPacman")) {
			return true;
		}
		return false;
	}
	
	public void verificarMuro() {
		
	}
}
