import java.util.Scanner;

public class DungeonGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter dimensions of the dungeon (R * C): ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        System.out.println("Enter position of adventure : ");
        int adventureRow = scanner.nextInt();
        int adventureColumn = scanner.nextInt();

        System.out.println("Enter position of monster : ");
        int monsterRow = scanner.nextInt();
        int monsterColumn = scanner.nextInt();

        System.out.println("Enter position of gold : ");
        int goldRow = scanner.nextInt();
        int goldColumn = scanner.nextInt();

        int steps = calculateMinimumSteps(rows, columns, adventureRow, adventureColumn, goldRow, goldColumn, monsterRow, monsterColumn);

        if (steps == -1) {
            System.out.println("No possible solution");
        } else {
            System.out.println("Minimum number of steps: " + steps);
        }
    }

    private static int calculateMinimumSteps(int rows, int columns, int adventureRow, int adventureColumn, int goldRow, int goldColumn, int monsterRow, int monsterColumn) {

        if (isMonsterBlocking(adventureRow, adventureColumn, monsterRow, monsterColumn)) {
            return -1;
        }

        if (Math.abs(monsterRow - adventureRow) == 1 || Math.abs(monsterColumn - adventureColumn) == 1) {
            return -1;
        }

        int rowDiff = Math.abs(adventureRow - goldRow);
        int columnDiff = Math.abs(adventureColumn - goldColumn);
        int steps = rowDiff + columnDiff;


        return rowDiff + columnDiff;
    }

    private static boolean isMonsterBlocking(int adventureRow, int adventureColumn, int monsterRow, int monsterColumn) {
        return adventureRow == monsterRow && adventureColumn == monsterColumn;
    }
}
