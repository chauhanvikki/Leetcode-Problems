class MyHashMap {
    int[][] arr;
    public MyHashMap() {
        arr=new int[1999999][2];
        for(int i=0;i<1999999;i++){
            Arrays.fill(arr[i],-1);
        }
    }
    
    public void put(int key, int value) {
        arr[key][0]=key;
        arr[key][1]=value;
    }
    
    public int get(int key) {
        // if(arr[key][0]==0)return -1;
        return arr[key][1];
    }
    
    public void remove(int key) {
        arr[key][0]=-1;
        arr[key][1]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */