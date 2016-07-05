package wicketMyBatis7.ui.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;

import wicketMyBatis7.dao.ws.WSCaricaPersona;
import wicketMyBatis7.domain.*;
import wicketMyBatis7.logic.OspedaleManager;

public class PanelListView extends BasePanel implements Serializable {

	private String stringaCriterio = "";
	private int criterio = 0;

	public PanelListView(String id, final OspedaleManager ospedaleManager) {
		super(id);
		this.setOutputMarkupId(true);

		Form<?> form = new Form("form");

		final IModel hateList = new LoadableDetachableModel() {
			protected Object load() {
				return getHateList();
			}
		};
		ListView hateView = new ListView("hateList", hateList) {
			protected void populateItem(final ListItem item) {
				Persona mli = (Persona) item.getModelObject();
				item.add(new Label("nome", mli.getNome()));
				item.add(new Label("cognome", mli.getCognome()));
				item.add(new Label("unid", mli.getUnid()));
			}
		};
		// encapsulate the ListView in a WebMarkupContainer in order for it to
		// update
		final WebMarkupContainer listContainer = new WebMarkupContainer("theContainer");
		// generate a markup-id so the contents can be updated through an AJAX
		// call
		listContainer.setOutputMarkupId(true);
		listContainer.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(5)));
		// add the list view to the container
		listContainer.add(hateView);
		// finally add the container to the page
		Button button = new Button("invia") {
			@Override
			public void onSubmit() {
				super.onSubmit();

				this.setResponsePage(EditPersonaPage.class);

			}
		};
		form.add(listContainer);
		form.add(button);
		this.add(form);
	}

	private List getHateList() {

		PersonaSearch pS = new PersonaSearch();

		pS.setStringaCriterioLike(stringaCriterio);

		return getManager().tx_loadPersona(pS).getList();
	}

	public int getCriterio() {
		return criterio;
	}

	public void setCriterio(int criterio) {
		this.criterio = criterio;
	}

	public String getStringaCriterioLike() {
		return stringaCriterio;
	}

	public void setStringaCriterioLike(String cognomeLike) {
		this.stringaCriterio = cognomeLike;
	}
}
