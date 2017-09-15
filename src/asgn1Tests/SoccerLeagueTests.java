package asgn1Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn1Exceptions.LeagueException;
import asgn1Exceptions.TeamException;
import asgn1SoccerCompetition.SoccerLeague;
import asgn1SoccerCompetition.SoccerTeam;


/**
 * A set of JUnit tests for the asgn1SoccerCompetition.SoccerLeage class
 *
 * @author Alan Woodley
 *
 */
public class SoccerLeagueTests {
	SoccerLeague test1;
	SoccerLeague test2;
	SoccerLeague test3;
	SoccerTeam Team1;
	SoccerTeam Team2;
	SoccerTeam Team3;
	SoccerTeam Team4;
	SoccerTeam Team5;
	
	private final int Zero = 0;
	private final int One = 1;
	private final int Two = 2;
	private final int Three = 3;
	private final int Four = 4;
	private final int Five = 5;
	private final int Six = 6;
	private final int Seven = 7;
	private final int Eight = 8;
	private final int Nine = 9;
	private final int Ten = 10;
	private final int Eleven = 11;
	private final int Twelve = 12;
	private final int Thridteen= 13;
	private final int FourTeen = 14;
	private final int Fithteen = 15;
	private final int Sixteen = 16;
	private final int SevenTeen = 17;
	private final int Eighteen = 18;
	private final int Nineteen = 19;
	private final int Twenty = 20;
	private final int TwentyOne = 21;
	
	@Before
	public void Before() throws TeamException, LeagueException{
		Team1 = new SoccerTeam("Team1","Blank");
		Team2 = new SoccerTeam("Team2","Blank");
		Team3 = new SoccerTeam("Team3","Blank");
		Team4 = new SoccerTeam("Team4","Blank");
		Team5 = new SoccerTeam("Team5","Blank");
	}
	@Test
	public void differentTypes(){
		test1 = new SoccerLeague(Four);
	}
	@Test(expected = LeagueException.class)
	public void teamSameOfficalName() throws LeagueException{
		test1 = new SoccerLeague(Four);
		test1.registerTeam(Team1);
		test1.registerTeam(Team1);
	}
	@Test(expected = LeagueException.class)
	public void sameTeamTwice() throws LeagueException{
		test1 = new SoccerLeague(Two);
		test1.registerTeam(Team2);
		test1.registerTeam(Team2);
	}
	@Test
	public void checkRemoveFromTeam() throws LeagueException{
		test1 = new SoccerLeague(Four);
		test1.registerTeam(Team1);
		test1.removeTeam(Team1);
		assertFalse(test1.containsTeam(Team1.getOfficialName()));
	}
	@Test(expected = LeagueException.class)
	public void checkRemoveTeamException1() throws LeagueException{
		test1 = new SoccerLeague(Four);
		test1.removeTeam(Team1);
	}
	@Test(expected = LeagueException.class)
	public void checkRemoveTeamException2() throws LeagueException{
		test1 = new SoccerLeague(Four);
		test1.startNewSeason();
		test1.removeTeam(Team1);
	}
	@Test(expected = LeagueException.class)
	public void testPlayMatch() throws LeagueException{
		test1 = new SoccerLeague(Four);
		test1.playMatch(Team1.getOfficialName(), One, Team1.getOfficialName(), One);
	}
	@Test
	public void checkLastTeam() throws LeagueException{
		test1 = new SoccerLeague(Two);
		test1.registerTeam(Team1);
		test1.registerTeam(Team2);
		test1.startNewSeason();
		test1.playMatch(Team1.getOfficialName(), Five, Team2.getOfficialName(), Seven);
		assertEquals(Team1,test1.getBottomTeam());	
	}
	@Test
	public void checkTopTeam() throws LeagueException{
		test1 = new SoccerLeague(Four);
		test1.registerTeam(Team1);
		test1.registerTeam(Team3);
		test1.registerTeam(Team4);
		test1.registerTeam(Team5);
		test1.startNewSeason();
		test1.playMatch(Team5.getOfficialName(), Three, Team4.getOfficialName(), Four);
		test1.playMatch(Team1.getOfficialName(), Five, Team3.getOfficialName(), Seven);
		assertEquals(Team3,test1.getTopTeam());	
	}
	@Test
	public void twoLeaguesTopTeam() throws LeagueException{
		test1 = new SoccerLeague(Two);
		test1.registerTeam(Team3);
		test1.registerTeam(Team1);
		test1.startNewSeason();
		test1.playMatch(Team1.getOfficialName(), Five, Team3.getOfficialName(), Seven);
		assertEquals(Team3,test1.getTopTeam());	
	}
	@Test
	public void checkcontainsTeam() throws LeagueException{
		test1 = new SoccerLeague(Two);
		test1.registerTeam(Team3);
		assertEquals(true,test1.containsTeam(Team3.getOfficialName()));
	}
	@Test
	public void checkcontainsTeam2() throws LeagueException{
		test1 = new SoccerLeague(Two);
		assertEquals(false,test1.containsTeam(Team3.getOfficialName()));
	}
	@Test
	public void checkSortTeams() throws LeagueException{
		test1 = new SoccerLeague(Two);
		test1.registerTeam(Team1);
		test1.registerTeam(Team2);
		test1.startNewSeason();
		test1.playMatch(Team1.getOfficialName(), Five, Team2.getOfficialName(), Seven);
		assertEquals(Team2,test1.getTopTeam());	
		assertEquals(Team1,test1.getBottomTeam());	
	}
}

