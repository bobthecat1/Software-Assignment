/**
 * 
 */
package asgn1SoccerCompetition;

import java.util.LinkedList;

import asgn1Exceptions.CompetitionException;
import asgn1Exceptions.LeagueException;
import asgn1Exceptions.TeamException;

/**
 * A class to model a soccer competition. The competition contains one or more number of leagues, 
 * each of which contain a number of teams. Over the course a season matches are played between
 * teams in each league. At the end of the season a premier (top ranked team) and wooden spooner 
 * (bottom ranked team) are declared for each league. If there are multiple leagues then relegation 
 * and promotions occur between the leagues.
 * 
 * @author Alan Woodley
 * @version 1.0
 *
 */
public class SoccerCompetition implements SportsCompetition{
	
	String name;
	int numLeagues;
	int numTeams;
	
	private final int firstIteration = 0;
	private final int secondIteration = 1;
	private final int thridIteration = 2;
	private final int sizeOfOne = 1;
	private final int sizeOfTwo = 2;
	private final int resetIndex = 0;
	private LinkedList<SoccerLeague> Leagues = new LinkedList<SoccerLeague>();
	/**
	 * Creates the model for a new soccer competition with a specific name,
	 * number of leagues, and number of games to display to indicate the teams
	 * form. 
	 * 
	 * UPDATE!:
	 * Creates the model for a new soccer competition with a specific name, 
	 * number of leagues and number of teams in each league”
	 * 
	 * @param name The name of the competition.
	 * @param numLeagues The number of leagues in the competition.
	 * @param numTeams The number of teams in each league.
	 */
	//runs through the foreach loop creates blanks of the SoccerLeague type adds it to Leagues
	public SoccerCompetition(String name, int numLeagues, int numTeams){
		this.name = name;
		this.numLeagues = numLeagues;
		this.numTeams = numTeams;
		for(int leaguesIndex = 0; leaguesIndex < numLeagues; leaguesIndex++){
			SoccerLeague blank = new SoccerLeague(numTeams);
			Leagues.addFirst(blank);
		}
	}
	
	/**
	 * Retrieves a league with a specific number (indexed from 0). Returns an exception if the 
	 * league number is invalid.
	 * 
	 * @param leagueNum The number of the league to return.
	 * @return A league specified by leagueNum.
	 * @throws CompetitionException if the specified league number is less than 0.
	 *  or equal to or greater than the number of leagues in the competition.
	 */
	public SoccerLeague getLeague(int leagueNum) throws CompetitionException{
		if(leagueNum < 0){
 			throw new CompetitionException("league num is less than 0 or league num is greater than league.size");
		}
		if(leagueNum >= numLeagues)
		{
			throw new CompetitionException("league num is less than 0 or league num is greater than league.size");
		}
		return Leagues.get(leagueNum);
	
	}
	

	/**
	 * Starts a new soccer season for each league in the competition.
	 */
	//runs through linked list to start season, uses try catch to avoid errors
	public void startSeason() {
		
		try{
		for(SoccerLeague each : Leagues){
			each.startNewSeason();
		}
		} catch(LeagueException each){
			
			System.out.println(each.getMessage());
			each.printStackTrace();
		}
	}

	
	/** 
	 * Ends the season of each of the leagues in the competition. 
	 * If there is more than one league then it handles promotion
	 * and relegation between the leagues.  
	 * 
	 */
	
	//End season has 4 loops,the first loop ends the seasons. If statement checks that size does 
	//not equal 1, as no swapping between leagues will need to be done if size is 1
	//second loop assigns the SoccerTeam variable to lowest and highest in each iteration, 
	//also checks that the size of the linkedlist leagues is greater than two
	//that way it only assigns if there is going to be a third loop iteration.
	//Third loop removes the SoccerTeams Assigned, the fourth registers teams 
	//in positions of promotion.
	public void endSeason()  {
		try{
			for(int endSeasonIndex = 0; endSeasonIndex < Leagues.size(); endSeasonIndex++){
				Leagues.get(endSeasonIndex).endSeason();
			}
		if(Leagues.size() != sizeOfOne){
			
			SoccerTeam Lowest = new SoccerTeam("Blank","Blank");
			SoccerTeam Highest = new SoccerTeam("Blank","Blank");
			SoccerTeam LowestSecondLeague= new SoccerTeam("Blank","Blank");
			SoccerTeam HighestThridLeague = new SoccerTeam("Blank","Blank"); 
			//assign blanks, errors if you assign null
			
			int reassignIndex = resetIndex;
				for(SoccerLeague each : Leagues){
					if(reassignIndex == firstIteration){
						Lowest = each.getBottomTeam();
					}else if(reassignIndex == secondIteration){
						Highest = each.getTopTeam();
					if(Leagues.size() > sizeOfTwo){
						LowestSecondLeague = each.getBottomTeam();
					}
					}else if(reassignIndex == thridIteration){
						HighestThridLeague = each.getTopTeam();
					}
				reassignIndex++;
				}
			
			reassignIndex = resetIndex;
				for(SoccerLeague each : Leagues){
					if(reassignIndex == firstIteration){
						each.removeTeam(Lowest);
					}else if(reassignIndex == secondIteration){
						each.removeTeam(Highest);
					if(Leagues.size() > sizeOfTwo){
						each.removeTeam(LowestSecondLeague);
					}
					}else if(reassignIndex == thridIteration){
						each.removeTeam(HighestThridLeague);
					}
			reassignIndex++;
				}
			reassignIndex = resetIndex;
				for(SoccerLeague each : Leagues){
					if(reassignIndex==firstIteration){
						each.registerTeam(Highest);
					}else if(reassignIndex == secondIteration){
						each.registerTeam(Lowest);
					if(Leagues.size() > sizeOfTwo){
						each.registerTeam(HighestThridLeague);
					}
					}
					else if(reassignIndex== thridIteration){
						each.registerTeam(LowestSecondLeague);
					}
					reassignIndex++;
				}
			}
			} catch(LeagueException | TeamException each){
				System.out.println(each.getMessage());
				each.printStackTrace();
			}
			
	}

	/** 
	 * For each league displays the competition standings.
	 */
	public void displayCompetitionStandings(){
		System.out.println("+++++" + this.name + "+++++");
		int displayIndex = resetIndex;
		for(SoccerLeague each : Leagues){
			System.out.println("---- League" + (displayIndex +1) + " ----");
			System.out.println("Official Name" +  '\t' +  "Nick Name" + '\t' + "Form" + '\t' +  "Played" + '\t' + "Won" + '\t' + "Lost" + '\t' + "Drawn" + '\t' + "For" + '\t' + "Against" + '\t' + "GlDiff" + '\t' + "Points");
			each.displayLeagueTable();
			displayIndex++;
		}
	}
	

}
