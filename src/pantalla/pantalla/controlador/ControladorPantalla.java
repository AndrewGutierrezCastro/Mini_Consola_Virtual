package pantalla.controlador;

import Helpers.Tamanno;
import comunicacion.Comando;
import comunicacion.CreadorObjetos;
import pantalla.modelo.ModeloPantalla;
import pantalla.vista.VistaPantalla;

public class ControladorPantalla implements Runnable{
	
	public ModeloPantalla mPantalla;
	protected VistaPantalla vPantalla;
	private Thread hilo;
	public ControladorPantalla(Tamanno tamanno) {
		mPantalla = new ModeloPantalla(tamanno);
		vPantalla = new VistaPantalla();
		vPantalla.cargarTablero(mPantalla.tablero);
		hilo = new Thread(this);
		hilo.start();
		
	}
	private void ejecutarComando() {
		for (Comando comando : mPantalla.colaComandos) {
			try {
				mPantalla.tablero.actualizar(comando);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void run() {
		Comando comando;
		while(true) {		
			try {
				Thread.sleep(1);
				if(mPantalla.colaRawComandos.size() > 0) {
					for (int i = 0; i < mPantalla.colaRawComandos.size(); i++) {
						mPantalla.colaComandos.add(CreadorObjetos.getComando(mPantalla.colaRawComandos.remove(0)));
					}
					ejecutarComando();
				}
			} catch (InterruptedException e) {
				System.out.println("No se pudo ejecutar el comando");
			}
		}
	}
}
