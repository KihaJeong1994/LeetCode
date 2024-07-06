class Solution {
  public int largestRectangleArea(int[] heights) {
    // the point is to know the consecutive count of certin height
    // I can calculate the consecutive num of height one by one
    // here is the step. h1 is the height before and h2 is height after
    // if h1 <= h2, I can add all consecutive num lte h1
    // if h1 > h2, h1's consecutive is over, and all height under h2 ends consecutive
    // if I check every height every time, Time Complexity is O(NM)
    // however, I can store the consecutive num in stack like below => O(N)
    int maxArea = 0;
    Deque<HeightAndConsecutive> stack = new ArrayDeque<>();
    for(int height : heights){
      if(stack.isEmpty()){
        stack.offer(new HeightAndConsecutive(height,1));
      }else{
        if(stack.peekLast().height <= height){
          stack.offer(new HeightAndConsecutive(height,1));
        }else{
          HeightAndConsecutive lastHC = stack.peekLast();
          int cons = 0;
          while (lastHC!=null && lastHC.height>height){
            lastHC = stack.pollLast();
            cons = cons + lastHC.cons;
            maxArea = Math.max(lastHC.height * cons, maxArea);
            lastHC = stack.peekLast();
          }
          stack.offer(new HeightAndConsecutive(height,cons+1));
        }
      }
    }
    
    int cons = 0;
    while (!stack.isEmpty()){
      HeightAndConsecutive lastHC = stack.pollLast();
      cons = cons + lastHC.cons;
      maxArea = Math.max(lastHC.height * cons, maxArea);
    }
    
    return maxArea;

  }
  
  private static class HeightAndConsecutive{
    int height;
    int cons;
    HeightAndConsecutive(int height, int cons){
      this.height = height;
      this.cons = cons;
    }
  }
  
}