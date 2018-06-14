package westbahn;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
/*
@NamedQueries({
		@NamedQuery(name="TicketsOfRouteNoReserve", query ="select t from Ticket t left join Reservierung r on t.strecke.ID = r.strecke.ID where t.strecke.ID = :strecke")
})*/
public abstract class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long ID;

	@OneToOne
	protected Strecke strecke;

	protected Zahlung zahlung;

	public Ticket(){}

    public Ticket(Strecke strecke, Zahlung zahlung) {
    	this.strecke = strecke;
    	this.zahlung = zahlung;
    }


    public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Strecke getStrecke() {
		return strecke;
	}

	public void setStrecke(Strecke strecke) {
		this.strecke = strecke;
	}

	public Zahlung getZahlung() {
		return zahlung;
	}

	public void setZahlung(Zahlung zahlung) {
		this.zahlung = zahlung;
	}
	
	
}
