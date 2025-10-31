import java.util.Scanner;




public class Game{
   Player player1 = new Player();
   Player player2 = new Player();
    private String input = "";
    private int turn;
    private boolean playAgain;
    Scanner sc = new Scanner(System.in);
   public static void main(String[] args) {
 
   }




   // Constructor for human vs human
   public Game(){
       turn = (int)(Math.random()*2);//random number between 0 and 1
       playAgain=true;
       
       System.out.println("Welcome to the Game of Nim!");
       System.out.println("Player 1 Please enter your name");
       input = sc.nextLine();
       player1.setName(input);
       System.out.println("Player 2 Please enter your name");
       input = sc.nextLine();
       player2.setName(input);
    }
    
    // Constructor for bot games
    public Game(Player p1, Player p2){
        player1 = p1;
        player2 = p2;
        turn = (int)(Math.random()*2);
        playAgain=true;
        System.out.println("Welcome to the Game of Nim!");
        System.out.println(player1.getName() + " vs " + player2.getName());
    }
    public void play(){
       while(playAgain){
        Board.populate();
        while(Board.getNumPieces()>1){
                Player currentPlayer = (turn%2==0) ? player1 : player2;
                System.out.println(currentPlayer.getName()+"'s turn.");
                System.out.println("Current pile: " + Board.getNumPieces() + " pieces");
                
                int numToTake;
                if(currentPlayer.isBot()){
                    BotPlayer bot = (BotPlayer)currentPlayer;
                    numToTake = bot.makeMove(Board.getNumPieces());
                    System.out.println(currentPlayer.getName() + " takes " + numToTake + " pieces.");
                    Board.removePieces(numToTake);
                } else {
                    System.out.print("How many pieces do you want to take?\nInput: ");
                    take(sc.nextInt());
                    sc.nextLine(); // Clear scanner buffer
                }
                
                turn++;
                System.out.println("Remaining pieces: " + Board.getNumPieces());
                System.out.println();
            }
            System.out.println("There is only one piece left...");
            if(turn%2==0){
                System.out.println(player2.getName()+" won!");
                player2.increaseScore();
            }
            else{
                System.out.println(player1.getName()+" won!");
                player1.increaseScore();
            }
            System.out.println("\nCurrent Scores:");
            System.out.println(player1.getName() + ": " + player1.getscore());
            System.out.println(player2.getName() + ": " + player2.getscore());
            // Auto-continue for bot vs bot, ask for human games
            if(player1.isBot() && player2.isBot()){
                // Don't ask, just continue until stopped externally
                System.out.println("Starting another game...");
            } else {
                System.out.println("\nPlay again?(y/n)\nInput: ");
                input = getValidInput();
                if(input.equals("n")){
                    System.out.println("\nFinal Scores:");
                    System.out.println(player1.getName() + ": " + player1.getscore());
                    System.out.println(player2.getName() + ": " + player2.getscore());
                    System.out.println("Thank you for playing!");
                    playAgain=false;
                }
                else System.out.println("Starting another game...");
            }
        }
    }
    public void take(int num){
        while(num < 1 || num > (Board.getNumPieces()/2)){
            if(num < 1){
                System.out.print("You must take at least 1 piece. Choose a different number.\nInput: ");
            } else {
                System.out.print("You can only take half or less of the current pile (max " + (Board.getNumPieces()/2) + "). Choose a different number.\nInput: ");
            }
            num = sc.nextInt();
        }
        Board.removePieces(num);
    }


   public String getValidInput(){
        String i = sc.nextLine().toLowerCase();
        while(!i.equals("y") && !i.equals("n")){
            System.out.println("Invalid input. Please enter 'y' or 'n'.\nInput:");
            i = sc.nextLine().toLowerCase();
        }
        return i;
   }


 
}
