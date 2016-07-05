package wicketMyBatis7.ui.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import wicketMyBatis7.domain.*;
import wicketMyBatis7.logic.OspedaleManager;

public class PanelHomePage extends BasePanel implements Serializable {

	public PanelHomePage(String id, final OspedaleManager ospedaleManager) {
		super(id);
		this.setOutputMarkupId(true);

		Form<?> form = new Form("form");

		final TextField<String> textFieldFiltra = new TextField<String>("textFieldFiltra", Model.of(""));

		List<String> criteri = new ArrayList<String>();
		Persona p = new Persona();
		criteri.add("cognome");
		criteri.add("nome");
		final DropDownChoice<String> ddcCriterio = new DropDownChoice<String>("criterio", new PropertyModel(p, "nome"),
				criteri);
		ddcCriterio.setOutputMarkupId(true);

		final PanelListView panelList = new PanelListView("panelList", getManager());

		AjaxButton button = new AjaxButton("filtra") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form form) {

				panelList.setStringaCriterioLike("");
				if (ddcCriterio.getDefaultModelObjectAsString().equalsIgnoreCase("cognome"))
					panelList.setCriterio(0);
				else
					panelList.setCriterio(1);

				if (textFieldFiltra.getModelObject() != null)
					panelList.setStringaCriterioLike( textFieldFiltra.getModelObject());

				target.add(panelList);
			}
		};

		form.add(textFieldFiltra);
		form.add(ddcCriterio);
		form.add(button);
		this.add(form);
		this.add(panelList);
	}

}
