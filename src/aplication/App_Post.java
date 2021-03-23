package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.Coments;
import model.entities.Post;

public class App_Post {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Coments c1 = new Coments("Have a nice trip");
		Coments c2 = new Coments("Wow that's awesome!");
		Post p1 = new Post(sdf.parse("21/06/2018 13:05:44"),
				"Traveling to New Zealand",
				"I'm going to visit this wonderful country!", 12);
		p1.addComents(c1);
		p1.addComents(c2);
		
		Post p2 = new Post(sdf.parse("28/07/2018 23:14:19"), 
				"Good night guys", "See you tomorrow", 5);
		Coments c3 = new Coments("Good night");
		Coments c4 = new Coments("May the Force be with you");
		p2.addComents(c3);
		p2.addComents(c4);
		
		System.out.println(p1);
		System.out.println(p2);
	}

}
