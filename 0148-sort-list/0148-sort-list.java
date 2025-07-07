/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null)return null;
        int count=count(head);
        int arr[]=new int[count];
        ListNode temp=head;
        int j=0;
        while(temp!=null){
            arr[j]=temp.val;
            temp=temp.next;
            j++;
        }
        ListNode l=new ListNode(0);
        ListNode newL=l;
        int sort[]=merge(arr);
        for(int i=0;i<sort.length;i++){
            l.next=new ListNode(sort[i]);
            l=l.next;
        }
        return newL.next;
    }
    public static int[] merge(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid=arr.length/2;
        int[] first=Arrays.copyOfRange(arr,0,mid);
        int[] second=Arrays.copyOfRange(arr,mid,arr.length);
        return mergeSort(merge(first),merge(second));
    }

    public static int[] mergeSort(int[] left,int[] right){
        int mix[]=new int[left.length+right.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<left.length && j<right.length){
            if(left[i]>right[j]){
                mix[k]=right[j];
                j++;
            }
            else{
                mix[k]=left[i];
                i++;
            }
            k++;
        }
        while(left.length>i){
            mix[k]=left[i];
            i++;
            k++;
        }
        
        while(j<right.length){
            mix[k]=right[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(mix));
        return mix;
    }
    public static int count(ListNode l){
        int c=0;
        while(l!=null){
            l=l.next;
            c++;
        }
        return c;
    }
}