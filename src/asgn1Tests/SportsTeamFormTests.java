package asgn1Tests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import asgn1SoccerCompetition.SportsTeamForm;
import asgn1SportsUtils.WLD;

/**
 * A set of JUnit tests for the asgn1SoccerCompetition.SoccerTeamForm class
 *
 * @author Alan Woodley
 *
 */
public class SportsTeamFormTests {
	
	SportsTeamForm teamtest;
	
@Before	
public void setup(){
	teamtest = new SportsTeamForm();
}

@Test
public void NotNull(){
	assert(teamtest != null);
}
@Test
public void checkchartype(){
	teamtest.addResultToForm(WLD.WIN);
	String string = teamtest.toString();
	assertEquals("W----",string);
}
@Test
public void checkchartype2(){
	teamtest.addResultToForm(WLD.WIN);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.WIN);
	teamtest.addResultToForm(WLD.LOSS);
	String string = teamtest.toString();
	assertEquals("LWDW-",string);
}
@Test
public void checkNumberOfGames(){
	teamtest.addResultToForm(WLD.WIN);
	assertEquals(1,teamtest.getNumGames());	
}
@Test
public void AllTheSameLastDifferent(){
	teamtest.addResultToForm(WLD.WIN);
	teamtest.addResultToForm(WLD.WIN);
	teamtest.addResultToForm(WLD.WIN);
	teamtest.addResultToForm(WLD.WIN);
	teamtest.addResultToForm(WLD.LOSS);
	String string = teamtest.toString();
	assertEquals("LWWWW",string);
}
@Test
public void AllTheSameFirstDifferent(){
	teamtest.addResultToForm(WLD.WIN);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.DRAW);
	String string = teamtest.toString();
	assertEquals("DDDDW",string);
}
@Test
public void MiddleOneDifferent(){
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.LOSS);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.DRAW);
	String string = teamtest.toString();
	assertEquals("DDLDD",string);
}
@Test
public void Reset(){
	teamtest.addResultToForm(WLD.WIN);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.resetForm();
	String string = teamtest.toString();
	assertEquals("-----",string);
}
@Test
public void emptyStart(){
	assertEquals("-----",teamtest.toString());
}

//make sure string assigns with an overflow of chars
@Test
public void overLoad(){
	teamtest.addResultToForm(WLD.WIN);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.DRAW);
	String string = teamtest.toString();
	teamtest.addResultToForm(WLD.DRAW);
	string = teamtest.toString();
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.LOSS);
	teamtest.addResultToForm(WLD.LOSS);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.WIN);
	teamtest.addResultToForm(WLD.LOSS);
	string = teamtest.toString();
	assertEquals("LWDLL",string);
}

@Test
public void oneInputs(){
	teamtest.addResultToForm(WLD.LOSS);
	assertEquals("L----",teamtest.toString());
}
@Test
public void twoInputs(){
	teamtest.addResultToForm(WLD.WIN);
	teamtest.addResultToForm(WLD.DRAW);
	assertEquals("DW---",teamtest.toString());
}

@Test
public void threeInputs(){
	teamtest.addResultToForm(WLD.WIN);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.WIN);
	assertEquals("WDW--",teamtest.toString());
}
@Test
public void fourInputs(){
	teamtest.addResultToForm(WLD.WIN);
	teamtest.addResultToForm(WLD.LOSS);
	teamtest.addResultToForm(WLD.DRAW);
	teamtest.addResultToForm(WLD.WIN);
	String string = teamtest.toString();
	assertEquals("WDLW-",string);
}

}