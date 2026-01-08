class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
         if (q == null || q.isEmpty() || k <= 0 || k > q.size()) {
            return q;
        }
        int size = q.size();
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<k; i++){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        
        for(int i=0; i<size-k; i++){
            q.add(q.remove());
        }
        return q;
    }
}
