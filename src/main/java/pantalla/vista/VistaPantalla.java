package pantalla.vista;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import pantalla.controlador.ControladorPantalla;
import javax.swing.JButton;

public class VistaPantalla {

	private JFrame frame;
	public JTextArea textArea;
	public ControladorPantalla controlador;
	public JButton btnIniciarServidor;
	public VistaPantalla(ControladorPantalla pControlador) {
		controlador = pControlador;
		initialize();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 11, 393, 213);
		frame.getContentPane().add(textArea);
		
		btnIniciarServidor = new JButton("Iniciar Servidor");
		btnIniciarServidor.addActionListener(controlador);
		btnIniciarServidor.setActionCommand("IniciarServidor");
		btnIniciarServidor.setBounds(266, 235, 137, 23);
		frame.getContentPane().add(btnIniciarServidor);
	}
}
