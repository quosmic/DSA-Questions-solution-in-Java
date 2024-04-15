class MedianFinder {
  
    public ArrayList<Integer> list= new ArrayList<>();  
    
    public MedianFinder() {
        list= new ArrayList<>();
    }
    
    
    public void addNum(int num) {
     int index = Collections.binarySearch(list, num);
        if(index<0) index=-(index + 1);
    list.add(index,num); 
    }
    
    public double findMedian() {
        int size=list.size();
        if(size==0){
            return 0;
        }
        if(size%2==0){
            int num1= list.get(size/2);
            int num2= list.get((size/2)-1);
            return (num1+num2)/2.0;
        }
    return list.get((size)/2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */