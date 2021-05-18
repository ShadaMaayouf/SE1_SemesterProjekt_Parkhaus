package Parkhaussystem;

import java.util.ArrayList;
import java.util.List;

public class Model implements IModel {
	
	private List<IView> angemeldeteViews = new ArrayList<IView>();
	
	private List<String> data = new ArrayList<String>();
	
	
	@Override
	public void anmelden(IView view) {
		angemeldeteViews.add(view);
	}

	@Override
	public void abmelden(IView view) {
		angemeldeteViews.remove(view);
	}
	
	public List<String> gibDaten(){
		return this.data;
	}
	
	public void aendereDaten(String info) {
		this.data.add(info);
		this.benachrichtigen();
	}
	
	public void benachrichtigen() {
		for(IView currentView : angemeldeteViews) {
			currentView.aktualisieren(this);
		}
	}

}
