class Solution {
    
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> answer = new ArrayList<>();
        // 1. initialzie Map with key:domain, value: count
        Map<String,Integer> cntMap = new HashMap<>();
        for(String domainWithCnt : cpdomains){
            int cnt = Integer.parseInt(domainWithCnt.split(" ")[0]);
            String domain = domainWithCnt.split(" ")[1];
            // 2. for every cpdomains, get every subdomain
            while(true){
                int dotIdx = domain.indexOf(".");
                // 3. for every subdomain, update count
                cntMap.put(domain, cntMap.getOrDefault(domain,0)+cnt);
                if(domain.indexOf(".")==-1) break;
                domain = domain.substring(dotIdx+1);
            }
        }
        for(String d : cntMap.keySet()){
            answer.add(cntMap.get(d)+" "+d);
        }
        return answer;
    }
}