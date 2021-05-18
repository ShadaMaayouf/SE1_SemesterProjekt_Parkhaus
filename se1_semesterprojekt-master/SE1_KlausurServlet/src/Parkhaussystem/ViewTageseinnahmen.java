package Parkhaussystem;

import java.util.Calendar;
import java.util.List;

public class ViewTageseinnahmen implements IView {
	
	private Calendar date;
	private Integer value;
	private String table;
	
	public ViewTageseinnahmen(Calendar date) {
		this.date = date;
	}

	public void aktualisieren(IModel model) {
		List<String> newData = model.gibDaten();
		this.value = 0;
		this.table = "";
		this.table += "Tageseinnahmen vom " + this.date.getTime() + " <START DER LISTE>\n";
		this.table += newData.stream()
				.map(string -> string.split(",")) //Aufteilen des Strings in Teilstrings
				.filter(array -> !"_".equals(array[4])) //filtern, ob Preis dabeisteht
				.filter(array -> {Calendar fromStamp = Calendar.getInstance(); //filtern, ob Daten vom gewünschten Tag
								  fromStamp.setTimeInMillis(Long.parseLong(array[2]));
								  return (this.date.get(Calendar.DAY_OF_YEAR) == fromStamp.get(Calendar.DAY_OF_YEAR)
								  &&
								  this.date.get(Calendar.YEAR) == fromStamp.get(Calendar.YEAR));})
				.map(array -> "ID: " + array[1] + " - " + "Gebuehr: " + array[4] + "\n")
				.reduce("", String::concat);
		this.table += "Tageseinnahmen vom " + this.date.getTime() + " <ENDE DER LISTE>\n";
		
		System.out.println(this.table);
		
		this.value += newData.stream()
				.map(string -> string.split(",")) //Aufteilen des Strings in Teilstrings
				.filter(array -> !"_".equals(array[4])) //filtern, ob Preis dabeisteht
				.filter(array -> {Calendar fromStamp = Calendar.getInstance(); //filtern, ob Daten vom gewünschten Tag
								  fromStamp.setTimeInMillis(Long.parseLong(array[2]));
								  return (this.date.get(Calendar.DAY_OF_YEAR) == fromStamp.get(Calendar.DAY_OF_YEAR)
								  &&
								  this.date.get(Calendar.YEAR) == fromStamp.get(Calendar.YEAR));})
				.map(array -> Integer.parseInt(array[4]))
				.reduce(0, (x,y) -> x+y);
	}

	/*
	@Override
	public void aktualisieren(Parkhaussystem.IModel model) {
		this.value = 0;
		this.table = "";
		this.table += "Tageseinnahmen vom " + this.date.getTime() + " <START DER LISTE>\n";
		System.out.println("Tageseinnahmen vom " + this.date.getTime() + " <START DER LISTE>");
		List<String> newData = model.gibDaten();
		for(String currentEntry : newData) {
			String[] params = currentEntry.split(",");
			String idString = params[1];
			Integer idInt = Integer.parseInt(idString);
			String priceString = params[4];
			if(!"_".equals(priceString)) {
				String unixStampString = params[2];
				Long unixStampLong = Long.parseLong(unixStampString);
				Calendar fromStamp = Calendar.getInstance();
				fromStamp.setTimeInMillis(unixStampLong);
				//System.out.println("fromEntry: " + fromStamp.getTime());
				if( 	this.date.get(Calendar.DAY_OF_YEAR) == fromStamp.get(Calendar.DAY_OF_YEAR) &&
		                this.date.get(Calendar.YEAR) == fromStamp.get(Calendar.YEAR) ) {
					value += Integer.parseInt(priceString);
					this.table += "ID: " + idInt + " - " + "Gebuehr: " + Integer.parseInt(priceString) + "\n";
					System.out.println("ID: " + idInt + " - " + "Gebuehr: " + Integer.parseInt(priceString));
				}
			}
			//this.showDate();
		}
		this.table += "Tageseinnahmen vom " + this.date.getTime() + " <ENDE DER LISTE>\n";
		System.out.println("Tageseinnahmen vom " + this.date.getTime() + " <ENDE DER LISTE>");
	}
	*/
	
	public void showDate() {
		System.out.println("reference: " + this.date.getTime());
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getTable() {
		return this.table;
	}


}
