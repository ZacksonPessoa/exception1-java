package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

import model.entities.Reservetion;



//import java.util.Date;

//import model.entities.Order;
//import model.entities.enuns.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc =new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Mumber: ");
		int room =sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date date_in = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date date_on = sdf.parse(sc.next());
		if(!date_on.after(date_in)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservetion reservetion = new Reservetion(room, date_in, date_on);
			System.out.println("Reservetion" + reservetion);
			System.out.println();
		}
		
		
		System.out.println("Enter data to update the reservation: ");
		
		System.out.print("Check-in date (dd/MM/yyyy): ");
		date_in = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		date_on = sdf.parse(sc.next());
		
		//reservetion.update(date_in, date_on);
		//System.out.println(reservetion);
		System.out.println();
		
		sc.close();
	}

}
