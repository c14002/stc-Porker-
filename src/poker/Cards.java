/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author c14002
 */
public class Cards {
   public enum Suit{
       Diamond("♦",0),Clover("♣",1),Spade("♠",2),Heart("♥",3);
       private final String label;
       private final int id;
       private Suit(String label,int id){this.label=label;this.id=id;}
       
       String getSuitLael(){return label;}
       int getSuitNumber(){return id;}
       
   }
       public enum Rank{
              ZERO("0",0), A("A",1),Two("2",2),Three("3",3),Four("4",4),Five("5",5),Six("6",6),Seven("7",7),Eight("8",8),Nine("9",9),Ten("10",10),J("J",11),Q("Q",12),K("K",13);
              private final String label;
              private  int id;
              Rank(String label, int id){
                  this.label=label;
                this.id=id;
    }
              String getRankLabel(){return label;}
              int getRankNumber(){return id;}
       }
    static final List<Cards>deck=new ArrayList<>();
     Suit suit;
     Rank rank;
    Cards(int suit,int rank){
        this.suit=Suit.values()[suit];
        this.rank=Rank.values()[rank];
    }
    
    int  GetSuit(){
        return suit.getSuitNumber();
    }
    int  GetRank(){
        return rank.getRankNumber();
    }
    public static ArrayList<Cards> newDeck(){
        return new ArrayList<>(deck);
    }
    @Override
    public String toString(){
        return String.format("%s%s",suit.getSuitLael(),rank.getRankLabel());
    }
}

    

