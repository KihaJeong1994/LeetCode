class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Set<ThreeElement> set = new HashSet<>();
        // 0. Sort
        Arrays.sort(nums);
        // 1. Loop nums i O(N)
        int n = nums.length;
        for(int i = 0; i< n -2; i++){
            // 2. for index from i+1~nums.length-1, check every twoSum = nums[i]*-1 O(N)
            int start = i+1;
            int end = n-1;
            while (start<end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum <0){
                    start++;
                }else if(sum>0){
                    end--;
                }else{
                    // 3. create ThreeElement
                    // 4. put it in Set<ThreeElement>
                    set.add(new ThreeElement(nums[i],nums[start],nums[end]));
                    start++;
                }
            }
        }

        // 5. Loop element of Set and add it to list
        List<ThreeElement> threeElements = new ArrayList<>(set);
        for(ThreeElement te: threeElements){
            answer.add(Arrays.asList(te.a, te.b, te.c));
        }
        return answer;
    }

    class ThreeElement{
        int a;
        int b;
        int c;

        ThreeElement(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ThreeElement that = (ThreeElement) o;
            return a == that.a && b == that.b && c == that.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }

    
}