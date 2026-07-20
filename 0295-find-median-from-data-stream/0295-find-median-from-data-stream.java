class MedianFinder {
    PriorityQueue<Integer> maxi;
    PriorityQueue<Integer> mini;
    public MedianFinder() {
        mini=new PriorityQueue<>();
        maxi=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxi.isEmpty()){
            maxi.offer(num);
            return;
        }

        if(mini.isEmpty()){
            if(maxi.peek()>num){
                mini.offer(maxi.poll());
                maxi.offer(num);
                return;
            }
            mini.offer(num);
            return;
        }
        if(maxi.peek()<num)mini.offer(num);
        else maxi.offer(num);
        if(Math.abs(maxi.size()-mini.size())>1){
            if(maxi.size()>mini.size()){
                mini.offer(maxi.poll());
            }
            else{
                maxi.offer(mini.poll());
            }
        }
    }
    
    public double findMedian() {
        if((mini.size()+maxi.size())%2==0){
            return (double)(maxi.peek()+mini.peek())/2;
        }
        if(mini.size()<maxi.size())return (double)maxi.peek();
        return (double)mini.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna