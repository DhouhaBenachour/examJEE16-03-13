package tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// TODO: Auto-generated Javadoc
/**
 * Entity implementation class for Entity: Job.
 */
@Entity
public class Job implements Serializable {

	/** The id job. */
	@Id
	private int idJob;

	/** The name of the victim. */
	private String nameOfTheVictim;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The crimes. */
	@OneToMany(mappedBy = "job")
	private List<Crime> crimes;

	/**
	 * Instantiates a new job.
	 */
	public Job() {
		super();
	}

	/**
	 * Gets the id job.
	 * 
	 * @return the id job
	 */
	public int getIdJob() {
		return this.idJob;
	}

	/**
	 * Sets the id job.
	 * 
	 * @param idJob
	 *            the new id job
	 */
	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}

	/**
	 * Gets the name of the victim.
	 * 
	 * @return the name of the victim
	 */
	public String getNameOfTheVictim() {
		return this.nameOfTheVictim;
	}

	/**
	 * Sets the name of the victim.
	 * 
	 * @param nameOfTheVictim
	 *            the new name of the victim
	 */
	public void setNameOfTheVictim(String nameOfTheVictim) {
		this.nameOfTheVictim = nameOfTheVictim;
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
