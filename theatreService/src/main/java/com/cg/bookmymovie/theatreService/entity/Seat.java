package com.cg.bookmymovie.theatreService.entity;

public class Seat {
	private String seatType;
	private String seatRow;
	private int seatNumber;

	public Seat(String seatType, String seatRow, int seatNumber) {
		super();
		this.seatType = seatType;
		this.seatRow = seatRow;
		this.seatNumber = seatNumber;
	}

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(String seatRow) {
		this.seatRow = seatRow;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "Seat [seatType=" + seatType + ", seatRow=" + seatRow + ", seatNumber=" + seatNumber + "]";
	}

}
