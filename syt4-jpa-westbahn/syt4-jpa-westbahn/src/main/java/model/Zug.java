package model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
public class Zug {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private Date startZeit;

	private int sitzPlaetze = 500;

	private int fahrradStellplaetze = 50;

	private int rollStuhlPlaetze = 10;

	private Bahnhof start;

	private Bahnhof ende;
	
	
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Date getStartZeit() {
		return startZeit;
	}

	public void setStartZeit(Date startZeit) {
		this.startZeit = startZeit;
	}

	public int getSitzPlaetze() {
		return sitzPlaetze;
	}

	public void setSitzPlaetze(int sitzPlaetze) {
		this.sitzPlaetze = sitzPlaetze;
	}

	public int getFahrradStellplaetze() {
		return fahrradStellplaetze;
	}

	public void setFahrradStellplaetze(int fahrradStellplaetze) {
		this.fahrradStellplaetze = fahrradStellplaetze;
	}

	public int getRollStuhlPlaetze() {
		return rollStuhlPlaetze;
	}

	public void setRollStuhlPlaetze(int rollStuhlPlaetze) {
		this.rollStuhlPlaetze = rollStuhlPlaetze;
	}

	public Bahnhof getStart() {
		return start;
	}

	public void setStart(Bahnhof start) {
		this.start = start;
	}

	public Bahnhof getEnde() {
		return ende;
	}

	public void setEnde(Bahnhof ende) {
		this.ende = ende;
	}
	
	

}
