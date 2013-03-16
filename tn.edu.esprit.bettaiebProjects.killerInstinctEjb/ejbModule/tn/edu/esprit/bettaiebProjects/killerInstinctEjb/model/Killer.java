package tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

// TODO: Auto-generated Javadoc
/**
 * Entity implementation class for Entity: Killer.
 */
@Entity
public class Killer implements Serializable {

	/** The id killer. */
	@Id
	private int idKiller;

	/** The name killer. */
	private String nameKiller;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The gang. */
	@ManyToOne
	private Gang gang;

	/** The crimes. */
	@OneToMany(mappedBy = "killer")
	private List<Crime> crimes;

	/**
	 * Instantiates a new killer.
	 */
	public Killer() {
		super();
	}

	/**
	 * Gets the id killer.
	 * 
	 * @return the id killer
	 */
	public int getIdKiller() {
		return this.idKiller;
	}

	/**
	 * Sets the id killer.
	 * 
	 * @param idKiller
	 *            the new id killer
	 */
	public void setIdKiller(int idKiller) {
		this.idKiller = idKiller;
	}

	/**
	 * Gets the name killer.
	 * 
	 * @return the name killer
	 */
	public String getNameKiller() {
		return this.nameKiller;
	}

	/**
	 * Sets the name killer.
	 * 
	 * @param nameKiller
	 *            the new name killer
	 */
	public void setNameKiller(String nameKiller) {
		this.nameKiller = nameKiller;
	}

	/**
	 * Gets the gang.
	 * 
	 * @return the gang
	 */
	public Gang getGang() {
		return gang;
	}

	/**
	 * Sets the gang.
	 * 
	 * @param gang
	 *            the new gang
	 */
	public void setGang(Gang gang) {
		this.gang = gang;
	}

	/**
	 * Gets the crimes.
	 * 
	 * @return the crimes
	 */
	public List<Crime> getCrimes() {
		return crimes;
	}

	/**
	 * Sets the crimes.
	 * 
	 * @param crimes
	 *            the new crimes
	 */
	public void setCrimes(List<Crime> crimes) {
		this.crimes = crimes;
	}

}
