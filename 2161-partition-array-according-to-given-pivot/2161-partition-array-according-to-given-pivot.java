class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lessThanPivot = new ArrayList<>();
        List<Integer> equalToPivot = new ArrayList<>();
        List<Integer> greaterThanPivot = new ArrayList<>();
        
        for(int num : nums){
            if(num<pivot){
                lessThanPivot.add(num);
            }else if(num==pivot){
                equalToPivot.add(num);
            }else{
                greaterThanPivot.add(num);
            }
        }
        
        int[] reOrderedArray = new int[nums.length];
        
        for(int i=0; i<lessThanPivot.size();i++){
            reOrderedArray[i] = lessThanPivot.get(i);
        }
        for(int i=0; i<equalToPivot.size();i++){
            reOrderedArray[i+lessThanPivot.size()] = equalToPivot.get(i);
        }
        for(int i=0; i<greaterThanPivot.size();i++){
            reOrderedArray[i+lessThanPivot.size()+equalToPivot.size()] = greaterThanPivot.get(i);
        }
        
        return reOrderedArray;
    }
}