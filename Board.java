public class Board {
   static int pieces;
    public static void populate(){
        pieces = (int) (Math.random() * 41) + 10;
    }
    public static int getNumPieces(){
        return pieces;
    }

    public static void removePieces(int num){
        pieces-=num;
    }
}
