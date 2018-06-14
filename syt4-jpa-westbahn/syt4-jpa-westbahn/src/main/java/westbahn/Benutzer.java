package westbahn;

import javax.persistence.*;

@Entity
@NamedQueries({
		@NamedQuery(name="getUsersWMonthTicket", query = "select b from Benutzer b  JOIN  b.tickets t WHERE t.id= 1 ")
})

public class Benutzer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private String vorName;

	private String nachName;
	
	@Column(unique = true)
	private String eMail;

	private String passwort;

	private String smsNummer;

	private Long verbuchtePraemienMeilen;

	@OneToOne(cascade = CascadeType.ALL)
	private Ticket tickets;

	public Benutzer(){}

	public Benutzer(String vorName, String nachName, String eMail, String passwort, String smsNummer, Long verbuchtePraemienMeilen, Ticket tickets) {
		super();
		this.setVorName(vorName);
		this.setNachName(nachName);
		this.seteMail(eMail);
		this.setPasswort(passwort);
		this.setSmsNummer(smsNummer);
		this.verbuchtePraemienMeilen = verbuchtePraemienMeilen;
		this.setTickets(tickets);
	}
	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public String getVorName() {
		return vorName;
	}

	public void setVorName(String vorName) {
		this.vorName = vorName;
	}

	public String getNachName() {
		return nachName;
	}

	public void setNachName(String nachName) {
		this.nachName = nachName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getSmsNummer() {
		return smsNummer;
	}

	public void setSmsNummer(String smsNummer) {
		this.smsNummer = smsNummer;
	}

	public Ticket getTickets() {
		return tickets;
	}

	public void setTickets(Ticket tickets) {
		this.tickets = tickets;
	}

}
