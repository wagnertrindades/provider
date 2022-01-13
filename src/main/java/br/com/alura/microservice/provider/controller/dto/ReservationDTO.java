package br.com.alura.microservice.provider.controller.dto;

public class ReservationDTO {
	
	public Integer reservationID;
	
	public Integer preparationTime;

	public Integer getReservationID() {
		return reservationID;
	}

	public void setReservationID(Integer reservationID) {
		this.reservationID = reservationID;
	}

	public Integer getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(Integer preparationTime) {
		this.preparationTime = preparationTime;
	}
	
}
