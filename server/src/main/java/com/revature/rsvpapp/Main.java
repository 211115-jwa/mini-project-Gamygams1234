package com.revature.rsvpapp;
import io.javalin.Javalin;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Guest> guests  = new ArrayList<>();

		Javalin app = Javalin.create();
		app.start();
	

		app.post("/users", ctx -> { // the {} syntax does not allow slashes ('/') as part of the parameter
			String name = ctx.formParam("name");
			String email = ctx.formParam("email");
			Guest guest = new Guest(name, email);
			guests.add(guest);
	
			String html = "";
			for(Guest eachGuest: guests){
				if (eachGuest != null) {
					html += "<div class=\"card\">\r\n"+ "<h2 class = \"fraunces\">"+ eachGuest.name+"</h2>\r\n"+"<p>"+ eachGuest.email+"</p>\r\n"+ "</div>";
				}
			
		  }
			ctx.html(html);
		});
		
//		app.get("/list", ctx ->{
//			String html = "";
//			for(Guest eachGuest: guests){
//				if (eachGuest != null) {
//					html += "<div>\r\n"+ "<h2>"+ eachGuest.name+"</h2>\r\n"+"<p>"+ eachGuest.email+"</p>\r\n"+ "</div>";
//				}
//			
//		  }
//			ctx.html(html);
//		});
	}
}
