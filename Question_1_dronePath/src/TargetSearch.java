import java.util.Scanner;

public class TargetSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter grid size rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter grid size columns: ");
        int columns = scanner.nextInt();

        int[][] grid = new int[rows][columns];

        System.out.print("Enter target row position: ");
        int targetRow = scanner.nextInt();
        System.out.print("Enter target column position: ");
        int targetColumn = scanner.nextInt();
        int[] target = {targetRow, targetColumn};

        System.out.println("Enter the number of drones: ");
        int n= scanner.nextInt();
        System.out.println("Enter positions for drones: ");
        int[][] droneCoordinate = new int[n][2];
        for(int i=0;i<n;i++) {
            System.out.print("Drone " + (i + 1) + " row position ");
            droneCoordinate[i][0] = scanner.nextInt();
            System.out.print("Drone " + (i+1) + " column position ");
            droneCoordinate[i][1] = scanner.nextInt();
        }
        for(int i=0;i<droneCoordinate.length;i++) {
            int[] start = droneCoordinate[i];

            System.out.print("Path for Drone " + (i + 1) + ": ");
            boolean pathFound = Drone.findPath(grid, start, target);
            if (pathFound) {
                displayPath(grid);
            } else {
                System.out.println("Path not found");
            }

            reset(grid);
        }
    }

    private static void displayPath(int[][] grid) {
        for(int[] row : grid) {
            for(int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void reset(int[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                grid[i][j]=0;
            }
        }
    }
}