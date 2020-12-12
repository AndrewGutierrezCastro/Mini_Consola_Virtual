package vista_controlador;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import controlador.Teclado;
import javax.swing.JLabel;

public class vTeclado {

	public JFrame frmMandoteclado;
	//el controlador del esta vista
	//la cual es un KeyListener
	private Teclado teclado;
	
	//los botones del mando
	private JButton btnUp, btnDown, btnRight, btnLeft, btnA, btnB, btnStart, btnSelect, btnCenter;
	JLabel lblBackground;

	public vTeclado(Teclado pTeclado) {
		teclado = pTeclado;
		initialize();
		cargarImagenes();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMandoteclado = new JFrame();
		frmMandoteclado.getContentPane().setBackground(Color.WHITE);
		frmMandoteclado.setBackground(Color.WHITE);
		frmMandoteclado.setResizable(false);
		frmMandoteclado.setTitle("Mando-Teclado");
		frmMandoteclado.setBounds(100, 100, 566, 230);
		frmMandoteclado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//crear los botones
		btnUp = new JButton();
		btnDown = new JButton();
		btnLeft = new JButton();
		btnRight = new JButton();
		btnCenter = new JButton();
		
		btnA = new JButton();
		btnB = new JButton();
		
		btnStart = new JButton();
		btnSelect = new JButton();
		
		
		
		//acomodar los botones
		btnUp.setBounds(66, 48, 40, 40);
		btnDown.setBounds(66, 128, 40, 40);
		btnRight.setBounds(106, 88, 40, 40);
		btnLeft.setBounds(26, 88, 40, 40);
		btnCenter.setBounds(66, 88, 40, 40);
		btnCenter.setBorderPainted(false);
		
		btnA.setBounds(442, 88, 60, 80);
		btnB.setBounds(372, 88, 60, 80);
		
		btnStart.setBounds(259, 62, 65, 75);
		btnSelect.setBounds(194, 62, 65, 75);
		
		
		//Agregar los eventos de cada boton
		List<JButton> lstButton = Arrays.asList(
				this.btnUp,
				this.btnDown,
				this.btnRight,
				this.btnLeft,

				this.btnA,
				this.btnB,
				
				this.btnSelect,
				this.btnStart);
		List<Integer> lstBtnCommand = Arrays.asList(
				KeyEvent.VK_UP,
				KeyEvent.VK_DOWN,
				KeyEvent.VK_RIGHT,
				KeyEvent.VK_LEFT,
				
				KeyEvent.VK_Z,
				KeyEvent.VK_X,
				
				KeyEvent.VK_A,
				KeyEvent.VK_S);
		
		for (int i = 0; i < lstButton.size(); i++) {
			JButton boton = lstButton.get(i);
			
			
			boton.setActionCommand(KeyEvent.getKeyText(lstBtnCommand.get(i)) ) ;
			boton.addActionListener(teclado);
			boton.addKeyListener(teclado);
		}
		
		//agregat el layout y los componentes graficos al frame
		frmMandoteclado.getContentPane().setLayout(null);
		
		frmMandoteclado.getContentPane().add(btnUp);
		frmMandoteclado.getContentPane().add(btnDown);
		frmMandoteclado.getContentPane().add(btnRight);
		frmMandoteclado.getContentPane().add(btnLeft);
		frmMandoteclado.getContentPane().add(btnCenter);
		
		frmMandoteclado.getContentPane().add(btnA);
		frmMandoteclado.getContentPane().add(btnB);
			
		frmMandoteclado.getContentPane().add(btnStart);
		frmMandoteclado.getContentPane().add(btnSelect);
		
		lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 555, 200);
		
		
		frmMandoteclado.getContentPane().add(lblBackground);
		frmMandoteclado.setVisible(true);
		
		
		
		
	}

	private void cargarImagenes() {
		Icon ibtnUp, ibtnDown, ibtnRight, ibtnLeft, ibtnCenter,ibtnA, ibtnB, ibtnStart, ibtnSelect, iBackground;
		
		iBackground = Helpers.ManejoImagenes.getImagenResized("Background", ".png", 549, 171);
		lblBackground.setIcon(iBackground);
		
		ibtnUp = Helpers.ManejoImagenes.getImagenResized("btnUp", ".png", 40, 40);
		ibtnDown = Helpers.ManejoImagenes.getImagenResized("btnDown", ".png", 40, 40);
		ibtnRight = Helpers.ManejoImagenes.getImagenResized("btnRight", ".png", 40, 40);
		ibtnLeft = Helpers.ManejoImagenes.getImagenResized("btnLeft", ".png", 40, 40);
		ibtnCenter = Helpers.ManejoImagenes.getImagenResized("btnCenter1", ".png", 40, 40);
		
		ibtnA = Helpers.ManejoImagenes.getImagenResized("btnA", ".png", 60, 80);
		ibtnB = Helpers.ManejoImagenes.getImagenResized("btnB", ".png", 60, 80);
		
		ibtnSelect = Helpers.ManejoImagenes.getImagenResized("btnSelect", ".png", 64, 73);
		ibtnStart = Helpers.ManejoImagenes.getImagenResized("btnStart", ".png", 64, 73);
		
		
		
		List<JButton> lstButton = Arrays.asList(
				this.btnUp,
				this.btnDown,
				this.btnRight,
				this.btnLeft,
				this.btnCenter,
				this.btnA,
				this.btnB,
				this.btnStart,
				this.btnSelect);
		List<Icon> lstIcon = Arrays.asList(
				ibtnUp,
				ibtnDown,
				ibtnRight,
				ibtnLeft,
				ibtnCenter,
				ibtnA,
				ibtnB,
				ibtnStart,
				ibtnSelect);
		for (int i = 0; i < lstButton.size(); i++) {
			lstButton.get(i).setIcon(lstIcon.get(i));
		}
	}
}
