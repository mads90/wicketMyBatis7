package wicketMyBatis7.dao.ws;

import java.io.ByteArrayOutputStream;

import org.codehaus.jackson.map.ObjectMapper;

import wicketMyBatis7.domain.BaseList;
import wicketMyBatis7.domain.Persona;
import wicketMyBatis7.domain.PersonaSearch;


// JACKSON
public class IOPersona {
	
	public static String writeJson(Object o) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ByteArrayOutputStream buf=new ByteArrayOutputStream();
		mapper.writeValue(buf, o);
		return buf.toString();
	}
	
	public static PersonaSearch readPersonaSearch(String jsonInString) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		PersonaSearch p = mapper.readValue(jsonInString, PersonaSearch.class);
		return p;
	}

	public static String writeListaPersona(BaseList<Persona> ret)  throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ByteArrayOutputStream buf=new ByteArrayOutputStream();
		mapper.writeValue(buf, ret);
		return buf.toString();
	}

	public static Persona readPersona(String jsonInString)  throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Persona p = mapper.readValue(jsonInString, Persona.class);
		return p;
	}

}
