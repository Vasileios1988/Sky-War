package skyWar;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(DefensiveModeTest.class);
		suite.addTestSuite(GameRulesTest.class);
		suite.addTestSuite(OffensiveModeTest.class);
		//$JUnit-END$
		return suite;
	}

}
