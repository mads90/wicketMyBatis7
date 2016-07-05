package wicketMyBatis7.dao.ws;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wicketMyBatis7.domain.BaseList;
import wicketMyBatis7.domain.Persona;
import wicketMyBatis7.domain.PersonaSearch;
import wicketMyBatis7.logic.OspedaleManager;

public class WSUpdatePersona extends HttpServlet {

	private BaseList<Persona> persone;
	private Persona persona;
	

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		
		OspedaleManager manager = getOspedaleManager();
		
		manager.tx_salvaPersonaTutto(persona);
		
	}

	private OspedaleManager getOspedaleManager() {
		return new OspedaleManager();
	}

	public BaseList<Persona> getPersone() {
		return persone;
	}

	public void setPersone(BaseList<Persona> persone) {
		this.persone = persone;
	}
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
