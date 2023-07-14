class Solution {
    public int minimumOperations(int[] nums) {
        // brute force
        // 1. Loop nums and find min val O(N)
        // 2. every element minus min and count 0
        // 3. until 0 count = nums.length -> break O(N^2)
        // O(N^2)
        
        // Heap
        // 1. Loop nums and put it in MinHeap O(NlogN)
        // 2. initialize lastNum that I use to minus all element
        // it does not takes less time to get min val, but I still have to minus value
        
        // Set
        // the minimum number of operation = distinct number size of nums except 0
        // if there is no zero, you don't have to minus 1 to except 0
        // 1 5 0 3 5
        // 1 -> 0 4 0 2 4
        // 2 -> 0 2 0 0 2 here you can see that same numbers are processes by once
        // 2 -> 0 0 0 0 0 
        Set<Integer> set = new HashSet<>();
        boolean isZeroAtFirst = false;
        for(int n: nums){
            set.add(n);
            if(n==0) isZeroAtFirst = true;
        }
        return isZeroAtFirst?set.size()-1:set.size();
    }
}