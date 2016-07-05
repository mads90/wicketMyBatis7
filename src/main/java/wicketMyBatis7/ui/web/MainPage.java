package wicketMyBatis7.ui.web;

public class MainPage extends BasePage {

	public MainPage()
	{
		PanelHomePage panel = new PanelHomePage("panel", getManager());
		

		this.add(panel);
	}
}
