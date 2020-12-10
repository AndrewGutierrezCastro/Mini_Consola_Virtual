import java.awt.EventQueue;
import java.io.FileReader;
import java.lang.reflect.Type;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import Helpers.ManejoArchivo;
import comunicacion.Comando;
import comunicacion.CreadorObjetos;
import comunicacion.Comando.TipoComando;
import pantalla.controlador.ControladorPantalla;


public class Main {

	public static void main(String[] args) {
		
		/*
		 * main2(args); DispositivoEntrada dp = new DispositivoEntrada();
		 * System.out.println("Hola mundo"); Scanner sc= new Scanner(System.in);
		 * //System.in is a standard input stream String str; str = sc.nextLine();
		 * dp.enviarMensaje(str); while((str = sc.nextLine()) != "q") {
		 * dp.enviarMensaje(str);
		 * 
		 * }
		 */
		FileReader file = ManejoArchivo.readJson(TipoComando.DISPOSITIVOENTRADA.toString());
		Comando comando = CreadorObjetos.getComando(file);
		
		
		
		System.out.println(CreadorObjetos.getComando(CreadorObjetos.getJson(comando)));
	}
	
	private static Comando getListProducts(JsonObject obj) {
		Gson gson = new Gson();
		JsonObject jo = (JsonObject) obj; //Casteo de objeto a objeto Json
        //String data = jo.get("products").toString(); //Tener un string que es la info de la parte de data
        String data = jo.toString();
		Type tipoListaEmpleados = new TypeToken<Comando>(){}.getType(); //crear un type para los productos
    	return gson.fromJson(data, tipoListaEmpleados); //crear la lista de los productos
	}
	
	public static Comando getListProducts(String data){
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
