import java.util.*;

public class Main {

    static class Cell {
        int row, col, health;

        Cell(int row, int col, int health) {
            this.row = row;
            this.col = col;
            this.health = health;
        }
    }

    public int dijkstras(int[][] dungeon) {
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.health));
        int m = dungeon.length, n = dungeon[0].length;
        int[][] minHealth = new int[m][n];
        return 0;
    }

    public static void main(String[] args) {

    }
}