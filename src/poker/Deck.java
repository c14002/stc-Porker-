/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
/**
 *
 * カードの山
 */
public class Deck extends Stack<Cards>{
 Deck(){
     
 }
 void shuffle(){
        Collections.shuffle(this);
 }
}
