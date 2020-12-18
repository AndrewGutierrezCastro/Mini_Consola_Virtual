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
		AP,
		DE,
		GO;
	}
	public TipoComando c;
	public List<Casilla> p;
	public List<String> a;
	public Comando(TipoComando comando, List<Casilla> pixeles, List<String> acciones) {
		super();
		this.c = comando;
		this.p = pixeles;
		this.a = acciones;
	}
	
	@Override
	public String toString() {
		return "Comando [comando=" + c + ", pixeles=" + p + ", acciones=" + a + "]";
	}
	
	
	
}
