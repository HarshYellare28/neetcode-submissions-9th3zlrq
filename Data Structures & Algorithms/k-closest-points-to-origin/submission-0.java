class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //priority queue (min heap) insert based on euclidean distance
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]);
        });

        for(int i=0;i<points.length;i++){
            pq.offer(points[i]);
        }

        int i=0;
        int[][] res = new int[k][2];
        while(i<k){
            res[i] = pq.poll();
            // System.out.println("Printing value a: " + res[i][0] + " b: " +  res[i][1]);
            i++;
        }
        return res;
    }
}


// class Solution {
//     public int[][] kClosest(int[][] points, int K) {
        
//         PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() { 
//             @Override
//             public int compare(int[] left, int[] right) {
//                 return getDistance(right) - getDistance(left);
//             }
//         });
        
//         for (int[] point: points) {
//             heap.add(point);
//             if (heap.size() > K)
//                 heap.poll();
//         }
        
//         int[][] result = new int[K][2];
//         while (K > 0)
//             result[--K] = heap.poll();
        
//         return result;
         
//     }
    
//     private int getDistance(int [] point) {
//         return point[0] * point[0] + point[1] * point[1];
//     }
// }