package wicketMyBatis7.ui.web;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import wicketMyBatis7.logic.OspedaleManager;

public class BasePage extends WebPage implements Serializable{

	public OspedaleManager getManager() {
		return OspedaleManager.getManager();
	}
}
