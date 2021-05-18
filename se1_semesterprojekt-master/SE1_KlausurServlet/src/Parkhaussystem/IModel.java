package Parkhaussystem;

import java.util.List;

public interface IModel {
	public void anmelden(IView view);
	public void abmelden(IView view);
	public List<String> gibDaten();
	public void aendereDaten(String info);
}
