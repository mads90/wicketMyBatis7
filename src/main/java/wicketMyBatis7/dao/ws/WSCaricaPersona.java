package wicketMyBatis7.dao.ws;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wicketMyBatis7.domain.BaseList;
import wicketMyBatis7.domain.Persona;
import wicketMyBatis7.domain.PersonaSearch;
import wicketMyBatis7.logic.OspedaleManager;

public class WSCaricaPersona extends HttpServlet {

	public BaseList<Persona> ret;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		
		OspedaleManager manager = getOspedaleManager();
		ret =manager.tx_loadPersona(new PersonaSearch());
		/*for (int i = 0; i < ret.getList().size(); i++) 
		{
			System.out.println( ret.getList().get(i));
		}*/
		
		/*
		try {
			OspedaleManager manager = getOspedaleManager();
			PersonaSearch personaSearch=new PersonaSearch();
			personaSearch.setCognomeLike(req.getParameter("input"));
			
			//personaSearch = IOPersona.readPersonaSearch();

			BaseList<Persona> ret = (BaseList<Persona>) manager.tx_loadPersona(personaSearch);
			
			resp.getWriter().write(IOPersona.writeListaPersona(ret));
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				//resp.getWriter().write(IOPersona.writeJson(e));
			} catch (Exception e1) {
				throw new ServletException(e1);
			}			
		}*/
	}

	private OspedaleManager getOspedaleManager() {
		return new OspedaleManager();
	}
}
