package Parkhaussystem;

public class Controller implements IController {
	
	private IModel model;
	private IView view;
	
	public Controller(IModel model, IView view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void setValues(String newEntry) {
		this.model.aendereDaten(newEntry);
	}

}
