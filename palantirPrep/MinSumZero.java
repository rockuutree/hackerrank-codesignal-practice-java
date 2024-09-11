// You have to replace all the 0's in both arrays with strictly positive integers such that the sum of elements of both arrays becomes equal.

// Goal: Return the minimum equal sum you can obtain or -1 if impossible.

// -1 <- Not possible. How is that determined

// - Since we cant decrease the site of the size of the array, this would be impossible if one array doesn't contain any zeros, and the other array is already larger, OR has zeros that will make the array larger.


// 3 + 2 + 1 + ? + ? = 6 + 5 + ?

// 6 + 2? = 11 + ?

// 6 + 2 + 4 = 12
// 11 + 1 = 12


// Time complexity O(n + m)
// Space Complexity O(1)
class Solution {
    public long minSum(int[] nums1, int[] nums2) {

        long sum1 = 0;
        long sum2 = 0;

        int count1 = 0;
        int count2 = 0;

        // Get the sum for nums1 and 0 count for nums1
        for(int num: nums1) {
            // If not != 0, then we add each nums1[i] to the sum
            if(num != 0) {
                sum1 += num;
            } else {
                // Having a 0 will always increase by a minimum of 1
                sum1++;
                // Incrmeent zero counter
                count1++;
            }
        }

        for(int num: nums2) {
            if(num != 0) {
                sum2 += num;
            } else {
                sum2++;
                count2++;
            }
        }

        // If our sums are the same, then we know that the minimum sum will be either sum
        if(sum1 == sum2) {
            return sum1;
            // If sum1 is bigger
        } else if(sum1 > sum2) {
            // Check to see if sum2 can increase, if not then it's impossible
            if(count2 == 0) {
                return -1;
            }
            // sum2 has a minimum of one zero, meaning the minimum would be sum1
            return sum1;
        } else {
            // else if sum2 is greater, do the same thing with sum1
            if(count1 == 0) {
                return -1;
            }
            return sum2;
        }

        
    }
}