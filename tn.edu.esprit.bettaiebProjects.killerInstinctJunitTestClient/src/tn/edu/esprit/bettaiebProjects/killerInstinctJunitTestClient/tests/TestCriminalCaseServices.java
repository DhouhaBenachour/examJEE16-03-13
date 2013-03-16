package tn.edu.esprit.bettaiebProjects.killerInstinctJunitTestClient.tests;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.bettaiebProjects.killerInstinctEjb.action.CriminalCaseServicesRemote;
import tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model.Gang;
import tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model.Job;
import tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model.Killer;

public class TestCriminalCaseServices {
	private Context context;
	private CriminalCaseServicesRemote proxy;

	@Before
	public void setUp() throws Exception {
		context = new InitialContext();
		proxy = (CriminalCaseServicesRemote) context
				.lookup("ejb:/tn.edu.esprit.bettaiebProjects.killerInstinctEjb/CriminalCaseServices!tn.edu.esprit.bettaiebProjects.killerInstinctEjb.action.CriminalCaseServicesRemote");
	}

	/**
	 * Test init db.
	 */
	@Test
	public void testInitDB() {
		Gang gang = new Gang();
		gang.setIdGang(1);
		gang.setNameGang("yakuza");

		Gang gang2 = new Gang();
		gang2.setIdGang(2);
		gang2.setNameGang("yamakazi");

		Killer killer = new Killer();
		killer.setIdKiller(1);
		killer.setNameKiller("naser damargi");

		Killer killer2 = new Killer();
		killer2.setIdKiller(2);
		killer2.setNameKiller("Al capone");

		Killer killer3 = new Killer();
		killer3.setIdKiller(3);
		killer3.setNameKiller("oswald");

		Job job = new Job();
		job.setIdJob(1);
		job.setNameOfTheVictim("JFK");

		Job job2 = new Job();
		job2.setIdJob(2);
		job2.setNameOfTheVictim("chokri beleid");

		Assert.assertEquals(true, proxy.addGang(gang));
		Assert.assertEquals(true, proxy.addGang(gang2));

		Assert.assertEquals(true, proxy.addKiller(killer));
		Assert.assertEquals(true, proxy.addKiller(killer2));
		Assert.assertEquals(true, proxy.addKiller(killer3));

		Assert.assertEquals(true, proxy.addJob(job));
		Assert.assertEquals(true, proxy.addJob(job2));

	}

	/**
	 * Test assign killer to gang. the first parameter passed to
	 * assignKillerToGang is the id of the killer the second is for the id of
	 * the gang
	 */
	@Test
	public void testAssignKillerToGang() {

		Assert.assertEquals(true, proxy.assignKillerToGang(1, 1));
		Assert.assertEquals(true, proxy.assignKillerToGang(2, 1));
		Assert.assertEquals(true, proxy.assignKillerToGang(3, 2));

	}

	/**
	 * Test create crime. the parameters passed to createCrime(int idkiller, int
	 * idJob, String weapon, Date dateOfAssasination)
	 */
	@Test
	public void testCreateCrime() {

		Assert.assertEquals(true,
				proxy.createCrime(1, 2, "sikkina", new Date()));

	}

	/**
	 * Test find gang by job. parameter of findGangByJob is the id of the job
	 */
	@Test
	public void testFindGangByJob() {
		Assert.assertEquals("yakuza", proxy.chkoun9tal(2).getNameGang());
	}

	@Test
	public void testFindJobByGang() {
		Assert.assertTrue(proxy.findJobsByGang(1).contains("chokri beleid"));
	}
}
