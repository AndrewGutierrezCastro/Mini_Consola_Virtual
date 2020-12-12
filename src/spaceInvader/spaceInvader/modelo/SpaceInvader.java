package spaceInvader.modelo;

import java.io.IOException;
import comunicacion.Servidor;
import controlador.ConstantesComunicacion;

public class SpaceInvader {
	public Servidor servidor;

	public SpaceInvader() {
		try {
			servidor = new Servidor(ConstantesComunicacion.Controlador_Consola);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
