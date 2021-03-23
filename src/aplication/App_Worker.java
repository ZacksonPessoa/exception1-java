package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Departement;
import model.entities.HourContract;
import model.entities.Worker;
import model.entities.enuns.WorkerLevel;

public class App_Worker {public static void main(String[] args) throws ParseException {
	
	Locale.setDefault(Locale.US);
	Scanner sc =new Scanner(System.in); 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	System.out.print("Enter department's name: ");
	String departamentName = sc.next();
	System.out.println("Enter worker data:");
	sc.nextLine();
	System.out.print("Name: ");
	String name =sc.next();
	System.out.print("Level: ");
	String level =sc.next();
	System.out.print("Base Salary: ");
	double baseSalary = sc.nextDouble();
	Worker worker =new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Departement(departamentName));
	
	System.out.print("How many contracts to this worker? ");
	int n = sc.nextInt();
	
	for(int i=1; i<=n; i++) {
		
		System.out.println();
		System.out.println("Enter contract #"+i +" data: ");
		System.out.print("Date (DD/MM/YYYY): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Value per hour:  ");
		double valueHour = sc.nextDouble();
		System.out.print("Duration (hours): ");
		int duration =sc.nextInt();
		HourContract contract =new HourContract(date, valueHour, duration);
		worker.addContract(contract);
				
		
	}
	System.out.print("Enter month and year to calculate income (MM/YYYY): ");
	String monthAndyear =sc.next();
	int month = Integer.parseInt(monthAndyear.substring(0, 2));
	int year = Integer.parseInt(monthAndyear.substring(3));

	System.out.println("Name: " + worker.getName());
	System.out.println("Deparment: " + worker.getDepartament().getName());
	System.out.println("Income for: " + monthAndyear +": " + worker.income(year, month));
	System.out.print("");
	
	
	sc.close();
}	

}
