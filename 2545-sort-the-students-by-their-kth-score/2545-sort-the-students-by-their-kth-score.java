class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score,(s1,s2)->-1*(s1[k]-s2[k]));
        return score;
    }
}