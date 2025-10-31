public class BotPlayer extends Player {
    private boolean isSmart;
    
    public BotPlayer(String name, boolean smart) {
        setName(name);
        isSmart = smart;
    }
    
    // Takes a random legal number of pieces
    public int makeRandomMove(int pileSize) {
        int maxTake = pileSize / 2;
        if (maxTake < 1) maxTake = 1;
        return (int)(Math.random() * maxTake) + 1;
    }
    
    // Smart strategy: Try to leave pile at (3^n - 1) positions
    // Losing positions: 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44, 47, 50
    public int makeSmartMove(int pileSize) {
        int maxTake = pileSize / 2;
        
        // Try to reduce pile to the next (3^n - 1) position
        int[] winningPositions = {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44, 47, 50};
        
        for (int target : winningPositions) {
            if (target < pileSize) {
                int take = pileSize - target;
                if (take >= 1 && take <= maxTake) {
                    return take;
                }
            }
        }
        
        // If can't reach winning position, take 1 to minimize opponent's options
        return 1;
    }
    
    public int makeMove(int pileSize) {
        if (isSmart) {
            return makeSmartMove(pileSize);
        } else {
            return makeRandomMove(pileSize);
        }
    }
    
    public boolean isBot() {
        return true;
    }
    
    public boolean isSmart() {
        return isSmart;
    }
}
