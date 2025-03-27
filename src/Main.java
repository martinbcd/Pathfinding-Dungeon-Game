import java.util.*;

class DungeonGame {
    static class Cell {
        int row, col, health;

        Cell(int row, int col, int health) {
            this.row = row;
            this.col = col;
            this.health = health;
        }
    }

    public int dijkstras(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        // priority queue to store cells in order of the lowest health cost first
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.health));
        int[][] minHealth = new int[m][n];

        for (int[] row : minHealth) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // the game starts from the top-left cell with the required initial health
        pq.offer(new Cell(0, 0, Math.max(1, 1 - dungeon[0][0])));
        minHealth[0][0] = Math.max(1, 1 - dungeon[0][0]);

        // movement right and down
        int[] dr = {0, 1};
        int[] dc = {1, 0};

        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int r = current.row, c = current.col, health = current.health;
            //return the required health when reaching the destination
            if (r == m - 1 && c == n - 1) {
                return health;
            }

            for (int i = 0; i < 2; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < m && nc < n) {
                    int newHealth = Math.max(1, health - dungeon[nr][nc]);
                    //updates if a better path is found
                    if (newHealth < minHealth[nr][nc]) {
                        minHealth[nr][nc] = newHealth;
                        pq.offer(new Cell(nr, nc, newHealth));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        DungeonGame sol = new DungeonGame();
        int[][] dungeon1 = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(sol.dijkstras(dungeon1)); // Output: 7

        int[][] dungeon2 = {{0}};
        System.out.println(sol.dijkstras(dungeon2)); // Output: 1
    }
}