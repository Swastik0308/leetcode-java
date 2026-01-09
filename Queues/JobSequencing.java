/*
 * JOB SEQUENCING WITH DEADLINES (Greedy + Max Heap)
 *
 * Problem:
 * Given a set of jobs where each job has:
 * - jobId
 * - deadline (time before which it must be completed)
 * - profit
 * Each job takes 1 unit of time.
 *
 * Objective:
 * Schedule jobs such that:
 * - Each job is completed before its deadline.
 * - Only one job can be done at a time.
 * - Total profit is maximized.
 *
 * Approach (Greedy with Priority Queue):
 *
 * Key Idea:
 * - Sort jobs by increasing deadline.
 * - Traverse jobs from the last deadline to the first.
 * - At each step, consider all jobs that can be done in the current time slot.
 * - Use a MAX HEAP (based on profit) to always pick the most profitable job.
 *
 * Detailed Steps:
 * 1. Sort all jobs by their deadlines in ascending order.
 * 2. Create a max-heap that prioritizes jobs with higher profit.
 * 3. Traverse jobs from right to left:
 *    - Calculate available slots between current and previous deadlines.
 *    - Add current job to the max-heap.
 *    - While slots are available:
 *        - Pick the job with maximum profit from the heap.
 *        - Schedule it and reduce available slots.
 * 4. After scheduling, sort the result jobs by deadline for correct output order.
 *
 * Why this works:
 * - Deadlines define time slots.
 * - Max heap ensures the most profitable job is always chosen first.
 * - Greedy choice is optimal because each slot should give maximum profit.
 *
 * Time Complexity (TC):
 * - Sorting jobs: O(n log n)
 * - Heap operations: O(n log n)
 * - Overall: O(n log n)
 *
 * Space Complexity (SC):
 * - O(n) for heap and result list.
 *
 * Example:
 * Jobs: (a,2,100), (b,1,19), (c,2,27), (d,1,25), (e,3,15)
 * Output: a c e
 */

import java.util.*;

public class JobSequencing {
    static class Job {
        char jobId;
        int deadline;
        int profit;

        Job(char jobId, int deadline, int profit) {
            this.deadline = deadline;
            this.jobId = jobId;
            this.profit = profit;
        }
    }

    static void printJobScheduling(ArrayList<Job> arr) {
        int n = arr.size();
        Collections.sort(arr, (a, b) -> {
            return a.deadline - b.deadline;
        });

        ArrayList<Job> res = new ArrayList<>();
        PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> {
            return b.profit - a.profit;
        });
        for (int i = n - 1; i > -1; i--) {
            int slotAvailable;
            if (i == 0) {
                slotAvailable = arr.get(i).deadline;
            } else {
                slotAvailable = arr.get(i).deadline - arr.get(i - 1).deadline;
            }

            maxHeap.add(arr.get(i));
            while (slotAvailable > 0 && maxHeap.size() > 0) {
                Job j = maxHeap.remove();
                slotAvailable--;
                res.add(j);
            }
        }

        Collections.sort(res, (a, b) -> {
            return a.deadline - b.deadline;
        });

        for (Job j : res) {
            System.out.print(j.jobId + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Job> arr = new ArrayList<Job>();

        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));

        printJobScheduling(arr);
    }
}
