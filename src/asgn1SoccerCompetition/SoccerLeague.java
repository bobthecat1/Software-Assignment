package asgn1SoccerCompetition;

import java.util.Collections;
import java.util.LinkedList;

import asgn1Exceptions.LeagueException;
import asgn1Exceptions.TeamException;

/**
 * A class to model a soccer league. Matches are played between teams and points awarded for a win,
 * loss or draw. After each match teams are ranked, first by points, then by goal difference and then
 * alphabetically. 
 * 
 * @author Alan Woodley
 * @version 1.0
 *
 */
public class SoccerLeague implements SportsLeague{
	// Specifies the number of team required/limit of teams for the league
	private int requiredTeams;
	// Specifies is the league is in the off season
	private boolean offSeason;

	private int currentNumTeams = 0;
	
	private LinkedList<SoccerTeam> Teams = new LinkedList<SoccerTeam>();
	//creates a linked list of SoccerTeams
	
	/**
	 * Generates a model of a soccer team with the specified number of teams. 
	 * A season can not start until that specific number of teams has been added. 
	 * One that number of teams has been research no more teams can be added unless
	 * a team is first removed. 
	 * 
	 * UPDATE!:
	 * “Once that number of teams has been reached 
	 * no more teams can be added unless a team is first removed.”
	 * 
	 * 
	 * @param requiredTeams The number of teams required/limit for the league.
	 */
	//adds the parameter to requiredTeams check if it 
	//is greater than 0 if it is ends the season
	public SoccerLeague (int requiredTeams){
		this.requiredTeams = requiredTeams;
		if(this.requiredTeams > 0){
			offSeason = true;
		}
	}

	
	/**
	 * Registers a team to the league.
	 * 
	 * @param team Registers a team to play in the league.
	 * @throws LeagueException If the season has already started, if the maximum number of 
	 * teams allowed to register has already been reached or a team with the 
	 * same official name has already been registered.
	 */
	
	//checks the linked list for team that checks it is equal to one in the 
	public void registerTeam(SoccerTeam team) throws LeagueException {
		 if(offSeason == false){
			 throw new LeagueException("Season already start");
		 }
		 if(currentNumTeams >= requiredTeams){
			 throw new LeagueException("the current number of teams registered has already been reached");
		 }
		for(SoccerTeam each : Teams){
			if(team.equals(each)){
				throw new LeagueException("a team with the same offical name has already been registed"); 
			}
		}
		 currentNumTeams += 1;
		 Teams.add(team);
	}
	
	/**
	 * Removes a team from the league.
	 * 
	 * @param team The team to remove
	 * @throws LeagueException if the season has not ended or if the team is not registered into the league.
	 */
	// runs through the linked list compares the parameter to "each" if finds a match
	// remove the team from the linked list and minus one from the private variable 
	//if no team is found throw LeagueException
	public void removeTeam(SoccerTeam team) throws LeagueException{
		if(offSeason == false){
			throw new LeagueException();
		} 
		for(SoccerTeam each : Teams){
			if(team.equals(each)){
				Teams.remove(each);
				currentNumTeams -= 1;
				return;
			}
		}
		throw new LeagueException("not registered in league");
	}
	
	/** 
	 * Gets the number of teams currently registered to the league
	 * 
	 * @return the current number of teams registered
	 */
	public int getRegisteredNumTeams(){
		return currentNumTeams;
	}
	
	/**
	 * Gets the number of teams required for the league to begin its 
	 * season which is also the maximum number of teams that can be registered
	 * to a league.

	 * @return The number of teams required by the league/maximum number of teams in the league
	 */
	public int getRequiredNumTeams(){
		return requiredTeams;
	}
	
	/** 
	 * Starts a new season by reverting all statistics for each times to initial values.
	 * 
	 * UPDATE!:
	 * “Starts a new season by reverting 
	 * all statistics for each team to initial values.”
	 * 
	 * @throws LeagueException if the number of registered teams does not equal the required number of teams or if the season has already started
	 */
	//check for exceptions, starts the season , and runs sort teams function
	public void startNewSeason() throws LeagueException{
		if(currentNumTeams != requiredTeams){
			throw new LeagueException("The number of teams registered does not equal the required number of teams");
		}else if(offSeason == false){
			throw new LeagueException("The season has allready started");
		}
		offSeason = false;
		sortTeams();
	}
	

	/**
	 * Ends the season.
	 * 
	 * @throws LeagueException if season has not started
	 */
	//runs through the linked list resets stats of each team
	public void endSeason() throws LeagueException{
		if(offSeason == true){
			throw new LeagueException("Season has not started");
		}else{
			offSeason = true;
		}
		for(SoccerTeam each : Teams){
			each.resetStats();
		}
		// TO DO 
	}
	
