import java.awt.EventQueue;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import Helpers.ManejoArchivo;
import comunicacion.Comando;
import comunicacion.Comando.TipoComando;
import comunicacion.CreadorObjetos;
import controlador.DispositivoEntrada;
import pantalla.controlador.ControladorPantalla;

public class Main {

	public static void main(String[] args) {
		
		
		  main2(args); 
		  DispositivoEntrada dp = new DispositivoEntrada();
		  System.out.println("Hola mundo"); 
		  FileReader file = ManejoArchivo.readJson(TipoComando.ACTUALIZARPANTALLA.toString());
		  Comando comando = CreadorObjetos.getComando(file);
		  String str = CreadorObjetos.getJson(comando); 
		  dp.enviarMensaje(str); 
		  
		  
	}

	private static Comando getListProducts(JsonObject obj) {
		Gson gson = new Gson();
		JsonObject jo = (JsonObject) obj; // Casteo de objeto a objeto Json
		// String data = jo.get("products").toString(); //Tener un string que es la info
		// de la parte de data
		String data = jo.toString();
		Type tipoListaEmpleados = new TypeToken<Comando>() {
		}.getType(); // crear un type para los productos
		return gson.fromJson(data, tipoListaEmpleados); // crear la lista de los productos
	}

	public static Comando getListProducts(String data) {
		Document doc = Jsoup.parse(data);
		Element products = doc.html(doc.body().toString());
		JsonObject obj = (JsonObject) new JsonParser().parse(products.toString());
		return getListProducts(obj);
	}

	public static void main2(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControladorPantalla ctPan = new ControladorPantalla();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
