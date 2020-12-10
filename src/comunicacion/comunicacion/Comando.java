package comunicacion;

import java.util.List;
import pantalla.modelo.Casilla;

public class Comando {
	
	public enum TipoComando{
		ACTUALIZARPANTALLA,
		DISPOSITIVOENTRADA;
	}
	private TipoComando comando;
	private List<Casilla> pixeles;
	private List<String> acciones;
	public Comando(TipoComando comando, List<Casilla> pixeles, List<String> acciones) {
		super();
		this.comando = comando;
		this.pixeles = pixeles;
		this.acciones = acciones;
	}
	
	@Override
	public String toString() {
		return "Comando [comando=" + comando + ", pixeles=" + pixeles + ", acciones=" + acciones + "]";
	}
	
	
	
}
