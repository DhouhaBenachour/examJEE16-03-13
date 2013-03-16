package tn.edu.esprit.bettaiebProjects.killerInstinctEjb.action;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model.Gang;
import tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model.Job;
import tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model.Killer;

// TODO: Auto-generated Javadoc
/**
 * The Interface CriminalCaseServicesRemote.
 */
@Remote
public interface CriminalCaseServicesRemote {

	/**
	 * Adds the gang.
	 * 
	 * @param gang
	 *            the gang
	 * @return true, if successful
	 */
	boolean addGang(Gang gang);

	/**
	 * Adds the killer.
	 * 
	 * @param killer
	 *            the killer
	 * @return true, if successful
	 */
	boolean addKiller(Killer killer);

	/**
	 * Adds the job.
	 * 
	 * @param job
	 *            the job
	 * @return true, if successful
	 */
	boolean addJob(Job job);

	/**
	 * Assign killer to gang.
	 * 
	 * @param idKiller
	 *            the id killer
	 * @param idGang
	 *            the id gang
	 * @return true, if successful
	 */
	boolean assignKillerToGang(int idKiller, int idGang);

	/**
	 * Creates the crime.
	 * 
	 * @param idkiller
	 *            the idkiller
	 * @param idJob
	 *            the id job
	 * @param weapon
	 *            the weapon
	 * @param dateOfAssasination
	 *            the date of assasination
	 * @return the object
	 */
	boolean createCrime(int idkiller, int idJob, String weapon,
			Date dateOfAssasination);

	/**
	 * Find gang by job.
	 * 
	 * @param idJob
	 *            the id job
	 * @return the gang
	 */
	Gang chkoun9tal(int idJob);

	/**
	 * Find jobs by gang.
	 * 
	 * @param idGang
	 *            the id gang
	 * @return the list
	 */
	List<String> findJobsByGang(int idGang);

}
