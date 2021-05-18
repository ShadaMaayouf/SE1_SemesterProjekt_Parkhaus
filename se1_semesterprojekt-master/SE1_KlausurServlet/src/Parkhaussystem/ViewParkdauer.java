package Parkhaussystem;

import java.util.List;

public class ViewParkdauer implements IView {
	
	private int id;
	private long dauer;
	
	public ViewParkdauer(int id) {
		this.id = id;
	}
	
	@Override
	public void aktualisieren(IModel model) {
		List<String> newData = model.gibDaten();
		for(String currentEntry : newData) {
			String[] params = currentEntry.split(",");
			String idString = params[1];
			Integer idInt = Integer.parseInt(idString);
			String dauerString = params[3];
			if(idInt == this.id) {
				long unixTime = System.currentTimeMillis();
				if("_".equals(dauerString)) {
					String unixStampString = params[2];
					Long unixStampLong = Long.parseLong(unixStampString);
					this.dauer = unixTime - unixStampLong;
				}
				else {
					this.dauer = Long.parseLong(dauerString);
				}
			}
			
		}
		System.out.println("Parkdauer von ID " + this.id + ": " + this.dauer);
	}
		
	public long getDauer() {
		return this.dauer;
	}


}
