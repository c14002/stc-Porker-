/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author c14002
 */
public class Card {
    final static Deck deck=new Deck();
    static{
        for(int i=0;i<4;i++){
            for(int j=1;j<=13;j++){
                deck.add(new Cards(i,j));
            }
        }
    }
    static Deck newCard(){
        return deck;
    }
}
