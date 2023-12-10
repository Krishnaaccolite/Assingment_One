public class Drone {
    public static boolean findPath(int[][] grid, int[] current, int[] target) {
        int currentRow = current[0];
        int currentCol = current[1];
        grid[currentRow][currentCol]=1;
        while (currentRow != target[0] || currentCol != target[1]) {

            if (currentRow < target[0]) {
                currentRow++;
            } else if (currentRow > target[0]) {
                currentRow--;
            }
            if (currentCol < target[1]) {
                currentCol++;
            } else if (currentCol > target[1]) {
                currentCol--;
            }

            grid[currentRow][currentCol]=1;
        }
        return true;
    }

}
