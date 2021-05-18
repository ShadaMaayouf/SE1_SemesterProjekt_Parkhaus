package Parkhaussystem;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

/**
 * Servlet implementation class Parkhaussystem.DemoServlet
 */
@WebServlet("/Parkhaussystem.DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	/*
	private Parkhaussystem.Model model = new Parkhaussystem.Model();

	private Parkhaussystem.ViewTageseinnahmen einnahmen20190621 = new Parkhaussystem.ViewTageseinnahmen(new GregorianCalendar(2019,5,21));
	private Parkhaussystem.ViewTageseinnahmen einnahmenHeute = new Parkhaussystem.ViewTageseinnahmen(Calendar.getInstance());
	private Parkhaussystem.ViewParkdauer dauer3 = new Parkhaussystem.ViewParkdauer(3);
	private Parkhaussystem.ViewParkdauer dauer6 = new Parkhaussystem.ViewParkdauer(6);
	private Parkhaussystem.Controller einnahmen20190621Controller = new Parkhaussystem.Controller(model, einnahmen20190621);
	*/
	private Singleton_Parkhaus parkhaus = Singleton_Parkhaus.getInstance();
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        
      //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    	/*
        this.model.anmelden(einnahmen20190621);
    	this.model.anmelden(einnahmenHeute);
    	this.model.anmelden(dauer3);
    	this.model.anmelden(dauer6);
    	*/
    	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    	
    }
    private ServletContext getApplication() {
    	return getServletConfig().getServletContext();
    }
    
    private Float getPersistentSum() {
    	Float sum;
    	ServletContext application = getApplication();
    	sum = (Float)application.getAttribute("sum");
    	if (sum==null) sum = 0.0f;
    	return sum;
    }
    
    private Float getPersistentDur() {
    	Float dur;
    	ServletContext application = getApplication();
    	dur = (Float)application.getAttribute("dur");
    	if (dur==null) dur = 0.0f;
    	return dur;
    }
    
    private Float getPersistentAvgCost() {
    	Float avgCost;
    	ServletContext application = getApplication();
    	avgCost = (Float)application.getAttribute("avgCost");
    	if (avgCost==null) avgCost = 0.0f;
    	return avgCost;
    }
    private Float getPersistentAvgDur() {
    	Float avgDur;
    	ServletContext application = getApplication();
    	avgDur = (Float)application.getAttribute("avgDur");
    	if (avgDur==null) avgDur = 0.0f;
    	return avgDur;
    }
    
    private Float getPersistentMax() {
    	Float max;
    	ServletContext application = getApplication();
    	max = (Float)application.getAttribute("max");
    	if (max==null) max = 0.0f;
    	return max;
    }
    
    private Integer getPersistentCarCount() {
    	Integer carCount;
    	ServletContext application = getApplication();
    	carCount = (Integer)application.getAttribute("carCount");
    	if (carCount==null) carCount = 0;
    	return carCount;
    }
    
    private ArrayList<Float> getPersistentAllCost() {
    	ArrayList<Float> allCost;
    	ServletContext application = getApplication();
    	allCost = (ArrayList<Float>)application.getAttribute("allCost");
    	if (allCost == null) allCost = new ArrayList<Float>();
    	return allCost;
    }
    
    private String getPersistentTageseinnahmenView() {
    	String tageseinnahmenView;
    	ServletContext application = getApplication();
    	tageseinnahmenView = (String)application.getAttribute("tageseinnahmenView");
    	if (tageseinnahmenView==null) tageseinnahmenView = "";
    	return tageseinnahmenView;
    }
    
    private Float getPersistentSumTageseinnahmen() {
    	Float sumTageseinnahmen;
    	ServletContext application = getApplication();
    	sumTageseinnahmen = (Float)application.getAttribute("sumTageseinnahmen");
    	if (sumTageseinnahmen==null) sumTageseinnahmen = 0.0f;
    	return sumTageseinnahmen;
    }
    
    private Float getPersistentSumMinuteneinnahmen() {
    	Float sumMinuteneinnahmen;
    	ServletContext application = getApplication();
    	sumMinuteneinnahmen = (Float)application.getAttribute("sumMinuteneinnahmen");
    	if (sumMinuteneinnahmen==null) sumMinuteneinnahmen = 0.0f;
    	return sumMinuteneinnahmen;
    }
    
    private static String getBody(HttpServletRequest request) throws IOException{
    	StringBuilder stringBuilder = new StringBuilder();
    	BufferedReader bufferedReader = null;
    	
    	try {
    		InputStream InputStream = request.getInputStream();
    		if(InputStream != null) {
    			bufferedReader = new BufferedReader(new InputStreamReader(InputStream));
    			char[] charBuffer = new char[128];
    			int bytesRead = -1;
    			while((bytesRead = bufferedReader.read(charBuffer)) > 0) {
    				stringBuilder.append(charBuffer, 0, bytesRead);
    			}
    		} else {
    			stringBuilder.append("");
    		}
    	}
    		finally {
    			if(bufferedReader != null) {
    				bufferedReader.close();
    			}
    		}
    		return stringBuilder.toString();
    	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String[] requestParamString = request.getQueryString().split("=");
		//String command = requestParamString[0];
		//String param = requestParamString[1];
		if("sum".equals( request.getParameter("cmd"))){
		//if ("fun".equals(command) && "sum".equals(param)){
			
			Float sum = getPersistentSum();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(sum);
			System.out.println("sum = " + sum);
		}
		
		else if("avg".equals( request.getParameter("cmd"))){
		//if ("fun".equals(command) && "avg".equals(param)){
			Float avgCost = getPersistentAvgCost();
			Float avgDur = getPersistentAvgDur();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(avgCost + "," + avgDur);
			System.out.println("avgCost = " + avgCost);
			System.out.println("avgDur = " + avgDur);
		}
				
		else if("max".equals( request.getParameter("cmd"))){
		//if ("fun".equals(command) && "max".equals(param)){
			Float max = getPersistentMax();
			
			//response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(max);
			System.out.println("max = " + max);
		} 
		
		
		else if ( "config".equals( request.getParameter("cmd") ) ){
			// Overwrite config parameters
			  // Maximum number of cars, open_from, open_to, delay, simulation_speed
			  PrintWriter out = response.getWriter();
			  out.println("20,6,24,300,10");
			  System.out.println("config an Konsole");

		}
		
		else if ( "cars".equals( request.getParameter("cmd") ) ){
			  PrintWriter out = response.getWriter();
			  out.println( "" );
			  System.out.println("cars an Konsole");
			  // leerer String, falls Parkhaus leer
			  // oder Ausgabe aller Autos, die Sie auf dem Server gespeichert haben

			}
		
		else if ( "chart".equals( request.getParameter("cmd") ) ){
			  System.out.println("chart an Konsole");
			  ArrayList<Float> allCost = getPersistentAllCost();
			  response.setContentType("text/plain");
              PrintWriter out = response.getWriter();
              out.println("{\n" +
              "  \"data\": [\n" +
              "    {\n" +
              "      \"x\": [\n" +
              "        \"Car_1\",\n" +
              "        \"Car_2\",\n" +
              "        \"Car_3\"\n" +
              "      ],\n" +
              "      \"y\": [\n" +
              allCost.get(0) + ",\n" +
              allCost.get(1) + ",\n" +
              allCost.get(2) + "\n" +
              "      ],\n" +
              "      \"type\": \"bar\"\n" +
              "    }\n" +
              "  ]\n" +
              "}");

			}
		
		else if("tageseinnahmenView".equals( request.getParameter("cmd"))){
			//if ("fun".equals(command) && "avg".equals(param)){
				String tageseinnahmenView = getPersistentTageseinnahmenView();
								
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println(tageseinnahmenView);
			}
		
		else if("sumTageseinnahmen".equals( request.getParameter("cmd"))){
			//if ("fun".equals(command) && "sum".equals(param)){
				
				Float sumTageseinnahmen = getPersistentSumTageseinnahmen();
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println(sumTageseinnahmen);
				System.out.println("sumTageseinnahmen = " + sumTageseinnahmen);
			}
		
		else if("sumMinuteneinnahmen".equals( request.getParameter("cmd"))){
			//if ("fun".equals(command) && "sum".equals(param)){
				
				Float sumMinuteneinnahmen = getPersistentSumMinuteneinnahmen();
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println(sumMinuteneinnahmen);
				System.out.println("sumMinuteneinnahmen = " + sumMinuteneinnahmen);
			}
		
		
		else {
			System.out.println("Invalid Command; " + request.getQueryString() );
		}
		
		//Ausgabe in Browser
		//response.getWriter().append("Hello World from Parkhaussystem.DemoServlet.java to browser!");
		
		//Ausgabe auf Server-Konsole
		//System.out.println("Hello World from Parkhaussystem.DemoServlet.java to server console!");
		
	}
	
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Float sum = getPersistentSum();
		Float dur = getPersistentDur();
		Float avgCost = getPersistentAvgCost();
		Float avgDur = getPersistentAvgDur();
		Float max = getPersistentMax();
		Integer carCount = getPersistentCarCount();
		ArrayList<Float> allCost = getPersistentAllCost();
		String body = getBody(request);
		System.out.println(body);
		String[] params = body.split(",");
		String event = params[0];
		String durationString = params[3];
		String priceString = params[4];

		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//einnahmen20190621Controller.setValues(body);
		this.parkhaus.stringIncoming(body);
		
		getApplication().setAttribute("tageseinnahmenView", this.parkhaus.getViewTageseinnahmen().getTable());
		
		
		
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		System.out.println("doPost an Konsole");
		if(!"_".contentEquals(priceString)) {
			//strip € in front, parse the number behind
			float price = Float.parseFloat(priceString);
			sum += price;
			float duration = Float.parseFloat(durationString);
			dur += duration;
			allCost.add(price);
			//store sum persistently in ServletContext
			getApplication().setAttribute("sum", sum);
			getApplication().setAttribute("dur", dur);
			getApplication().setAttribute("allCost", allCost);
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			this.parkhaus.carLeft(body);
			getApplication().setAttribute("sumTageseinnahmen", this.parkhaus.getTagesEinnahmen());
			getApplication().setAttribute("sumMinuteneinnahmen", this.parkhaus.getMinutenEinnahmen());
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			carCount += 1;
			getApplication().setAttribute("carCount", carCount);
			if(price>max) {
				getApplication().setAttribute("max", price);
			}
		}
		if(getPersistentCarCount()!=0) {
			avgCost = getPersistentSum()/getPersistentCarCount();
			avgDur = getPersistentDur()/getPersistentCarCount();
			getApplication().setAttribute("avgCost", avgCost);
			getApplication().setAttribute("avgDur", avgDur);
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(sum);
		out.println(avgCost);
		out.println(avgDur);
		out.println(max);
	}
	
	


}


