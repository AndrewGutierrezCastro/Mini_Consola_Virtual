package comunicacion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import controlador.ConstantesComunicacion;


public class Servidor implements ConstantesComunicacion{
	/* Clase: Servidor
	 * La clase para recibir informacion de un cliente
	 * 
	 * */
	private String mensaje; 				//atributo donde el mensaje se va a recibir el mensaje
	protected ServerSocket serverSocket;	//Socket del servidor
	protected Socket clienteSocket; //socket que va a utilizar el cliente
	protected DataOutputStream salidaCliente; //La salida de datos de cliente
	
	private InputStream inputStream; 
	private InputStreamReader inputStreamReader;
	private BufferedReader entrada;
	
	public Servidor(int pPuerto) throws IOException {
		serverSocket = new ServerSocket(pPuerto); //Puerto es un numero constante
		
		serverSocket.setReceiveBufferSize(serverSocket.getReceiveBufferSize()*2);
		//de la interfaz de constantes para comunicacion.
		
	}
	public void aceptarCliente() throws IOException {
		//Aceptar e instanciar localmente al atributo cliente
		clienteSocket = serverSocket.accept();

		//obtener el stream de datos del cliente
		inputStream = clienteSocket.getInputStream();
		inputStreamReader = new InputStreamReader(inputStream);
		entrada = new BufferedReader(inputStreamReader);
		
		System.out.println("cliente aceptado");
	}
	
	public void cerrarServidor() throws IOException {
		//Cerrar el socket del servidor
		serverSocket.close();
	}
	
	public void cerrarCliente() throws IOException {
		//cerrar el socket del cliente
		clienteSocket.close();
	}
	
	public void esperarMensaje() {
		//Necesario para recibir el mensaje del cliente

		char[] linea;
		mensaje = "";
		int ah, al;
		try {
			/*El cliente envia en formato UTF los dos primeros bytes son para  */
			/*
			ah = entrada.read();
			al = entrada.read(); //Mientras haya lineas desde el cliente
			ah = Integer.rotateLeft(ah, 16);
			ah += al;
			linea = new char[ah];
			entrada.read(linea, 0, ah);
			mensaje = String.valueOf(linea);*/
			
			mensaje = entrada.readLine();
			//System.out.println(mensaje);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 

		
		//System.out.println("mensaje recibido "+mensaje);

		
	}
	
	private void enviarRespuesta() throws IOException {
		//obtener el flujo de informacion para enviarle mensajes
		OutputStream outputStream = clienteSocket.getOutputStream();
		salidaCliente = new DataOutputStream(outputStream);
		salidaCliente.writeUTF("Mensaje respuesta del puerto: "+serverSocket.getLocalPort());
		
	}
	
	public String getMensaje() {
		return mensaje;
	}
}

