public class BotSimulation {
    
    public static void runSimulation() {
        System.out.println("\n=== SMART BOT vs SMART BOT ===\n");
        
        BotPlayer bot1 = new BotPlayer("SmartBot1", true);
        BotPlayer bot2 = new BotPlayer("SmartBot2", true);
        
        // Setup game
        Board.populate();
        int startingPileSize = Board.getNumPieces();
        int turn = (int)(Math.random() * 2);
        
        String firstPlayer = (turn == 0) ? "SmartBot1" : "SmartBot2";
        
        System.out.println("Starting pile: " + startingPileSize + " pieces");
        System.out.println(firstPlayer + " goes first\n");
        
        // Play the game
        while (Board.getNumPieces() > 1) {
            BotPlayer currentBot = (turn % 2 == 0) ? bot1 : bot2;
            String currentPlayerName = currentBot.getName();
            
            int numToTake = currentBot.makeMove(Board.getNumPieces());
            Board.removePieces(numToTake);
            
            System.out.println(currentPlayerName + " takes " + numToTake + " pieces. (" + Board.getNumPieces() + " remaining)");
            
            turn++;
        }
        
        // Determine winner
        String winner = (turn % 2 == 0) ? "SmartBot2" : "SmartBot1";
        
        System.out.println("\n" + winner + " wins!");
        System.out.println("With smart play, certain pile sizes favor the first player, while others favor the second player. The key losing positions are:2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44, 47, 50");
    }
}
