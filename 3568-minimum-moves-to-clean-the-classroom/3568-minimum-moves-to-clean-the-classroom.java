import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        List<int[]> litters = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startR = i;
                    startC = j;
                } else if (c == 'L') {
                    litters.add(new int[]{i, j});
                }
            }
        }
        
        int numLitter = litters.size();
        Map<Long, Integer> litterMap = new HashMap<>();
        for (int i = 0; i < numLitter; i++) {
            litterMap.put(((long) litters.get(i)[0] << 32) | litters.get(i)[1], i);
        }
        
        int[][][][] dist = new int[m][n][energy + 1][1 << numLitter];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= energy; k++) {
                    Arrays.fill(dist[i][j][k], -1);
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        int targetMask = (1 << numLitter) - 1;
        
        int initialMask = 0;
        long startKey = ((long) startR << 32) | startC;
        if (litterMap.containsKey(startKey)) {
            initialMask |= (1 << litterMap.get(startKey));
        }
        
        dist[startR][startC][energy][initialMask] = 0;
        queue.offer(new int[]{startR, startC, energy, initialMask});
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], e = curr[2], mask = curr[3];
            
            if (mask == targetMask) {
                return dist[r][c][e][mask];
            }
            
            if (e == 0) continue;
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                char cellType = classroom[nr].charAt(nc);
                if (cellType == 'X') continue; 
                
                int nextEnergy = e - 1;
                if (cellType == 'R') {
                    nextEnergy = energy;
                }
                
                int nextMask = mask;
                long nextKey = ((long) nr << 32) | nc;
                if (litterMap.containsKey(nextKey)) {
                    int litterIdx = litterMap.get(nextKey);
                    nextMask |= (1 << litterIdx); 
                }
                
                if (dist[nr][nc][nextEnergy][nextMask] == -1) {
                    dist[nr][nc][nextEnergy][nextMask] = dist[r][c][e][mask] + 1;
                    queue.offer(new int[]{nr, nc, nextEnergy, nextMask});
                }
            }
        }
        
        return -1;
    }
}