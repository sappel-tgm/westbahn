package westbahn;

import javax.persistence.*;

@Entity
public class Strecke {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Bahnhof start;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Bahnhof ende;
	
	public Strecke() {}

	public Strecke(Bahnhof start, Bahnhof ende) {
		super();
		this.start = start;
		this.ende = ende;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
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
