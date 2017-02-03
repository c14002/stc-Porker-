/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author c14002
 */
public class PokerTester {
    static Deck card;
    
    
      public static void main(String[] args) {
      
          int cont=0;
         Scanner stdIn=new Scanner(System.in);
         Player ishihara=new HumanPlayer("Ishihara",100,0);
         Player computer=new Computer("Com1",100,0);
          System.out.println("ルール１ ポーカーの役はワンペア、ツーペア、スリーカード、フラッシュ、フォーカード、ファイブカード");
         System.out.println("ルール２手札は一枚ずつ交換します");
         System.out.println("ルール３コインは１００枚までコインをかけられる");
         do{ 
             card=Card.newCard();
             card.shuffle();
//デッキをシャッフルする
         for(int i=0;i<5;i++){
             
        ishihara.drawIn(card);//プレイヤーの手札を５枚補充
        computer.drawIn(card);//CPUの手札を５枚補充
      }
         
         System.out.println("ポーカーゲームを開始します");
        
         System.out.println("あなたの手札は");
         for(int j=0;j<ishihara.hand.size();j++){
             System.out.print(ishihara.hand.get(j));//手札の表示
         }
         System.out.println();
         System.out.println("コインをいくつかけますか？");
         int b=stdIn.nextInt();//賭けるコインの枚数を指定
         if(b>ishihara.coins)b=ishihara.coins;
         ishihara.bet(b);//指定したコインだけ捨てる。
         System.out.println("コイン残高："+ishihara.coins);
         System.out.println("ゲームを開始します。手札を何枚交換しますか？");
         int h=stdIn.nextInt();//かけるコインをキーボードで指定するための関数
         for(int i=0;i<h;i++){
             System.out.println("交換する手札を指定してください");
             int change=stdIn.nextInt();//交換したい手札の場所をキーボード入力で指定
             ishihara.drawOut(change-1);//指定した場所のカードを捨てる。
             ishihara.drawIn(card);//手札の一番最後に一枚補充
         
         System.out.println("現在のあなたの手札は");
         for(int j=0;j<ishihara.hand.size();j++){
             System.out.print(ishihara.hand.get(j));//交換した後の手札を表示
         }
         }
         System.out.println("です。対戦を開始します。"); 
         
         //手札の役の判定役に応じてスコアが設定されており自分のスコアに記述しておく        
         ishihara.game();
         computer.game();
         
         System.out.println("あなたの手札の役は");
         ishihara.printscore();//スコアに対する役を表示する。
         
         System.out.println("Com1の手札と役は");
         for(int j=0;j<computer.hand.size();j++){
             System.out.print(computer.hand.get(j));//Computerの手札を表示
         }
         System.out.println();
         computer.printscore();//Computerのスコアを表示
         
         if(ishihara.score>computer.score){//勝ちか負けかの判定スコアの大きい方が勝ち
             System.out.println("あなたの勝ちです");
             
             computer.bet(ishihara.score*b);
             ishihara.victry(ishihara.score*b);
         }
         else if(computer.score>ishihara.score){
             System.out.println("あなたの負けです");
             ishihara.bet(ishihara.score*b);
         }
         else
             System.out.println("引き分けです");
         if(ishihara.coins<=0){
         System.out.println("コインが０になりましたゲームオーバーです。");
         
//コインが０になったら自動的に終了
         cont=1;
         }
         else{
             System.out.println("あなたの現在のコインの残高は"+ishihara.coins);
//コインが０ではない場合今のコイン枚数を表示し、ゲームを続けるかを判定するかに移行
             System.out.println("もう一度挑戦しますか？はい：０いいえ：１");
//もう一度挑戦するかをキーボード入力で判定
             cont=stdIn.nextInt();
         }
         for(int i=0;i<5;i++){
             ishihara.drawOut(0);
             computer.drawOut(0);
             //ここで自分と相手の手札を捨てる。
                 }
      }while(cont==0);
         System.out.println();
      }
}
