/*
 * JOB SEQUENCING WITH DEADLINES (Greedy - Slot Filling)
 *
 * Problem:
 * Given N jobs where each job has:
 * - id
 * - deadline (last time slot by which job must be completed)
 * - profit
 * Each job takes exactly 1 unit of time.
 *
 * Goal:
 * Schedule jobs to maximize total profit such that:
 * - Only one job can be done at a time.
 * - A job must be completed on or before its deadline.
 *
 * Greedy Strategy:
 * 1. Sort all jobs in DESCENDING order of profit.
 * 2. For each job (highest profit first), try to place it in the latest
 *    available free time slot <= its deadline.
 *
 * Why this works:
 * - Picking the most profitable job first ensures maximum gain.
 * - Assigning it to the latest possible slot leaves earlier slots free
 *   for jobs with tighter deadlines.
 *
 * Steps:
 * 1. Convert job info into Job objects.
 * 2. Sort jobs by profit decreasing.
 * 3. Find the maximum deadline to know how many time slots exist.
 * 4. Use a boolean slot[] array to mark occupied slots.
 * 5. For each job:
 *    - scan from deadline down to 1
 *    - if slot is free, assign job there and add its profit.
 *
 * Time Complexity (TC):
 * - Sorting jobs: O(n log n)
 * - Slot searching: O(n * maxDeadline) in worst case
 *
 * Space Complexity (SC):
 * - O(maxDeadline) for slot array + O(n) for storing jobs/results
 *
 * Output:
 * - Jobs done (count)
 * - Total profit
 * - Job sequence (selected job ids)
 */

import java.util.*;

public class JobSequencing {

    static class Job {
        int id, deadline, profit;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // sort by profit descending
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        // max deadline
        int maxDeadline = 0;
        for (Job j : jobs)
            maxDeadline = Math.max(maxDeadline, j.deadline);

        boolean[] slot = new boolean[maxDeadline + 1];
        ArrayList<Integer> seq = new ArrayList<>();
        int totalProfit = 0;

        for (Job job : jobs) {
            for (int t = job.deadline; t > 0; t--) {
                if (!slot[t]) {
                    slot[t] = true;
                    seq.add(job.id);
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Jobs done = " + seq.size());
        System.out.println("Total Profit = " + totalProfit);
        System.out.println("Sequence = " + seq);
    }
}
