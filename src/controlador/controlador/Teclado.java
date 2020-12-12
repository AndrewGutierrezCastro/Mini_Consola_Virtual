package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import comunicacion.Comando;
import comunicacion.Comando.TipoComando;
import vista_controlador.vTeclado;

public class Teclado extends DispositivoEntrada implements KeyListener, ActionListener{
	
	private vTeclado vTeclado;
	
	
	public Teclado() {
		super();
		vTeclado = new vTeclado(this);
	}
	
	private void procesarEntrada(String tecla) {
		ArrayList<String> acciones = new ArrayList<String>();
		acciones.add(tecla);
		enviarComando(new Comando(TipoComando.DISPOSITIVOENTRADA, null, acciones));
		System.out.println("Comando enviado: "+acciones);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		String tecla = e.getKeyText(e.getKeyCode());
		tecla = tecla.toUpperCase();
		procesarEntrada(tecla);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		procesarEntrada(e.getActionCommand().toUpperCase());
	}
}
