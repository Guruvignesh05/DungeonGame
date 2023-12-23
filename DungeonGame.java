import java.util.Scanner;

public class DungeonGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

           System.out.println("Enter dimensions of the dungeon (R *C): ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

          System.out.println("Enter position of adventure : ");
        int adventureRow = scanner.nextInt();
        int adventureColumn = scanner.nextInt();

          System.out.println("Enter position of gold : ");
         int goldRow = scanner.nextInt();
         int goldColumn = scanner.nextInt();

         int steps = calculateMinimumSteps(rows, columns, adventureRow, adventureColumn, goldRow, goldColumn);
         System.out.println("Minimum number of steps: " + steps);
    }

    private static int calculateMinimumSteps(int rows, int columns, int adventureRow, int adventureColumn, int goldRow, int goldColumn) {

         int rowDifference = Math.abs(adventureRow - goldRow);
            int columnDifference = Math.abs(adventureColumn - goldColumn);

        return rowDifference + columnDifference;
    }
}
