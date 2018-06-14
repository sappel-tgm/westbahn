package model;

import javax.persistence.Entity;

@Entity
public class Einzelticket extends Ticket {


	private TicketOption ticketOption;
	
	
	public Einzelticket() {}
	
	public TicketOption getTicketOption() {
		return ticketOption;
	}


	public void setTicketOption(TicketOption ticketOption) {
		this.ticketOption = ticketOption;
	}
	
}
