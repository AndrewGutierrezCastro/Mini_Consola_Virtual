package comunicacion;

import java.util.List;
import pantalla.modelo.Casilla;

public class Comando {
	/*
	 * {
	"comando": "ACTUALIZARPANTALLA",
	"acciones": [],
	"pixeles":[{
		
			"posicionX": 0,
			"posicionY": 0,
			"color": 0
		},
		{
			"posicionX": 1,
			"posicionY": 1,
			"color": 0
		}
	]

	} o bien
	{
		"comando": "DISPOSITIVOENTRADA",
		"acciones":[
			"Right",
			"Up"
		],
		"pixeles":[]
	}
	 * */
	public enum TipoComando{
		ACTUALIZARPANTALLA,
		DISPOSITIVOENTRADA;
	}
	private TipoComando comando;
	public List<Casilla> pixeles;
	public List<String> acciones;
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