	/**
	 * Specifies if the league is in the off season (i.e. when matches are not played).
	 * @return True If the league is in its off season, false otherwise.
	 */
	public boolean isOffSeason(){
		return this.offSeason;
	}
	
	
	
	/**
	 * Returns a team with a specific name.
	 * 
	 * @param name The official name of the team to search for.
	 * @return The team object with the specified official name.
	 * @throws LeagueException if no team has that official name.
	 */
	public SoccerTeam getTeamByOfficalName(String name) throws LeagueException{
		//checks the linked list for the 
		for(SoccerTeam each : Teams){
			if(name.equals(each.getOfficialName())){
				return each;
			}	
		}
		throw new LeagueException("No team has that offical name"); 
	}
		
	/** 
	 * Plays a match in a specified league between two teams with the respective goals. After each match the teams are
	 * resorted.
     *
	 * @param homeTeamName The name of the home team.
	 * @param homeTeamGoals The number of goals scored by the home team.
	 * @param awayTeamName The name of the away team.
	 * @param awayTeamGoals The number of goals scored by the away team.
	 * @throws LeagueException If the season has not started or if both teams have the same official name. 
	 */
	//runs a foreach loop check homeTeamName and awayTeamName is equal 
	//to the memory location of each official name
	//if they match use each to run play match function add goal arguments 
	//uses try catch over each to avoid exception errors, at the end of the function 
	//run sortTeams method
	public void playMatch(String homeTeamName, int homeTeamGoals, String awayTeamName, int awayTeamGoals) throws LeagueException{
		if(homeTeamName.equals(awayTeamName)){
			throw new LeagueException("Home team and away team have the same name");
		}else if(offSeason == true){
			throw new LeagueException("Season has not Started");
		}
		for(SoccerTeam each : Teams){
			
    		if(homeTeamName.equals(each.getOfficialName())){
    			try {
					each.playMatch(homeTeamGoals, awayTeamGoals);
				} catch (TeamException exception) {
					System.out.println(exception.getMessage());
					exception.printStackTrace();
				}
    		}
    		else if(awayTeamName.equals(each.getOfficialName())){
    			try {
					each.playMatch(awayTeamGoals, homeTeamGoals);
				} catch (TeamException exception) {
					System.out.println(exception.getMessage());
					exception.printStackTrace();
				}	
    		}
    		}
		sortTeams();
	}
	
	/**
	 * Displays a ranked list of the teams in the league  to the screen.
	 */
	public void displayLeagueTable(){
		//shows the teams
		for(SoccerTeam each : Teams){
			each.displayTeamDetails();
		}		
	}	
	
	/**
	 * Returns the highest ranked team in the league.
     *
	 * @return The highest ranked team in the league. 
	 * @throws LeagueException if the number of teams is zero or less than the required number of teams.
	 */
	public SoccerTeam getTopTeam() throws LeagueException{
		//uses linkedlist get last function to access the the last element in a linkedlist
		if(currentNumTeams == 0){
			throw new LeagueException("the current number of teams is equal to 0");		
		}else if (currentNumTeams < requiredTeams){
			throw new LeagueException("Current number of teams is less than required teams");
		}
		return Teams.getFirst();
	}

	/**
	 * Returns the lowest ranked team in the league.
     *
	 * @return The lowest ranked team in the league. 
	 * @throws LeagueException if the number of teams is zero or less than the required number of teams.
	 */

	//uses linkedlist get last function to access the the last element in a linkedlist
	public SoccerTeam getBottomTeam() throws LeagueException{
		if(currentNumTeams == 0){
			throw new LeagueException("The current number of teams is equal to 0");
		}
		else if(currentNumTeams < requiredTeams){
			throw new LeagueException("Current number of teams is less than required teams");
		}
		return Teams.getLast();
	}

	/** 
	 * Sorts the teams in the league.
	 */
	//uses collection to sort
    public void sortTeams(){	
    	Collections.sort(Teams);
    }
    
    /**
     * Specifies if a team with the given official name is registered to the league.
     * 
     * @param name The name of a team.
     * @return True if the team is registered to the league, false otherwise. 
     */
    public boolean containsTeam(String name){
    	//checks if the team is in the linked list by checking if its name is there
    	//if it is return true else return false
    	for(SoccerTeam each : Teams)
    	{	
    		if(name.equals(each.getOfficialName()))
    		{
    			return true;
    		}
    	}
    	return false; 
    }
}
