package rectanglearea;

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return computeArea(ax1, ay1, ax2, ay2) + computeArea(bx1, by1, bx2, by2)
            - findOverlappingRectangleArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2) {
        return (ay2 - ay1) * (ax2 - ax1);
    }

    public int findOverlappingRectangleArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if (bx2 <= ax1 || bx1 >= ax2)
            return 0;
        if (by2 <= ay1 || by1 >= ay2)
            return 0;
        int cx1 = Math.max(ax1, bx1);
        int cx2 = Math.min(ax2, bx2);
        int cy1 = Math.max(ay1, by1);
        int cy2 = Math.min(ay2, by2);
        return computeArea(cx1, cy1, cx2, cy2);
    }
}
