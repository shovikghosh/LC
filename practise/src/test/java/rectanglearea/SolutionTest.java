package rectanglearea;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testComputeArea() {
        Solution s = new Solution();
        int x1 = 1, x2 = 2, y1 = 0, y2 = 1;
        int area = s.computeArea(x1, y1, x2, y2);
        assertEquals(1, area);
    }

    @Test
    void testComputeArea_2() {
        Solution s = new Solution();
        int x1 = 1, x2 = 3, y1 = 0, y2 = 1;
        int area = s.computeArea(x1, y1, x2, y2);
        assertEquals(2, area);
    }

    @Test
    void testComputeArea_3() {
        Solution s = new Solution();
        int x1 = 1, x2 = 3, y1 = 0, y2 = 2;
        int area = s.computeArea(x1, y1, x2, y2);
        assertEquals(4, area);
    }

    @Test
    void testComputeArea_4() {
        Solution s = new Solution();
        int x1 = 1, x2 = 10, y1 = 0, y2 = 20;
        int xx1 = 15, xx2 = 20, yy1 = 15, yy2 = 18;
        int area = s.computeArea(x1, y1, x2, y2, xx1, yy1, xx2, yy2);
        assertEquals(180 + 15, area);
    }

    @Test
    void testFindOverlappingRectangleArea() {
        Solution s = new Solution();
        int x1 = 1, x2 = 10, y1 = 0, y2 = 20;
        int xx1 = 3, xx2 = 5, yy1 = 15, yy2 = 18;
        int overlappingArea = s.findOverlappingRectangleArea(x1, y1, x2, y2, xx1, yy1, xx2, yy2);
        assertEquals(6, overlappingArea);
    }

    @Test
    void testComputeArea_5() {
        Solution s = new Solution();
        int x1 = 1, x2 = 10, y1 = 0, y2 = 20;
        int xx1 = 3, xx2 = 5, yy1 = 15, yy2 = 18;
        int area = s.computeArea(x1, y1, x2, y2, xx1, yy1, xx2, yy2);
        assertEquals(180, area);
    }

    @Test
    void testNoOverlap() {
        int area = new Solution().computeArea(1, 1, 5, 4, 6, 6, 8, 8);
        assertEquals(16, area);
    }

    @Test
    void testCompleteOverlap() {
        int area = new Solution().computeArea(1, 1, 5, 4, 2, 2, 4, 3);
        assertEquals(12, area);
    }

    @Test
    void testPartialOverlapLeftSide() {
        int area = new Solution().computeArea(1, 1, 5, 4, 0, 2, 3, 3);
        assertEquals(13, area);
    }
}
