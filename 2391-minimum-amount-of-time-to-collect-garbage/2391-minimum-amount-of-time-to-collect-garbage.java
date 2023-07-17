class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        // answer = (sum of each of truck's traveling time) + (count of garbage)
        // M -> 3 , P -> 13, G -> 13
        // 8
        // 37

        Map<String, Integer> typeMinutes = new HashMap<>();
        int minutesSum = 0;
        int count = 0;
        for(int i=0; i<garbage.length; i++){
            count += garbage[i].length();
            if(i>0){
                minutesSum += travel[i-1];
            }
            if(garbage[i].contains("M")) typeMinutes.put("M", minutesSum);
            if(garbage[i].contains("P")) typeMinutes.put("P", minutesSum);
            if(garbage[i].contains("G")) typeMinutes.put("G", minutesSum);
        }
        return typeMinutes.getOrDefault("M",0)+typeMinutes.getOrDefault("P",0)+typeMinutes.getOrDefault("G",0)+count;

    }
}