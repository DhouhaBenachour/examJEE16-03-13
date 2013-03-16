package tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * Entity implementation class for Entity: Crime.
 */
@Entity
public class Crime implements Serializable {

	/** The crime pk. */
	@EmbeddedId
	private CrimePK crimePK;

	/** The weapon. */
	private String weapon;

	/** The date of the crime. */
	private Date dateOfTheCrime;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The killer. */
	@ManyToOne
	@JoinColumn(name = "idK", referencedColumnName = "idKiller", updatable = false, insertable = false)
	private Killer killer;

	/** The job. */
	@ManyToOne
	@JoinColumn(name = "idJ", referencedColumnName = "idJob", updatable = false, insertable = false)
	private Job job;

	/**
	 * Instantiates a new crime.
	 */
	public Crime() {
		super();
	}

	/**
	 * Gets the weapon.
	 * 
	 * @return the weapon
	 */
	public String getWeapon() {
		return this.weapon;
	}

	/**
	 * Sets the weapon.
	 * 
	 * @param weapon
	 *            the new weapon
	 */
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	/**
	 * Gets the date of the crime.
	 * 
	 * @return the date of the crime
	 */
	public Date getDateOfTheCrime() {
		return this.dateOfTheCrime;
	}

	/**
	 * Sets the date of the crime.
	 * 
	 * @param dateOfTheCrime
	 *            the new date of the crime
	 */
	public void setDateOfTheCrime(Date dateOfTheCrime) {
		this.dateOfTheCrime = dateOfTheCrime;
	}

	/**
	 * Gets the crime pk.
	 * 
	 * @return the crime pk
	 */
	public CrimePK getCrimePK() {
		return crimePK;
	}

	/**
	 * Sets the crime pk.
	 * 
	 * @param crimePK
	 *            the new crime pk
	 */
	public void setCrimePK(CrimePK crimePK) {
		this.crimePK = crimePK;
	}

	/**
	 * Gets the killer.
	 * 
	 * @return the killer
	 */
	public Killer getKiller() {
		return killer;
	}

	/**
	 * Sets the killer.
	 * 
	 * @param killer
	 *            the new killer
	 */
	public void setKiller(Killer killer) {
		this.killer = killer;
	}

	/**
	 * Gets the job.
	 * 
	 * @return the job
	 */
	public Job getJob() {
		return job;
	}

	/**
	 * Sets the job.
	 * 
	 * @param job
	 *            the new job
	 */
	public void setJob(Job job) {
		this.job = job;
	}

	/**
	 * Instantiates a new crime.
	 * 
	 * @param weapon
	 *            the weapon
	 * @param dateOfTheCrime
	 *            the date of the crime
	 * @param killer
	 *            the killer
	 * @param job
	 *            the job
	 */
	public Crime(String weapon, Date dateOfTheCrime, Killer killer, Job job) {
		super();
		this.weapon = weapon;
		this.dateOfTheCrime = dateOfTheCrime;
		this.killer = killer;
		this.job = job;
		this.crimePK = new CrimePK(killer.getIdKiller(), job.getIdJob());
	}

}
