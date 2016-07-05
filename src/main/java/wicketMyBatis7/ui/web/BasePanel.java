package wicketMyBatis7.ui.web;

import org.apache.wicket.markup.html.panel.Panel;

import wicketMyBatis7.logic.OspedaleManager;

public class BasePanel extends Panel {


	private static final long serialVersionUID = 6450346136632720874L;
	
	public BasePanel(String id) {
		super(id);
		this.setOutputMarkupId(true);
	}

	public OspedaleManager getManager() {
		return OspedaleManager.getManager();
	}
}
