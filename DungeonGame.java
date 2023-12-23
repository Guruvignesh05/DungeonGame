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

        String path = calculateMinimumSteps(rows, columns, adventureRow, adventureColumn, goldRow, goldColumn, monsterRow, monsterColumn);

        if (path.equals("No possible solution")) {
            System.out.println("No possible solution");
        } else {
            System.out.println("Minimum number of steps: " + path.split(" -> ").length);
            System.out.println("Path: " + path);
        }
    }

    private static String calculateMinimumSteps(int rows, int columns, int adventureRow, int adventureColumn, int goldRow, int goldColumn, int monsterRow, int monsterColumn) {
        if (isMonsterBlocking(adventureRow, adventureColumn, monsterRow, monsterColumn)) {
            return "No possible solution";
        }


        if (Math.abs(monsterRow - adventureRow) == 1 || Math.abs(monsterColumn - adventureColumn) == 1) {
            return "No possible solution";
        }

        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append("(").append(adventureRow).append(",").append(adventureColumn).append(")");

        while (adventureRow != goldRow || adventureColumn != goldColumn) {

            if (adventureRow < goldRow) {
                adventureRow++;
            } else if (adventureRow > goldRow) {
                adventureRow--;
            }

            if (adventureColumn < goldColumn) {
                adventureColumn++;
            } else if (adventureColumn > goldColumn) {
                adventureColumn--;
            }

            pathBuilder.append(" -> (").append(adventureRow).append(",").append(adventureColumn).append(")");
        }

        return pathBuilder.toString();
    }

    private static boolean isMonsterBlocking(int adventureRow, int adventureColumn, int monsterRow, int monsterColumn) {
        return adventureRow == monsterRow && adventureColumn == monsterColumn;
    }
}
