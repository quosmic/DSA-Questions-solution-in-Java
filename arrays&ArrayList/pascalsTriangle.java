class Solution {
    public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> list= new ArrayList<>();
    for(int i=1;i<=numRows;i++){
       List<Integer> list1= new ArrayList<>();
        int num=1;
        for(int j=1;j<=i;j++){
            list1.add(num);
            num= (num* (i-j))/(j);
        }
        
        
        list.add(list1);
    }    
    return list;
    }
}