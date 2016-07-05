package wicketMyBatis7.logic;

import java.util.List;

import wicketMyBatis7.dao.Persistence;
import wicketMyBatis7.domain.*;


public class OspedaleManager {
	private static OspedaleManager manager=null;
	
	public static synchronized OspedaleManager getManager() {
		if(manager==null) {
			manager=new OspedaleManager();
		}
		return manager;
	}

	public OspedaleManager() {
		
	}

	public List<Persona> tx_getAll()
	{
		Persistence db = new Persistence();
		List<Persona> persone =null;
		persone= db.getAll();
		db.close();
		return persone;
	}
	public int tx_getCount( PersonaSearch s)
	{
		Persistence db = new Persistence();
		return db.getCount(s);
	}
	public void tx_salvaPersonaTutto(Persona p) {
		Persistence db = new Persistence();
		try {
			
			db.salvaPersona(p);
			//
			
			//
		} catch (RuntimeException r) {
			db.rollback();
			throw r;
		} finally {
			db.commit();
		}
	
	}

	public void tx_loadPersonaTutto(Persona p) {
		
	}

	public void deletePersona(Persona a) {
		tx_salvaPersonaTutto(a);
	}

	public BaseList<Persona> tx_loadPersona(PersonaSearch s) {
		BaseList<Persona> ret=new BaseList();
		Persistence db = new Persistence();
		try {			
			ret.setTotal(db.countPersona(s));
			List<Persona> list=db.loadPersona(s);
			ret.setList(list);
			
			return ret;		
		} catch (RuntimeException r) {
			r.printStackTrace();
			db.rollback();
			throw r;
		} finally {
			db.close();
		}
	}

	

	

}
