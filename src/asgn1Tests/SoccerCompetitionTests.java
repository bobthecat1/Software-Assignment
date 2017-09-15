package asgn1Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn1Exceptions.CompetitionException;
import asgn1Exceptions.LeagueException;
import asgn1Exceptions.TeamException;
import asgn1SoccerCompetition.SoccerCompetition;
import asgn1SoccerCompetition.SoccerLeague;
import asgn1SoccerCompetition.SoccerTeam;

/**
 * A set of JUnit tests for the asgn1SoccerCompetition.SoccerCompetition class
 *
 * @author Alan Woodley
 *
 */
public class SoccerCompetitionTests {
	SoccerTeam Team1;
	SoccerTeam Team2;
	SoccerTeam Team3;
	SoccerTeam Team4;
	SoccerTeam Team5;
	SoccerTeam Team6;
	
	private final int LeagueOne = 0;
	private final int LeagueTwo = 1;
	private final int LeagueThree = 2;
	
	
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
	@Before
	public void setUp() throws CompetitionException, TeamException{
		
		Team1 = new SoccerTeam("Test1","Blank1");
		Team2 = new SoccerTeam("Test2","Blank2");
		Team3 = new SoccerTeam("Test3","Blank3");
		Team4 = new SoccerTeam("Test4","Blank4");
		Team5 = new SoccerTeam("Test5","Blank5");
		Team6 = new SoccerTeam("Test6","Blank6");
		}
	
