package pantalla.controlador;

import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Helpers.Tamanno;
import comunicacion.Comando;
import comunicacion.Comando.TipoComando;
import comunicacion.CreadorObjetos;
import pantalla.modelo.ModeloPantalla;
import pantalla.vista.VistaPantalla;

public class ControladorPantalla implements Runnable{
	
	public ModeloPantalla mPantalla;
	protected VistaPantalla vPantalla;
	private Thread hilo;
	private Boolean corriendo = true;
	public ControladorPantalla(Tamanno tamanno) {
		mPantalla = new ModeloPantalla(tamanno);
		vPantalla = new VistaPantalla();
		vPantalla.cargarTablero(mPantalla.tablero);
		hilo = new Thread(this);
		hilo.start();
		
	}
	private void aceptarCliente() {
		try {
			mPantalla.servidor.aceptarCliente();
		} catch (IOException e) {
			System.out.println("No se pudo aceptar al cliente consola en la pantalla");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void ejecutarComando() {
		while(mPantalla.colaComandos.size() > 0) {
			try {
				if(mPantalla.colaComandos.get(0).c == TipoComando.GO) {
					mPantalla.colaComandos.remove(0);
					corriendo = false;
					mostrarGameOver();
					
				}
				mPantalla.tablero.actualizar(mPantalla.colaComandos.remove(0));
			}catch(Exception e) {
				System.out.println("No se pudo actualizar la pantalla");
			}
		}
	}
	private void mostrarGameOver() {
		JButton boton = new JButton();
		vPantalla.frame.add(boton);
		boton.setIcon((ImageIcon) Helpers.ManejoImagenes.getImagenResized("GameOver", ".png", 500, 500));
		boton.setBounds(100, 100, 500, 500);
		boton.setOpaque(true);
        boton.setEnabled(false);
        boton.setBorderPainted(false);
        boton.setBackground(Color.DARK_GRAY);
	}
	@Override
	public void run() {
		Comando comando;
		//aceptarCliente();
		String strComando ="";
		while(corriendo) {		
			try {
				Thread.sleep(16);
				while(mPantalla.colaRawComandos.size() > 0) {
					
					strComando = mPantalla.colaRawComandos.get(0);
					try {
						mPantalla.colaComandos.add(CreadorObjetos.getComando(mPantalla.colaRawComandos.remove(0)));
					}catch(NullPointerException ne) {
						System.out.println("Comando no se pudo obtener: ");
					}
				}
				//System.out.println(mPantalla.colaComandos.size()+" comando agregados");
				ejecutarComando();
				//System.out.println(strComando);
			} catch (InterruptedException e) {
				System.out.println("No se pudo ejecutar el comando");
			} catch (com.google.gson.JsonSyntaxException gsonE) {
				System.out.println("El comando no se pudo parsear"+strComando );
			}
		}
	}
}
