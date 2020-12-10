package spaceInvader.modelo;

import java.io.IOException;

import comunicacion.Servidor;
import controlador.ConstantesComunicacion;

public class Tetris {
	public Servidor servidor;

	public Tetris() {
		try {
			servidor = new Servidor(ConstantesComunicacion.Controlador_Consola);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
