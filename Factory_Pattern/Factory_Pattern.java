package Factory_Pattern;

import java.util.Scanner;




public class Factory_Pattern {

    public static void main(String[] args) {     
  
        CharacterRegister warriorreg = new WarriorRegister();
        CharacterRegister magereg = new MageRegister();
        Character kevin;
        // Character kevin = warriorreg.regCha(type);
        boolean n = false;
  
        System.out.println("此為角色創建系統");
        
        while(true){
            System.out.println("是否要創建角色(請輸入y / n)?");
            Scanner scanner = new Scanner(System.in);
            String iscreated = scanner.next();
            if (iscreated.equals("n")){
                break;
            }
            System.out.println("輸入要創建的角色定位(請輸入 w(戰士) / m(法師))...");
            String ischaractered = scanner.next();

            if (ischaractered.equals("w")){
                System.out.println("請輸入屬性(請輸入 f(火)/ w(水)...)");
                
                String istyped = scanner.next();
                    switch(istyped){
                        case "f":
                            kevin = warriorreg.regCha("fire");
                            System.out.println("-----------創建結束-------------");
                            break;
                        case "w":
                            kevin = warriorreg.regCha("water");
                            System.out.println("-----------創建結束-------------");
                            break;
                    }      
            }
            else if(ischaractered.equals("m")){
                System.out.println("請輸入屬性(請輸入 f(火)/ w(水)...)");
                String istyped = scanner.next();
                    switch(istyped){
                        case "f":
                            kevin = magereg.regCha("fire");
                            System.out.println("-----------創建結束-------------");
                            break;
                        case "w":
                            kevin = magereg.regCha("water");
                            System.out.println("-----------創建結束-------------");
                            break;
                }
            }
    }
}
}
        
            
            
            
        
            
       
    

