package pantalla.controlador;

import comunicacion.Comando;
import comunicacion.CreadorObjetos;
import pantalla.modelo.ModeloPantalla;
import pantalla.vista.VistaPantalla;

public class ControladorPantalla implements Runnable{
	
	public ModeloPantalla mPantalla;
	protected VistaPantalla vPantalla;
	private Thread hilo;
	public ControladorPantalla() {
		mPantalla = new ModeloPantalla();
		vPantalla = new VistaPantalla();
		vPantalla.cargarTablero(mPantalla.tablero);
		hilo = new Thread(this);
		hilo.start();
		
	}
	private void ejecutarComando() {
		for (Comando comando : mPantalla.colaComandos) {
			mPantalla.tablero.actualizar(comando);
		}
	}
	@Override
	public void run() {
		Comando comando;
		while(true) {		
			try {
				Thread.sleep(100);
				if(mPantalla.colaRawComandos.size() > 0) {
					comando = CreadorObjetos.getComando(mPantalla.colaRawComandos.remove(0));
					mPantalla.colaComandos.add(comando);
					ejecutarComando();
				}
			} catch (InterruptedException e) {
				System.out.println("No se pudo ejecutar el comando");
			}
		}
	}
}
