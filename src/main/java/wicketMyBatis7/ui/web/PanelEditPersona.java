package wicketMyBatis7.ui.web;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import wicketMyBatis7.dao.ws.WSCaricaPersona;
import wicketMyBatis7.dao.ws.WSUpdatePersona;
import wicketMyBatis7.domain.*;
import wicketMyBatis7.logic.OspedaleManager;

public class PanelEditPersona extends BasePanel implements Serializable{



	public PanelEditPersona(String id, final OspedaleManager ospedaleManager)
	{
		this( id, ospedaleManager, new Persona());
	}
	public PanelEditPersona(String id, final OspedaleManager ospedaleManager,
			final Persona persona) {
		
		super(id);
		this.setOutputMarkupId(true);
		Form<?> form = new Form("form");
		
		Label lblNome = new Label("lblNome", "nome");
		final TextField<String> textFieldNome = new TextField("textFieldNome", new PropertyModel<>(persona, "nome"));
		//TextField<String> nome = new TextField<String>("nome",new PropertyModel<>(persona, "nome"));

		final Label lblCognome = new Label("lblCognome", "cognome");
		final TextField<String> textFieldCognome = new TextField("textFieldCognome", new PropertyModel<>(persona, "cognome"));
		
		Label lblComune = new Label("lblComune", "comune");
		final TextField<String> textFieldComune = new TextField("textFieldComune", new PropertyModel<>(persona, "comunenascita"));
		
		Label lblDataDecesso = new Label("lblDataDecesso", "Data Decesso");
		final TextField<String> textFieldDataDecesso = new TextField("textFieldDataDecesso", new PropertyModel<>(persona, "datadecesso"));
		
		Label lblDataNascita = new Label("lblDataNascita", "Data Nascita");
		final TextField<String> textFieldDataNascita = new TextField("textFieldDataNascita", new PropertyModel<>(persona, "datanascita"));
		
		Label lblUnid = new Label("lblUnid", "Unid");
		final TextField<String> textUnid = new TextField("textUnid", new PropertyModel<>(persona, "unid"));
		//textUnid.setEnabled(false);
		
		Button button = new Button("back") {

			@Override
			public void onSubmit() {
				super.onSubmit();
								
				WSUpdatePersona wsPersona = new WSUpdatePersona();
				Persona persona = new Persona();
				persona.setNome(textFieldNome.getModelObject());
				persona.setCognome(textFieldCognome.getModelObject());
				persona.setComunenascita(textFieldComune.getModelObject());
				persona.setUnid( textUnid.getModelObject());
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
				Date date = null;
				Date date2 = null;
				try {
					date = dateFormat.parse(textFieldDataNascita.getDefaultModelObjectAsString());
					date2 = dateFormat.parse(textFieldDataDecesso.getDefaultModelObjectAsString());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				persona.setDatanascita( date);
				persona.setDatadecesso( date2);
				
				wsPersona.setPersona(persona);
				System.out.println(persona);
					try {
						wsPersona.doGet(null, null);
					} catch (ServletException e) {
						e.printStackTrace();
					}
					
				
				this.setResponsePage( MainPage.class);
			}
		};
		form.add( lblNome);
		form.add( textFieldNome);
		form.add( lblCognome);
		form.add( textFieldCognome);
		form.add( lblComune);
		form.add( textFieldComune);
		form.add( lblDataDecesso);
		form.add( textFieldDataDecesso);
		form.add( lblDataNascita);
		form.add( textFieldDataNascita);
		form.add( lblUnid);
		form.add( textUnid);
		form.add( button);
		this.add(form);
	}

}
