package Strategy_Pattern;

import java.util.Scanner;

public class Strategy_Pattern {
   public static void main(String[] args){

      /////初始化物件/////
      Character Kevin = new Player1("Kevin");
      System.out.println("玩家名稱:"+Kevin.getname());
      Kevin.fight();

      Character Rock = new Player2("Rock");
      System.out.println("玩家名稱:"+Rock.getname());
      Rock.fight();

      //////更換武器階段//////
      System.out.println("----------------a few moments later-------------------");
      System.out.println(Kevin.getname()+"想換武器!!");
      Kevin.weaponchanged();
      //////更換武器階段//////
      System.out.println("----------------a few moments later-------------------");
      System.out.println(Kevin.getname()+"又想換武器了!!");
      Kevin.weaponchanged();
 
   }
   
}