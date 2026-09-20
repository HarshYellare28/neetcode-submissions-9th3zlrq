class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(int i=0; i<tasks.length; i++){
            count[tasks[i] - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++){
            if(count[i] != 0){
                pq.offer(count[i]);
            }
        }
        int time=0;
        Queue<int[]> cooldown = new ArrayDeque<>();//maintains: (count, cooldown-time)
        while(!pq.isEmpty() || !cooldown.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int currTaskCount = pq.poll();
                //XY
                if(currTaskCount - 1 > 0){
                    cooldown.add(new int[]{currTaskCount-1, time+n});
                }
            }

            if(!cooldown.isEmpty()){
                int[] currCooldown = cooldown.peek();
                if(currCooldown[1] == time){
                    cooldown.poll();
                    pq.offer(currCooldown[0]);
                } 
            }
        }
        return time;
    }
}
