public class Player {
    private String name;
    private int score;
    

    

    public int getscore(){
        return score;
    }

    public String getName(){
        return name;
    }
    public void setName(String Pname){
        name = Pname;
    }

    public void increaseScore(){
        score +=1;
    }

    public int takeTurn(int turn){
        return turn;
    }
    
    public boolean isBot(){
        return false;
    }
}
