class MyHashMap {
    int[] arr;
    boolean[] present;
    public MyHashMap() {
        arr=new int[1999999];
        present=new boolean[1999999];
    }
    
    public void put(int key, int value) {
        present[key]=true;
        arr[key]=value;
    }
    
    public int get(int key) {
        return present[key] ? arr[key]:-1;
    }
    
    public void remove(int key) {
        present[key]=false;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */