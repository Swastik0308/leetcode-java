/*
 * CHOCOLA PROBLEM (Minimum Cost to Cut Chocolate) - Greedy
 *
 * Problem:
 * Given a chocolate bar of size n x m, we need to cut it into 1x1 pieces.
 * We are given the cost of each horizontal cut (n-1 cuts) and vertical cut (m-1 cuts).
 *
 * Rule:
 * - When we make a horizontal cut, it cuts across all current vertical pieces.
 *   So cost = horizontalCost * (number of vertical pieces)
 *
 * - When we make a vertical cut, it cuts across all current horizontal pieces.
 *   So cost = verticalCost * (number of horizontal pieces)
 *
 * Greedy Strategy:
 * - Always perform the cut with the HIGHEST cost first.
 * - Because expensive cuts should be applied when the number of pieces is minimum,
 *   otherwise the cost gets multiplied by more segments later.
 *
 * Approach:
 * 1. Sort costVer[] and costHor[] in descending order.
 * 2. Maintain:
 *    - hp = number of horizontal pieces (starts at 1)
 *    - vp = number of vertical pieces (starts at 1)
 * 3. Use two pointers (h and v):
 *    - Pick the bigger cost cut among horizontal and vertical.
 *    - Add its cost multiplied by current pieces.
 *    - Increase hp or vp accordingly.
 * 4. Add remaining cuts after one array is exhausted.
 *
 * Time Complexity (TC):
 * - O((n+m) log(n+m)) due to sorting
 *
 * Space Complexity (SC):
 * - O(1) extra space (ignoring sorting space)
 *
 * Example:
 * n = 4, m = 6
 * costHor = [4,1,2]
 * costVer = [2,1,3,1,4]
 * Output: Minimum total cost to cut into 1x1 pieces.
 */

import java.util.*;

public class Chocola {

    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 }; // m-1
        Integer costHor[] = { 4, 1, 2 }; // n-1

        // sort descending order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) {
                // horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else {
                // vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        // for remaining horizontal and vertical cuts

        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Minimum cost = " + cost);
    }

}
