package comunicacion; 

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class CreadorObjetos {
	/* Esta clase es una creadora de objetos dados un string
	 * con formato Json o bien un FileReader del json en cuestion
	 * 
	 * Ademas sus atributos son singelton ya que se espera ser
	 * bastante utilizado y ahorrar memoria es necesario
	 * */
	
	private static CreadorObjetos self;
	private static JsonParser jsonParser;
	private static Gson gson;
	
	
	public CreadorObjetos() {
		jsonParser = new JsonParser();
		gson = new Gson();
	}

	public static Comando getComando(String data) {
		//Si no existen los atributos crearlos
		getInstance();
		
		//Crear una referencia a un JsonElement dado por el parseo
		//de la data en forma de string
		JsonElement jsonElement = jsonParser.parse(data);
		
		//retornar un comando instanciado
		return gson.fromJson(jsonElement, Comando.class);
	}
	
	public static Comando getComando(FileReader data) {
		//Si no existen los atributos crearlos
		getInstance();
		
		//Crear una referencia a un JsonElement dado por el parseo
		//de la data en forma de FileReader
		JsonElement jsonElement = jsonParser.parse(data);
		
		//retornar un comando instanciado
		return gson.fromJson(jsonElement, Comando.class);
	}
	
	public static String getJson(Object obj) {
		//Si no existen los atributos crearlos
		getInstance();
		//retornar el string del objeto en formato json
		return gson.toJson(obj);
	}
	
	private static CreadorObjetos getInstance() {
		if (self == null)
			self = new CreadorObjetos();
		return self;
	}
}
