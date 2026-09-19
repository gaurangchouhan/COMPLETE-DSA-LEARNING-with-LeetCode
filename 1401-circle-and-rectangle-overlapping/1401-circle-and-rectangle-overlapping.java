class Solution {
    public boolean checkOverlap(int radius, int xC, int yC, int x1, int y1, int x2, int y2) {

        // return Math.sqrt(((x1-xC) * (x1-xC)) - ((y1-yC) * (y1-yC))) <= radius
        //         || Math.sqrt(((x2-xC) * (x2-xC)) - ((y2-yC) * (y2-yC))) <= radius
        //         || Math.sqrt((((x2 - x1)-xC) * ((x2 - x1)-xC)) - ((y2 - y1)-yC) * ((y2 - y1)-yC)) <= radius;

        int xi;
        int yi;

        if (x1 > xC) {
            xi = x1;
        } else if (x2 < xC) {
            xi = x2;
        } else {
            xi = xC;
        }

        if (y1 > yC) {
            yi = y1;
        } else if (y2 < yC) {
            yi = y2;
        } else {
            yi = yC;
        }

        long dx = xi - xC;
        long dy = yi - yC;
        return dx * dx + dy * dy <= (long) radius * radius;

    }
}

//T.C : O(1)
//S.C : O(1)