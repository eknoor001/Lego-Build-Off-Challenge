package com.legoGame;


public class CompetitionLog {

	private int playerNumber;

	private String completeSets;

	private String incompleteSets;

	private int piecesBuilt;

	public CompetitionLog(int playerNumber, String completeSets, String incompleteSets, int piecesBuilt) {
		super();
		this.playerNumber = playerNumber;
		this.completeSets = completeSets;
		this.incompleteSets = incompleteSets;
		this.piecesBuilt = piecesBuilt;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getCompleteSets() {
		this.completeSets = this.completeSets.substring(1, this.completeSets.length() - 1);

		

		return completeSets;
	}

	public void setCompleteSets(String completeSets) {
		if (this.completeSets.contains(completeSets)) {
			this.completeSets += "";

		}
		this.completeSets += completeSets;
	}

	public String getIncompleteSets() {
		this.incompleteSets = this.incompleteSets.substring(1, this.incompleteSets.length() - 1);
		return incompleteSets;
	}

	public void setIncompleteSets(String incompleteSets) {
		if (incompleteSets.equals(incompleteSets))
			if (this.incompleteSets.contains("None") && incompleteSets.equals("None"))

			{
				this.incompleteSets += "";

			} else {
				if (this.incompleteSets.contains("None")) {
					this.incompleteSets = "";
				}
				this.incompleteSets += incompleteSets;
			}

	}

	public int getPiecesBuilt() {
		return piecesBuilt;
	}

	public void setPiecesBuilt(int piecesBuilt) {
		this.piecesBuilt = piecesBuilt;
	}

	public String toString() {
		return "Player " + this.playerNumber + " completed the following sets: " + this.getCompleteSets() + "\n"
				+ "Player " + this.playerNumber + " did not complete the following sets: " + this.getIncompleteSets()
				+ "\n" + "Player " + this.playerNumber + " built a total of piecesBuilt " + this.piecesBuilt;
	}

}
