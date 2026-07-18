class Solution {
    public String longestDiverseString(int a, int b, int c) {
        HashMap<Character,Integer> hm=new HashMap<>();
        if(a!=0)hm.put('a',a);
        if(b!=0)hm.put('b',b);
        if(c!=0)hm.put('c',c);
        StringBuilder sb=new StringBuilder(); 
        PriorityQueue<Character> pq=new PriorityQueue<>((a1,b1)->hm.get(b1)-hm.get(a1));
        pq.addAll(hm.keySet());
        while(!pq.isEmpty()){
            char ch1=pq.poll();
            if(sb.length()>1 && ch1==sb.charAt(sb.length()-1) && ch1==sb.charAt(sb.length()-2)){
                if(pq.isEmpty())continue;
                char c1=pq.poll();
                sb.append(c1);
                if(hm.get(c1)==1)hm.remove(c1);
                else{
                    hm.put(c1,hm.get(c1)-1);
                    pq.offer(c1);
                }
                pq.offer(ch1);
            }
            else{
                sb.append(ch1);
                if(hm.get(ch1)==1)hm.remove(ch1);
                else{
                    pq.offer(ch1);
                    hm.put(ch1,hm.get(ch1)-1);
                }
            }
        }
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna