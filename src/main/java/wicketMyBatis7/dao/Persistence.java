package wicketMyBatis7.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import wicketMyBatis7.domain.*;
import wicketMyBatis7.logic.ConnectionFactory;




public class Persistence {
	SqlSession session = getSession();
	
	 public PersonaMapper PersonaMapper;
	 
	public Persistence() {
		session = ConnectionFactory.getSession().openSession();
		PersonaMapper = session.getMapper(PersonaMapper.class);
	}

	private SqlSession getSession() {
		return session;
	}

	public void commit() {
		session.commit();
	}

	public void rollback() {
		session.rollback();
	}
	
	public void close() {
		session.close();
	}
	
	public int getCount( PersonaSearch s)
	{
		return PersonaMapper.count(s);
	}
	public List<Persona> getAll()
	{
		return PersonaMapper.getAll();
	}
	
	public void salvaPersona(Persona a) {
		if (a.checkIsNuovo()) {
			PersonaMapper.insert(a);
			a.setNuovo("F");
		} else {
			PersonaMapper.update(a);
		}
	}

	public List<Persona> loadPersona(PersonaSearch s) {
		return PersonaMapper.loadAll(s);
	}

	public int countPersona(PersonaSearch s) {
		return PersonaMapper.count(s);
	}


}
