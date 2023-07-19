class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> answer = new ArrayList<>(searchWord.length());
        for(int i=0 ; i<searchWord.length();i++){
            answer.add(new ArrayList<>());
        }
        Arrays.sort(products);
        for(String product : products){
            int length = product.length();
            for(int i=0; i<searchWord.length();i++){
                if(i< length){
                    if(product.charAt(i)==searchWord.charAt(i)){
                        if(answer.get(i).size()<3)answer.get(i).add(product);
                    }else {
                        break;
                    }
                }else {
                    break;
                }
            }
        }
        return answer;
    }
}