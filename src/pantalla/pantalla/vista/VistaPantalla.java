package pantalla.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import pantalla.modelo.Tablero;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class VistaPantalla {

	private JFrame frame;
	private JPanel panel;
	
	public VistaPantalla() {
		initialize();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 773, 797);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(5, 5, 750, 750);
		frame.getContentPane().add(panel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 750, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
	}
	
	public void cargarTablero(Tablero pTablero) {
		/* Este metodo recibe un objeto tablero el cual se necesita
		 * para cargar la matriz de botones
		 * */
		JButton boton;
		for (int i = 0; i < pTablero.botones.length; i++) {
            
            for (int j = 0; j < pTablero.botones[0].length; j++) {
            	boton = pTablero.botones[i][j];
            	this.panel.add(boton);
            	boton.setBounds(15*j, 15*i, 15, 15);
                boton.setFocusable(false);
                boton.setOpaque(true);
                boton.setEnabled(false);
                boton.setBorderPainted(false);
                boton.setBackground(Color.DARK_GRAY);
			}
		}
	}
}
