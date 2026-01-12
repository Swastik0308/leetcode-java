/*
 * ACTIVITY SELECTION PROBLEM (Greedy)
 *
 * Problem:
 * Given start and end times of activities,
 * select the maximum number of non-overlapping activities
 * that can be performed by a single person.
 *
 * Approach (Greedy):
 * - Always select the activity that finishes the earliest.
 * - This leaves maximum room for remaining activities.
 *
 * Steps:
 * 1. Combine start[] and end[] into a 2D array:
 *    activities[i] = {index, startTime, endTime}
 * 2. Sort activities based on end time (ascending).
 * 3. Select the first activity (earliest ending).
 * 4. For each next activity:
 *    - If its start time >= last selected activity’s end time,
 *      select it and update lastEnd.
 *
 * Why this Greedy works:
 * - Choosing the activity that ends earliest minimizes time blockage.
 * - This choice is locally optimal and leads to a globally optimal solution.
 *
 * Time Complexity (TC):
 * - O(n log n) due to sorting.
 *
 * Space Complexity (SC):
 * - O(n) for storing activities and result.
 *
 * Output:
 * - Maximum number of non-overlapping activities.
 * - Indices of selected activities.
 */

import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) { // TC O(n)
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        // If the end is not sorted we have to sort using 2d array
        int activities[][] = new int[start.length][3]; // there will be 3 columns naming index, start, end
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // Lambda function -> shortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2])); // We are saying that the sorting should be
                                                                        // basis on column 2

        // end time is sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) { // non overlapping activity
                // activity selected
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Max activities = " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}
