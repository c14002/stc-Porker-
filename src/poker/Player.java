/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author c14002
 */
public class Player {
    static Deck cards;
    private String name;//自分の名前
    protected int coins=0;//手持ちのコインの総数
    protected int score=0;//一回戦ごとの役の得点を記述するための変数
    protected ArrayList<Cards> hand;//手札
    
    public Player(String name,int coins,int score){
        this.name=name;
        this.coins=coins;
        this.score=score;
        hand=new ArrayList<>();
    }
    //コインの設定
    public void setCoins(int num){
        this.coins=num;
    }
    //コインをかける
    public void bet(int num){
        coins-=num;
    }
    //勝利した場合ベットしたコイン＊役の倍率
    public void victry(int num){
        coins+=num;
    }
    //カードを捨てる
    Cards drawOut(int index){
    return hand.remove(index);
}
//カードを引く(手札を加える)
    void drawIn(List<Cards> deck){
    hand.add(deck.remove(0));
}
//スコアの判定
    public  void game(){
        int max=0;
        int pare=0;
        int s=0;
        if(hand.get(0).GetSuit()==hand.get(1).GetSuit())
             if(hand.get(2).GetSuit()==hand.get(3).GetSuit())
                 if(hand.get(2).GetSuit()==hand.get(4).GetSuit())
                     if(hand.get(2).GetSuit()==hand.get(1).GetSuit())
                         max=12;
                     
         for(int g=0;g<4;g++){
              s=0;
             for(int g2=g+1;g2<5;g2++){
                 if(hand.get(g).GetRank()==hand.get(g2).GetRank()){
                     s+=1;
                     
                if(s==2)max=9;
                if(s==3)max=16;
                if(s==4)max=25;
               
                 if(s>max)max=s; 
                 
                 }
                 if(s<0)pare+=1;
                  if(pare==2)if(max>=1) max=pare;
             }
         }
        score=max;
    }
    //スコアの大きさから手札の役を表示する
    public void printscore(){
          switch(score){
             case 0:System.out.println("ノーペアです");break;
             case 1:System.out.println("ワンペアです");break;
             case 2:System.out.println("ツーペアです");break;
             case 9:System.out.println("スリーカードです");break;
             case 12:System.out.println("フラッシュです");break;
             case 16:System.out.println("フォーカードです");break;
             case 25:System.out.println("ファイブカードです");break;
         }
    }
}
