package strStr;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testStrStr() {
		Solution solution = new Solution();
		assertEquals(0, solution.strStr("a", "a"));
	}

}
