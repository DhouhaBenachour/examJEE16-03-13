package tn.edu.esprit.bettaiebProjects.killerInstinctEjb.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model.Crime;
import tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model.Gang;
import tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model.Job;
import tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model.Killer;

/**
 * Session Bean implementation class CriminalCaseServices
 */
@Stateless
public class CriminalCaseServices implements CriminalCaseServicesRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CriminalCaseServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addGang(Gang gang) {
		boolean b = false;
		try {
			entityManager.persist(gang);
			System.out.println("welcome to the new family : "
					+ gang.getNameGang());
			b = true;
		} catch (Exception e) {
			System.err.println("not yet ...");
		}
		return b;
	}

	@Override
	public boolean addKiller(Killer killer) {
		boolean b = false;
		try {
			entityManager.persist(killer);
			System.out.println("welcome to the new killer : "
					+ killer.getNameKiller());
			b = true;
		} catch (Exception e) {
			System.err.println("not yet ...");
		}
		return b;
	}

	@Override
	public boolean addJob(Job job) {
		boolean b = false;
		try {
			entityManager.persist(job);
			System.out
					.println("e new job is available the name of the victim is : "
							+ job.getNameOfTheVictim());
			b = true;
		} catch (Exception e) {
			System.err.println("not yet ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean assignKillerToGang(int idKiller, int idGang) {
		boolean b = false;
		try {

			Killer killer = entityManager.find(Killer.class, idKiller);
			Gang gang = entityManager.find(Gang.class, idGang);

			List<Killer> killers = new ArrayList<Killer>();
			killers = entityManager
					.createQuery("select k from Killer k where k.gang= :g")
					.setParameter("g", gang).getResultList();

			killers.add(killer);
			gang.linkKillersToThisGang(killers);

			entityManager.merge(gang);

			System.out.println("we have just added " + killer.getNameKiller()
					+ " to the family " + gang.getNameGang());

			b = true;
		} catch (Exception e) {
			System.err.println("fail again ...");
		}
		return b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tn.edu.esprit.bettaiebProjects.killerInstinctEjb.action.
	 * CriminalCaseServicesRemote#createCrime(int, int, java.lang.String,
	 * java.util.Date)
	 */
	@Override
	public boolean createCrime(int idkiller, int idJob, String weapon,
			Date dateOfAssasination) {
		boolean b = false;
		try {
			Killer killer = entityManager.find(Killer.class, idkiller);
			Job job = entityManager.find(Job.class, idJob);

			Crime crime = new Crime(weapon, dateOfAssasination, killer, job);

			entityManager.persist(crime);

			System.out.println("we just have the info that "
					+ killer.getNameKiller() + " have assasinated "
					+ job.getNameOfTheVictim() + "");
			b = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tn.edu.esprit.bettaiebProjects.killerInstinctEjb.action.
	 * CriminalCaseServicesRemote#findGangByJob(int)
	 */
	@Override
	public Gang chkoun9tal(int idJob) {
		Gang gang = null;
		try {
			Job job = entityManager.find(Job.class, idJob);

			String jpql = "select g from Gang g join g.killers ks join ks.crimes c where c.job=:j";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("j", job);

			gang = (Gang) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("ohhh not again ...");
		}
		return gang;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findJobsByGang(int idGang) {
		Gang gang = entityManager.find(Gang.class, idGang);
		String jpql = "select j.nameOfTheVictim from Job j join j.crimes c join c.killer k where k.gang =:g";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("g", gang);

		return query.getResultList();
	}

}
