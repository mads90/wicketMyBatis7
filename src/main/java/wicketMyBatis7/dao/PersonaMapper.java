package wicketMyBatis7.dao;

import java.util.List;

import wicketMyBatis7.domain.Persona;
import wicketMyBatis7.domain.PersonaSearch;



//Persona Mapper 
public interface PersonaMapper {
	public void insert(Persona a);

	public List<Persona> loadAll(PersonaSearch s);

	public void update(Persona a);

	public Integer count(PersonaSearch s);

	public void delete(Persona a);
	
	public List<Persona> getAll();
}
