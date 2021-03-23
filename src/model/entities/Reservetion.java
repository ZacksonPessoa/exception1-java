package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservetion {
	private Integer roomNumber;
	private Date checkin, checkout;
	
	private static SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyy");
	
	public Reservetion() {
		
	}

	public Reservetion(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}


	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void update(Date checkin, Date chekout) {
		this.checkin = checkin;
		this.checkout = chekout;
	}
	@Override
	public String toString() {
		return "Room "
				+roomNumber
				+", Check in: "
				+sdf.format(checkin)
				+" , Check out: "
				+sdf.format(checkout)
				+", "
				+ duration()
				+" nights";
	}

}
