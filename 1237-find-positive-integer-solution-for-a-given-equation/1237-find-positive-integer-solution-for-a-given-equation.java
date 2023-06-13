/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> answerList = new ArrayList<>();        
        int end = 1000;
        for(int x=1;x<=1000;x++){
            int start = 1;
            while(start<=end){
                int y = (start+end)/2;
                int result = customfunction.f(x,y);
                if(result==z){
                    answerList.add(Arrays.asList(x,y));
                    end = y;
                    break;
                }else if(result<z){
                    start = y +1;
                }else{
                    end = y -1;
                }
            }
        }
        return answerList;
    }
}