class TimeMap {
    Map<String, List<TimeValue>> map; // key : key, value : list of object with timestamp and value

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<TimeValue> timeValueList = map.getOrDefault(key, new ArrayList<>());
        timeValueList.add(new TimeValue(timestamp,value));
        map.putIfAbsent(key,timeValueList);
    }
    
    public String get(String key, int timestamp) {
        // I cannot use the simple map since the this is about the range problem
        // it says the timestamp is strictly increasing, so if I want to search the certain value in timestamp
        // I can use binary search
        if(map.containsKey(key)){
            List<TimeValue> timeValueList = map.get(key);
            int l = 0;
            int r = timeValueList.size()-1;
            int recentTimeStamp = Integer.MIN_VALUE;
            String recentValue = "";
            while(l<=r){
                int mid = (l+r)/2;
                TimeValue tv = timeValueList.get(mid);
                int midTimeStamp = tv.timestamp;
                String midVal = tv.value;
                if(midTimeStamp < timestamp){
                    // satisfy the condition, but don't know whether this is the optimal solution
                    if(midTimeStamp>recentTimeStamp){
                        recentTimeStamp = midTimeStamp;
                        recentValue = midVal;
                    }
                    l = mid + 1;
                }else if(midTimeStamp > timestamp){
                    r = mid - 1;
                }else{
                    return midVal;
                }
            }
            return recentValue;
        }
        return "";
    }

    private static class TimeValue{
        int timestamp;
        String value;
        TimeValue(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */