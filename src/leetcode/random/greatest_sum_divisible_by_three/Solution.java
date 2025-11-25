package leetcode.random.greatest_sum_divisible_by_three;
import java.util.PriorityQueue;
public class Solution {
    public int maxSumDivThree(int[] nums) {
        PriorityQueue<Integer> heap1 = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> heap2 = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int total = 0;
        for(int n : nums) {
            total += n;
            if(n % 3 == 1) {
                heap1.offer(n);
            } else if(n % 3 == 2) {
                heap2.offer(n);
            }

            if(heap1.size() > 2) {
                heap1.poll();
            }
            if(heap2.size() > 2) {
                heap2.poll();
            }
        }
        if(total % 3 == 0) {
            return total;
        } else if(total % 3 == 1) {
            if(heap1.size() >= 1) {
                if(heap1.size() == 2) {
                    heap1.poll();
                } 
                return total - Math.min(heap1.poll(), heap2.size() == 2 ? heap2.poll() + heap2.poll() : Integer.MAX_VALUE);
            } else if(heap2.size() == 2) {
                return total - heap2.poll() - heap2.poll();
            }
        } else {
            if(heap2.size() >= 1) {
                if(heap2.size() == 2) {
                    heap2.poll();
                } 
                return total - Math.min(heap2.poll(), heap1.size() == 2 ? heap1.poll() + heap1.poll() : Integer.MAX_VALUE);
            } else if(heap1.size() == 2) {
                return total - heap1.poll() - heap1.poll();
            }
        }
        return 0;
    }
}