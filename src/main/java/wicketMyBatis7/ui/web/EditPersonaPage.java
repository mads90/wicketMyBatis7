package wicketMyBatis7.ui.web;

import java.io.Serializable;

import wicketMyBatis7.domain.Persona;

public class EditPersonaPage extends BasePage implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -885496576218428682L;

	public EditPersonaPage()
	{
		this( new Persona());
	}
	public EditPersonaPage( Persona persona)
	{
		super();
		this.setOutputMarkupId(true);
		
		PanelEditPersona panel = new PanelEditPersona("panel", getManager(), persona);
		
		this.add(panel);
	}

}