	@Test(expected = CompetitionException.class)
	public void CheckGetLeagueException1() throws CompetitionException{
		SoccerCompetition start = new SoccerCompetition("Competetion1",Three,One);
		start.getLeague(Five);
	}
	@Test(expected = CompetitionException.class)
	public void CheckGetLeagueException2() throws CompetitionException{
		SoccerCompetition start = new SoccerCompetition("Competetion1",Three,One);
		start.getLeague(-LeagueTwo);
	}
	@Test
	public void EndSeason() throws CompetitionException, LeagueException{
		SoccerCompetition start = new SoccerCompetition("Competetion1",Two,Two);
		start.getLeague(LeagueOne).registerTeam(Team1);
		start.getLeague(LeagueOne).registerTeam(Team2);
		start.getLeague(LeagueTwo).registerTeam(Team1);
		start.getLeague(LeagueTwo).registerTeam(Team2);
		start.startSeason();
		start.getLeague(LeagueOne).playMatch(Team1.getOfficialName(), One, Team2.getOfficialName(), Two);
		start.getLeague(LeagueOne);
		start.endSeason();
		start.displayCompetitionStandings();
	}
	@Test
	public void twoLeaguesWithOutEndingSeason() throws CompetitionException, LeagueException{
		SoccerCompetition start = new SoccerCompetition("Competetion2",Two,Two);
		start.getLeague(LeagueOne).registerTeam(Team1);
		start.getLeague(LeagueOne).registerTeam(Team2);
		start.getLeague(LeagueTwo).registerTeam(Team3);
		start.getLeague(LeagueTwo).registerTeam(Team4);
		start.startSeason();
		start.getLeague(LeagueOne).playMatch(Team1.getOfficialName(), Three, Team2.getOfficialName(), Two);
		start.getLeague(LeagueTwo).playMatch(Team3.getOfficialName(), Nineteen, Team4.getOfficialName(), One);
		start.getLeague(LeagueTwo).playMatch(Team5.getOfficialName(), Seven, Team6.getOfficialName(), Nineteen);
		start.displayCompetitionStandings();
		assertEquals(Team2,start.getLeague(LeagueOne).getBottomTeam());
	}
	@Test
	public void checkEndSeasonSwitchTwoLeagues() throws CompetitionException, LeagueException{
		SoccerCompetition start = new SoccerCompetition("Competetion2",Two,Two);
		start.getLeague(LeagueOne).registerTeam(Team1);
		start.getLeague(LeagueOne).registerTeam(Team2);
		start.getLeague(LeagueTwo).registerTeam(Team3);
		start.getLeague(LeagueTwo).registerTeam(Team4);
		start.startSeason();
		start.getLeague(LeagueOne).playMatch(Team1.getOfficialName(), Three, Team2.getOfficialName(), Two);
		start.getLeague(LeagueTwo).playMatch(Team3.getOfficialName(), Nineteen, Team4.getOfficialName(), One);
		start.getLeague(LeagueTwo).playMatch(Team5.getOfficialName(), Seven, Team6.getOfficialName(), Nineteen);
		start.displayCompetitionStandings();
		start.endSeason();
		assertEquals(Team1,start.getLeague(LeagueOne).getTopTeam());
		assertEquals(Team3,start.getLeague(LeagueOne).getBottomTeam());
		assertEquals(Team4,start.getLeague(One).getTopTeam());
		assertEquals(Team2,start.getLeague(One).getBottomTeam());
	}
	@Test
	public void checkEndSeasonSwitchThreeLeagues() throws CompetitionException, LeagueException{
		SoccerCompetition start = new SoccerCompetition("Competetion2",Three,Two);
		start.getLeague(LeagueOne).registerTeam(Team1);
		start.getLeague(LeagueOne).registerTeam(Team2);
		start.getLeague(LeagueTwo).registerTeam(Team3);
		start.getLeague(LeagueTwo).registerTeam(Team4);
		start.getLeague(LeagueThree).registerTeam(Team5);
		start.getLeague(LeagueThree).registerTeam(Team6);
		start.startSeason();
		start.getLeague(LeagueOne).playMatch(Team1.getOfficialName(), Three, Team2.getOfficialName(), Two);
		start.getLeague(LeagueTwo).playMatch(Team3.getOfficialName(), Nineteen, Team4.getOfficialName(), One);
		start.getLeague(LeagueThree).playMatch(Team5.getOfficialName(), Seven, Team6.getOfficialName(), Nineteen);
		start.displayCompetitionStandings();
		start.endSeason();
		assertEquals(Team3,start.getLeague(LeagueOne).getBottomTeam());
		assertEquals(Team2,start.getLeague(LeagueTwo).getTopTeam());
		assertEquals(Team6,start.getLeague(LeagueTwo).getBottomTeam());
		assertEquals(Team5,start.getLeague(LeagueThree).getTopTeam());
	}
	@Test
	public void checkBottomTeamOneLeagues() throws CompetitionException, LeagueException{
		SoccerCompetition start = new SoccerCompetition("Competetion3", One, Four);
		start.getLeague(LeagueOne).registerTeam(Team1);
		start.getLeague(LeagueOne).registerTeam(Team2);
		start.getLeague(LeagueOne).registerTeam(Team3);
		start.getLeague(LeagueOne).registerTeam(Team4);
		start.startSeason();
		start.getLeague(LeagueOne).playMatch(Team1.getOfficialName(), Three, Team2.getOfficialName(), Two);
		start.getLeague(LeagueOne).playMatch(Team3.getOfficialName(), Nineteen, Team4.getOfficialName(), One);
		start.displayCompetitionStandings();
		assertEquals(Team4,start.getLeague(LeagueOne).getBottomTeam());
	}
	@Test
	public void checkEndSeasonOneLeagues() throws CompetitionException, LeagueException{
		SoccerCompetition start = new SoccerCompetition("Competetion3", One, Four);
		start.getLeague(LeagueOne).registerTeam(Team1);
		start.getLeague(LeagueOne).registerTeam(Team2);
		start.getLeague(LeagueOne).registerTeam(Team3);
		start.getLeague(LeagueOne).registerTeam(Team4);
		start.startSeason();
		start.getLeague(LeagueOne).playMatch(Team1.getOfficialName(), Three, Team2.getOfficialName(), Two);
		start.getLeague(LeagueOne).playMatch(Team3.getOfficialName(), Nineteen, Team4.getOfficialName(), One);
		start.endSeason();
		start.displayCompetitionStandings();
		assertEquals(Team4, start.getLeague(LeagueOne).getBottomTeam());
	}
	
}

