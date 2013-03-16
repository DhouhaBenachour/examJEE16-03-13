package tn.edu.esprit.bettaiebProjects.killerInstinctEjb.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CrimePK implements Serializable {
	private int idK;
	private int idJ;

	public int getIdK() {
		return idK;
	}

	/**
	 * Sets the id k.
	 * 
	 * @param idK
	 *            the new id k
	 */
	public void setIdK(int idK) {
		this.idK = idK;
	}

	public int getIdJ() {
		return idJ;
	}

	public void setIdJ(int idJ) {
		this.idJ = idJ;
	}

	public CrimePK() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idJ;
		result = prime * result + idK;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrimePK other = (CrimePK) obj;
		if (idJ != other.idJ)
			return false;
		if (idK != other.idK)
			return false;
		return true;
	}

	public CrimePK(int idK, int idJ) {
		super();
		this.idK = idK;
		this.idJ = idJ;
	}

}
