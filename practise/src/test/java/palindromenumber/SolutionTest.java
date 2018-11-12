package palindromenumber;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import javax.swing.tree.TreeNode;


public class SolutionTest {
    Solution s;

    @Before
    public void setup() {
        s = new Solution();
    }

    @Test
    public void shouldReturnFalseForNeg121() {
        boolean actual = s.isPalindrome(-121);
        assertFalse(actual);
    }

    @Test
    public void shouldReturnTrueFor121() {
        boolean actual = s.isPalindrome(121);
        assertTrue(actual);
    }

    // @Test
    // public void shouldReturnFalseFor10() {
    //     boolean actual = s.isPalindrome(10);
    //     TreeNode n = new
    //     assertFalse(actual);
    // }
}
