package lexicographicallysmalleststringafteroperationswithconstraint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getSmallestString() {
        Solution s = new Solution();
        String res = s.getSmallestString("zbbz", 3);
        assertEquals("aaaz", res);
    }

    @Test
    void getSmallestString_2() {
        Solution s = new Solution();
        String res = s.getSmallestString("xaxcd", 4);
        assertEquals("aawcd", res);
    }

    @Test
    void getSmallestString_3() {
        Solution s = new Solution();
        String res = s.getSmallestString("lol", 0);
        assertEquals("lol", res);
    }

    @Test
    void getSmallestString_4() {
        Solution s = new Solution();
        String res = s.getSmallestString("a", 26);
        assertEquals("a", res);
    }
}
