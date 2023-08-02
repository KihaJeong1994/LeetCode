class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;

        while (left<right){
            int area = 0;
            // move the smaller height pointer because move the higher pointer only result in same area or smaller result
            // since smaller height become the height of area
            if(height[left]<height[right]){
                area = height[left]*(right-left);
                left++;
            } else if (height[left]>height[right]) {
                area = height[right]*(right-left);
                right--;
            }else {
                area = height[right]*(right-left);
                left++;
                right--;
            }
            if(area>maxArea) maxArea = area;
        }
        return maxArea;

    }
}