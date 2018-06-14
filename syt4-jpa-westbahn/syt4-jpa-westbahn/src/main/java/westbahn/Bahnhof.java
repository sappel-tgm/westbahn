package westbahn;

import javax.persistence.*;

@Entity
@NamedQueries ({@NamedQuery(name="getBahnhof",query="SELECT b from Bahnhof b")})
public class Bahnhof {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(unique = true)
	private String name;

	private int absPreisEntfernung;

	private int absKmEntfernung;

	private int absZeitEntfernung;

	private boolean kopfBahnhof;
	
	public Bahnhof() {}

	public Bahnhof(String name, int absPreisEntfernung, int absKmEntfernung, int absZeitEntfernung, boolean kopfBahnhof){
		this.name = name;
		this.absPreisEntfernung = absPreisEntfernung;
		this.absKmEntfernung = absKmEntfernung;
		this.absZeitEntfernung = absZeitEntfernung;
		this.kopfBahnhof = kopfBahnhof;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAbsPreisEntfernung() {
		return absPreisEntfernung;
	}

	public void setAbsPreisEntfernung(int absPreisEntfernung) {
		this.absPreisEntfernung = absPreisEntfernung;
	}

	public int getAbsKmEntfernung() {
		return absKmEntfernung;
	}

	public void setAbsKmEntfernung(int absKmEntfernung) {
		this.absKmEntfernung = absKmEntfernung;
	}

	public int getAbsZeitEntfernung() {
		return absZeitEntfernung;
	}

	public void setAbsZeitEntfernung(int absZeitEntfernung) {
		this.absZeitEntfernung = absZeitEntfernung;
	}

	public boolean isKopfBahnhof() {
		return kopfBahnhof;
	}

	public void setKopfBahnhof(boolean kopfBahnhof) {
		this.kopfBahnhof = kopfBahnhof;
	}
	
	

}
