// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).


// n = height.length -> how many vertical lines we will have
// (i, height[i]) -> Ceiling for the height
// (i, 0) -> floor for the height

// Find two lines that together with the x-axis form a container, such that the container contains the most water

// Math.min((i, height[i]), (j, height[j]))

// Smaller height * width between = area


// Return the maximum amount of water a container can store.

// -Find the max overall area

// Math.max(currentArea, maxArea)

// Time Complexity = O(n)
// Space Complexity = O(1) , no datastructures being used, in place calculations
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            // left height = 1 , 0
            // right height = 7 , 8
            int curArea = Math.min(height[left], height[right]) * (right - left); 

            maxArea = Math.max(curArea, maxArea);

            if(height[right] > height[left]) {
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }
}