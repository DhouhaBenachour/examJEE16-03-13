package tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// TODO: Auto-generated Javadoc
/**
 * Entity implementation class for Entity: Gang.
 */
@Entity
public class Gang implements Serializable {

	/** The id gang. */
	@Id
	private int idGang;

	/** The name gang. */
	private String nameGang;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The killers. */
	@OneToMany(mappedBy = "gang", cascade = CascadeType.MERGE)
	private List<Killer> killers;

	/**
	 * Instantiates a new gang.
	 */
	public Gang() {
		super();
	}

	/**
	 * Gets the id gang.
	 * 
	 * @return the id gang
	 */
	public int getIdGang() {
		return this.idGang;
	}

	/**
	 * Sets the id gang.
	 * 
	 * @param idGang
	 *            the new id gang
	 */
	public void setIdGang(int idGang) {
		this.idGang = idGang;
	}

	/**
	 * Gets the name gang.
	 * 
	 * @return the name gang
	 */
	public String getNameGang() {
		return this.nameGang;
	}

	/**
	 * Sets the name gang.
	 * 
	 * @param nameGang
	 *            the new name gang
	 */
	public void setNameGang(String nameGang) {
		this.nameGang = nameGang;
	}

	/**
	 * Gets the killers.
	 * 
	 * @return the killers
	 */
	public List<Killer> getKillers() {
		return killers;
	}

	/**
	 * Sets the killers.
	 * 
	 * @param killers
	 *            the new killers
	 */
	public void setKillers(List<Killer> killers) {
		this.killers = killers;
	}

	/**
	 * Link killers to this gang.
	 * 
	 * @param killers
	 *            the killers
	 */
	public void linkKillersToThisGang(List<Killer> killers) {
		this.killers = killers;
		for (Killer k : killers) {
			k.setGang(this);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gang [idGang=" + idGang + ", nameGang=" + nameGang
				+ ", killers=" + killers + "]";
	}

}
