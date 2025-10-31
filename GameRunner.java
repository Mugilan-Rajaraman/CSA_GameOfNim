import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== GAME OF NIM ===");
        System.out.println("Select game mode:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Random Bot");
        System.out.println("3. Human vs Smart Bot");
        System.out.println("4. Smart Bot vs Smart Bot");
        System.out.print("Enter choice (1-4): ");
        
        int choice = sc.nextInt();
        sc.nextLine(); // Clear buffer
        
        Game nim;
        
        switch(choice) {
            case 1:
                // Human vs Human
                nim = new Game();
                nim.play();
                break;
                
            case 2:
                // Human vs Random Bot
                System.out.print("Enter your name: ");
                String humanName = sc.nextLine();
                Player human = new Player();
                human.setName(humanName);
                BotPlayer randomBot = new BotPlayer("RandomBot", false);
                nim = new Game(human, randomBot);
                nim.play();
                break;
                
            case 3:
                // Human vs Smart Bot
                System.out.print("Enter your name: ");
                String playerName = sc.nextLine();
                Player player = new Player();
                player.setName(playerName);
                BotPlayer smartBot = new BotPlayer("SmartBot", true);
                nim = new Game(player, smartBot);
                nim.play();
                break;
                
            case 4:
                // Smart Bot vs Smart Bot
                BotSimulation.runSimulation();
                break;
                
            default:
                System.out.println("Invalid choice. Starting Human vs Human...");
                nim = new Game();
                nim.play();
        }
        
        sc.close();
    }
}


