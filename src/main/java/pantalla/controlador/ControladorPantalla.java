package pantalla.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import pantalla.modelo.ModeloPantalla;
import pantalla.vista.VistaPantalla;

public class ControladorPantalla implements ActionListener, Runnable{
	public ModeloPantalla mPantalla;
	protected VistaPantalla vPantalla;
	private Thread hilo;
	public ControladorPantalla() {
		vPantalla = new VistaPantalla(this);
		mPantalla = new ModeloPantalla();
		vPantalla.textArea.setText("Josue el Marimbero");
		hilo = new Thread(this);
	}
	
	public void recibirMensajesMostrar() {
		
		try {
			mPantalla.servidor.aceptarCliente();
			mPantalla.servidor.esperarMensaje();
			mPantalla.servidor.cerrarCliente();
			vPantalla.textArea.setText(vPantalla.textArea.getText()+"\n"+
			mPantalla.servidor.getMensaje());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		
	}

	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "IniciarServidor":
			hilo.start();
			vPantalla.btnIniciarServidor.setEnabled(false);
			break;

		default:
			break;
		}
		
	}

	@Override
	public void run() {
		
		while(true) {		
			try {
				Thread.sleep(2000);
				recibirMensajesMostrar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
