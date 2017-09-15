package asgn1Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn1Exceptions.TeamException;
import asgn1SoccerCompetition.SoccerTeam;



/**
 * A set of JUnit tests for the asgn1SoccerCompetition.SoccerLeage class
 *
 * @author Alan Woodley
 *
 */
public class SoccerTeamTests {
	
	SoccerTeam teamtest;
	SoccerTeam teamtest2;
	SoccerTeam teamtest3;
	
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
	private final int Fithty = 50;
	private final int sixtythree = 63;
	
@Before
public void setUp() throws TeamException{

		teamtest = new SoccerTeam("bob","jane");
		teamtest2 = new SoccerTeam("Gordan","Ramsay");
}
@Test(expected = TeamException.class)
public void testTeamException() throws TeamException{
	teamtest3 = new SoccerTeam("","");
}
@Test(expected = TeamException.class)
public void officalException() throws TeamException{
	teamtest3 = new SoccerTeam("Test","");
}  
@Test(expected = TeamException.class)
public void nickException() throws TeamException{
	teamtest3 = new SoccerTeam("","Test");
}  
@Test
public void checkGetOfficialName(){
	assertEquals("bob",teamtest.getOfficialName());
}
@Test
public void checkGetNickName(){
	assertEquals("jane",teamtest.getNickName());
}
@Test
public void getGoalsScoredSeason(){
	assertEquals(Zero,teamtest.getGoalsScoredSeason());	
}
@Test(expected = TeamException.class)
public void playmatchTeamException() throws TeamException{
	teamtest.playMatch(Nine, TwentyOne);
}
@Test
public void CheckGetLosts() throws TeamException{
	teamtest.playMatch(Four, Twenty);
	teamtest.playMatch(Five, Five);
	teamtest.playMatch(Zero, One);
	teamtest.playMatch(Four, Nineteen);
	teamtest.playMatch(Eighteen, Twelve);
	assertEquals(Three,teamtest.getMatchesLost());
}
@Test
public void CheckGetWins() throws TeamException{
	teamtest.playMatch(Four, Nineteen);
	teamtest.playMatch(One, One);
	teamtest.playMatch(One, Two);
	teamtest.playMatch(Zero, Zero);
	teamtest.playMatch(Twenty, One);
	teamtest.playMatch(Four,Twenty);
	teamtest.playMatch(Twenty, Twenty);
	assertEquals(One,teamtest.getMatchesWon());
}
@Test
public void CheckGetDraw() throws TeamException{
	teamtest.playMatch(Four, Nineteen);
	teamtest.playMatch(One, One);
	teamtest.playMatch(One, Two);
	teamtest.playMatch(Zero, Zero);
	teamtest.playMatch(Twenty, One);
	teamtest.playMatch(Four,Twenty);
	teamtest.playMatch(Twenty, Twenty);
	assertEquals(Three,teamtest.getMatchesDrawn());
}
@Test
public void CheckGetCompetitionPoints() throws TeamException{
	teamtest.playMatch(Four, Nineteen);
	teamtest.playMatch(One, One);
	teamtest.playMatch(One, Two);
	teamtest.playMatch(Zero, Zero);
	teamtest.playMatch(Twenty, One);
	teamtest.playMatch(Four,Twenty);
	teamtest.playMatch(Twenty, Twenty);
	assertEquals(Six,teamtest.getCompetitionPoints());
}
@Test
public void CheckGetGoalDifference() throws TeamException{
	teamtest.playMatch(Four, Nineteen);
	teamtest.playMatch(One, One);
	teamtest.playMatch(One, Two);
	teamtest.playMatch(Zero, Zero);
	teamtest.playMatch(Twenty, One);
	teamtest.playMatch(Four,Twenty);
	teamtest.playMatch(Twenty, Twenty);
	assertEquals(-Thridteen,teamtest.getGoalDifference());
}
@Test
public void CheckGetGoalsConcededSeason() throws TeamException{
	teamtest.playMatch(Four, Nineteen);
	teamtest.playMatch(One, One);
	teamtest.playMatch(One, Two);
	teamtest.playMatch(Zero, Zero);
	teamtest.playMatch(Twenty, One);
	teamtest.playMatch(Four,Twenty);
	teamtest.playMatch(Twenty, Twenty);
	assertEquals(sixtythree,teamtest.getGoalsConcededSeason());
}
@Test
public void CheckGetGoalsScoredSeason() throws TeamException{
	teamtest.playMatch(Four, Nineteen);
	teamtest.playMatch(One, One);
	teamtest.playMatch(One, Two);
	teamtest.playMatch(Zero, Zero);
	teamtest.playMatch(Twenty, One);
	teamtest.playMatch(Four,Twenty);
	teamtest.playMatch(Twenty, Twenty);
	assertEquals(Fithty,teamtest.getGoalsScoredSeason());
}
@Test
public void CheckGetFormString() throws TeamException{
	teamtest.playMatch(Four, Nineteen);
	teamtest.playMatch(One, One);
	teamtest.playMatch(One, Two);
	teamtest.playMatch(Zero, Zero);
	teamtest.playMatch(Twenty, One);
	teamtest.playMatch(Four,Twenty);
	teamtest.playMatch(Twenty, Twenty);
	assertEquals("DLWDL",teamtest.getFormString());
}
@Test
public void CheckCompareTo() throws TeamException{
	teamtest.playMatch(Four, Nineteen);
	teamtest.playMatch(One, One);
	teamtest.playMatch(One, Two);
	teamtest.playMatch(Zero, Zero);
	teamtest.playMatch(Twenty, One);
	teamtest.playMatch(Four,Twenty);
	teamtest.playMatch(Twenty, Twenty);
	assertEquals(-Six,teamtest.compareTo(teamtest2));
}
@Test
public void CheckReset() throws TeamException{
	teamtest.playMatch(Four, Nineteen);
	teamtest.playMatch(One, One);
	teamtest.playMatch(One, Two);
	teamtest.playMatch(Zero, Zero);
	teamtest.playMatch(Twenty, One);
	teamtest.playMatch(Four,Twenty);
	teamtest.playMatch(Twenty, Twenty);
	teamtest.resetStats();
	assertEquals(Zero,teamtest.getGoalsScoredSeason());
	assertEquals(Zero,teamtest.getGoalsConcededSeason());
	assertEquals(Zero,teamtest.getGoalDifference());
	assertEquals(Zero,teamtest.getCompetitionPoints());
	assertEquals(Zero,teamtest.getMatchesDrawn());
	assertEquals(Zero,teamtest.getMatchesWon());
	assertEquals(Zero,teamtest.getMatchesLost());
}
}


