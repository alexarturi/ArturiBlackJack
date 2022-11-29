public class Blackjack {
    private int startAmount; //amount of money to begin with to bet
    private boolean broke = false; //boolean that will determine when the game is over
    private int score = 0;
    private int  winnings;


    public Blackjack(){
        startAmount = 500;
        winnings = startAmount;
    }
    //constructor with a parameter for start amount
    public Blackjack(int a){
        startAmount = a;
        winnings = a;
    }
    public void intro(){
        System.out.println("Welcome to Blackjack!");
        System.out.println("This is a game of both reasoning and luck.");
        System.out.println("You will first be asked how much money you want to bet.");
        System.out.println("Then, you will be dealt your hand and will be asked to either hit or stand.");
        System.out.println("In this game, Aces are only worth 1 point.");
        System.out.println("The person closest to 21 wins!");
    }

    public String pickCard(){
        int randomize = (int)(Math.random()*13)+1;
        int randomize2 = (int)(Math.random()*4);
        if (randomize == 1){
            if (randomize2 == 0){
                return "Ace.Spades";
            } else if (randomize2 == 1){
                return "Ace.Clubs";
            } else if (randomize2 == 2){
                return "Ace.Hearts";
            } else {
                return "Ace.Diamonds";
            }
        } else if (randomize>1 && randomize<11){
            String s = Integer.toString(randomize);
            if (randomize2 == 0){
                return s + ".Spades";
            } else if (randomize2 == 1){
                return s + ".Clubs";
            } else if (randomize2 == 2){
                return s + ".Hearts";
            } else {
                return s + ".Diamonds";
            }
        } else if (randomize==11){
            if (randomize2 == 0){
                return "Jack.Spades";
            } else if (randomize2 == 1){
                return "Jack.Clubs";
            } else if (randomize2 == 2){
                return "Jack.Hearts";
            } else {
                return "Jack.Diamonds";
            }
        } else if (randomize ==12){
            if (randomize2 == 0){
                return "Queen.Spades";
            } else if (randomize2 == 1){
                return "Queen.Clubs";
            } else if (randomize2 == 2){
                return "Queen.Hearts";
            } else {
                return "Queen.Diamonds";
            }
        } else {
            if (randomize2 == 0){
                return "King.Spades";
            } else if (randomize2 == 1){
                return "King.Clubs";
            } else if (randomize2 == 2){
                return "King.Hearts";
            } else {
                return "King.Diamonds";
            }
        }
    }
    public int getStartAmount(){
        return startAmount;
    }

    public int getWinnings(){
        return winnings;
    }

    public void subtractFromStartAmount(int s){
        startAmount-=s;
    }

    public void changeWinnings(int s){
        winnings +=s;
    }
    public String getCard(String s){
        return s.substring(0, s.indexOf("."));
    }

    public String getSuit(String s){
        return s.substring(s.indexOf(".")+1);
    }

    public int valueConverter(String s){
        if (s.equals("Ace")){
            return 1;
        } else if (s.equals("Queen") || s.equals("King") || s.equals("Jack")){
            return 10;
        } else {
            return Integer.parseInt(s);
        }
    }

    public void play(int risk){

    }
}
