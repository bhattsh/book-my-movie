package com.cg.bookmymovie.theatreService.entity;

import java.util.Set;

public class Auditorium {
	private String auditoriumName;
	private Set<Seat> seat;

	public Auditorium() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Auditorium(String auditoriumName, Set<Seat> seat) {
		super();
		this.auditoriumName = auditoriumName;
		this.seat = seat;
	}

	public String getAuditoriumName() {
		return auditoriumName;
	}

	public void setAuditoriumName(String auditoriumName) {
		this.auditoriumName = auditoriumName;
	}

	public Set<Seat> getSeat() {
		return seat;
	}

	public void setSeat(Set<Seat> seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Auditorium [auditoriumName=" + auditoriumName + ", seat=" + seat + "]";
	}

}
