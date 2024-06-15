package com.legoGame;

import java.util.Scanner;


public class LegoSetCompetition extends CompetitionLog {

	public LegoSetCompetition(int playerNumber, String completeSets, String incompleteSets, int piecesBuilt) {
		super(playerNumber, completeSets, incompleteSets, piecesBuilt);

	}

	static int days = 1;

	public static void main(String[] args) {
		CompetitionLog obj = new CompetitionLog(0, "", "", 0);
//		StringJoiner str = new StringJoiner(",");

		Scanner sc = new Scanner(System.in);
		boolean flag1 = false;

		String LegoGames[] = new String[3];
		int NumberOfPeices[] = new int[3];
		int NumberPeices = 0;
		boolean flag = true;

		System.out.println("Enter the Number of players: ");
		obj.setPlayerNumber(sc.nextInt());
		CompetitionLog arr[] = new CompetitionLog[obj.getPlayerNumber()];
		for (int i = 0; i < obj.getPlayerNumber(); i++) {
			arr[i] = new CompetitionLog((i + 1), "", "", 0);
		}
		//int playerCount[] = new int[obj.getPlayerNumber()];

		do {
			flag = true;
			System.out.println("Welcome to the Lego Set Competition!");

			for (int i = 0; i < 3; i++) {
				System.out.println("Enter the name of LegoSet " + (i + 1) + " :");
				LegoGames[i] = sc.next();
				System.out.println("Enter the number of pieces in Lego Set " + (i + 1) + " :");
				NumberOfPeices[i] = sc.nextInt();
				NumberPeices += NumberOfPeices[i];

			}

			// Calculation for winner and complete sets and incomplete sets
			do {

				for (int j = 0; j < obj.getPlayerNumber(); j++) {
					System.out.println("Enter the number of pieces player " + arr[j].getPlayerNumber()
							+ " used for building on day " + days);
					arr[j].setPiecesBuilt(arr[j].getPiecesBuilt() + sc.nextInt());

					if (arr[j].getPiecesBuilt() >= NumberPeices) {
						flag = false;
					}
				}
				days++;
			} while (flag);

			// add the lego sets based on some condition
			for (int j = 0; j < obj.getPlayerNumber(); j++) {
				for (int i = NumberOfPeices.length - 1; i >= 0; i--) {

					if (arr[j].getPiecesBuilt() >= NumberPeices) {
						arr[j].setCompleteSets(", "+LegoGames[0]+"," + LegoGames[1]+"," + LegoGames[2]+",");
						arr[j].setIncompleteSets(" None ");
						break;
					} else if (arr[j].getPiecesBuilt() >= (NumberPeices - NumberOfPeices[i])) {

						arr[j].setCompleteSets(", "+LegoGames[0]+","+ LegoGames[1]+",");
						arr[j].setIncompleteSets(", "+LegoGames[2]+",");
						break;
					} else if (arr[j].getPiecesBuilt() >= (NumberPeices - NumberOfPeices[i] - NumberOfPeices[i - 1])) {
						arr[j].setCompleteSets(", "+LegoGames[0]+",");
						arr[j].setIncompleteSets(", "+LegoGames[1]+"," + LegoGames[2]+",");
						break;
					} else {
						arr[j].setCompleteSets(" None ");
						arr[j].setIncompleteSets(", "+LegoGames[0]+"," + LegoGames[1]+"," + LegoGames[2]+",");
						break;
					}

				}
			}
			/////////////////////////////////////
			int total = 0;
			for (int i = 0; i < obj.getPlayerNumber(); i++) {
				total += arr[i].getPiecesBuilt();
			}
			flag1 = false;
			if (total == (obj.getPlayerNumber() * NumberPeices)) {
				flag1 = true;
				System.out.println("The competition ended in a tie! There will be a tiebreaker round\n");
			}
			/////////////////////////////////////
			String winner = null;
			for (int i = 0; i < obj.getPlayerNumber(); i++) {

				if (flag1 == true) {
					winner = "1 And 2";
				}
				else
					{
					
					if(arr[i].getPiecesBuilt() >= NumberPeices) {
					int w = i + 1;
					winner = String.valueOf(w);
				}
					}
			}

			//// print the additional information
			System.out.println("Congratulations to player " + winner + " for winning the Lego Set Competition!\n"
					+ "Additional information about the competition results is below");
			for (int i = 0; i < obj.getPlayerNumber(); i++) {
				System.out.println(arr[i].toString());
			}
			System.out.println("The competition lasted " + (days - 1) + " days");
			/////////////////////////////////////////

		} while (flag1);

	}

}
