package pantalla.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import comunicacion.Comando;
import comunicacion.CreadorObjetos;
import pantalla.modelo.ModeloPantalla;
import pantalla.vista.VistaPantalla;

public class ControladorPantalla implements ActionListener, Runnable{
	private class PrintTxtArea implements Runnable{
		private JTextArea txtArea;
		private ArrayList<String> comandos;
		
		


		public PrintTxtArea(JTextArea txtArea, ArrayList<String> comandos) {
			super();
			this.txtArea = txtArea;
			this.comandos = comandos;
		}




		@Override
		public void run() {
			Comando comando;
			while(true) {		
				try {
					Thread.sleep(2000);
					if(comandos.size() > 0) {
						comando = CreadorObjetos.getComando(comandos.remove(0));
						
						txtArea.setText(
							txtArea.getText()+"\n"+comando.toString()
							);
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public ModeloPantalla mPantalla;
	protected VistaPantalla vPantalla;
	private Thread hilo;
	public ControladorPantalla() {
		vPantalla = new VistaPantalla(this);
		mPantalla = new ModeloPantalla();
		vPantalla.textArea.setText("Josue el Marimbero");
		hilo = new Thread(this);
		hilo.start();
		new Thread(new PrintTxtArea(vPantalla.textArea, mPantalla.colaComandos)).start();
	}
	
	public void recibirMensajesMostrar() {
		
		try {
			mPantalla.servidor.aceptarCliente();
			mPantalla.servidor.esperarMensaje();
			mPantalla.servidor.cerrarCliente();
			mPantalla.colaComandos.add(mPantalla.servidor.getMensaje());
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
				Thread.sleep(100);
				recibirMensajesMostrar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
