package westbahn;

import javax.persistence.Entity;

@Entity
public class Einzelticket extends Ticket {


	private TicketOption ticketOption;


	public Einzelticket(Strecke strecke, Zahlung zahlung, TicketOption ticketOption){
		super(strecke,zahlung);
		this.ticketOption= ticketOption;
	}

	public Einzelticket() {
	}

	public TicketOption getTicketOption() {
		return ticketOption;
	}


	public void setTicketOption(TicketOption ticketOption) {
		this.ticketOption = ticketOption;
	}
	
}
