class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        if(n==1 || n==2){
            return 0;
        }
        // I think it is easy to get trap if there is higher or same(gte) height at the right side
        // it is the sum of the height diff between left side
        // it became difficult when there is no gte height at the right side
        // but it can be solved by doing the same from the right I think
        
        int answer = 0;
        // 1. find the highest index so it can be the standard point to calculate from left and right
        int maxHeight = 0;
        int maxHeightIndex = 0;
        for (int i = 0; i< n; i++){
            int h = height[i];
            if(h>maxHeight){
                maxHeight = h;
                maxHeightIndex = i;
            }
        }
        
        // 2. from left, calculate trap until highest index
        int l = 0;
        int r = l+1;
        while (r<=maxHeightIndex){
            int hl = height[l];
            int hr = height[r];
            if(hl == 0){
                l++;
                r = l+1;
                continue;
            }
            if(hr<hl){
                answer += hl-hr;
                r++;
                continue;
            }else {
                l = r;
                r = l+1;
            }
        }
        
        // 3. from right, calculate trap until highest index
        r = n-1;
        l = r-1;
        while (l>=maxHeightIndex){
            int hl = height[l];
            int hr = height[r];
            if(hr == 0){
                r--;
                l = r-1;
                continue;
            }
            if(hl<hr){
                answer += hr-hl;
                l--;
                continue;
            }else {
                r=l;
                l = r-1;
            }
        }
        
        return answer;
    }
}