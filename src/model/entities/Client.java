package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	private String name, email;
	private Date bithDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Client() {
		
	}

	public Client(String name, String email, Date bithDate) {
	
		this.name = name;
		this.email = email;
		this.bithDate = bithDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String  getBithDate() {
		return sdf.format(bithDate);
	}

	public void setBithDate(Date bithDate) {
		this.bithDate = bithDate;
	}
	
}
