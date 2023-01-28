class SummaryRanges {
    TreeSet<Integer> numbers;
    public SummaryRanges() {
        numbers = new TreeSet<>();
    }
    
    public void addNum(int value) {
        numbers.add(value);
    }
    
    public int[][] getIntervals() {
        List<List<Integer>> res = new ArrayList<>();
        for(Integer i : numbers){
            if(res.size() != 0 && res.get(res.size()-1).get(1) + 1 == i){
                res.get(res.size()-1).set(1, i);
            }else{
                List<Integer> temp  =new ArrayList<>();
                temp.add(i);
                temp.add(i);
                res.add(new ArrayList<>(temp));
            }
        }
        
        int[][] ans = new int[res.size()][2];
        int ind = 0;
        for(List<Integer> temp: res){
            ans[ind][0] = temp.get(0);
            ans[ind][1] = temp.get(1);
            ind++;
        }
        return ans;
    }
}
/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
