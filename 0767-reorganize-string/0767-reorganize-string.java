class Solution {
    public String reorganizeString(String s) {
        // HashMap<Character,Integer> hm=new HashMap<>();
        // for(int i=0;i<s.length();i++){
        //     char ch=s.charAt(i);
        //     hm.put(ch,hm.getOrDefault(ch,0)+1);
        // }
        // PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        // StringBuilder sb=new StringBuilder();
        // pq.addAll(hm.entrySet());
        // while(pq.size()>1){
        //     char ch1=pq.poll().getKey();
        //     char ch2=pq.poll().getKey();
        //     sb.append(ch1);
        //     sb.append(ch2);
        //     if(hm.get(ch1)>1){
        //         hm.put(ch1,hm.get(ch1)-1);
        //         pq.offer(hm.put(ch1,hm.get(ch1)-1));
        //         // pq.offer(hm.)    
        //     }
        //     else hm.remove(ch1);
        //     if(hm.get(ch2)>1){
        //         pq.offer(hm.put(ch2,hm.get(ch2)-1));
        //     }
        //     else hm.remove(ch2);
        // }
        // HashMap<Character,Integer> hm1=pq.poll();
        // if(val==1)sb.append(hm1.getKey(1));
        // else return "";
        // return sb.toString();
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
        pq.addAll(hm.keySet());
        StringBuilder sb=new StringBuilder();
        while(pq.size()>1){
            char ch1=pq.poll();
            char ch2=pq.poll();
            sb.append(ch1);
            sb.append(ch2);
            if(hm.get(ch1)>1){
                hm.put(ch1,hm.get(ch1)-1);
                pq.offer(ch1);
    
            }
            else hm.remove(ch1);
            if(hm.get(ch2)>1){
                hm.put(ch2,hm.get(ch2)-1);
                pq.offer(ch2);
            }
            else hm.remove(ch2);
        }
        if (!pq.isEmpty()) {
            char ch = pq.poll();
            if (hm.get(ch) == 1)
                sb.append(ch);
            else
                return "";
        }
        return sb.toString();       
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna