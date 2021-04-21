package ProtectProxy_Pattern.Self_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Proxy;


public class Init_data {
    GameUser player = new User();
    GameUser master = new User();
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

    public Init_data(){
        database();
    }

    public void database(){
        player.setUserID("player5487");
        player.setPassword("myPassword");
        player.setCharacterName("myfirstCharacter");
        
        master.setUserID("MasterAccount");
        master.setPassword("123456789");
        master.setCharacterName("Master");
    }

    public GameUser getPlayerProxy(GameUser gameUser){
        return (GameUser) Proxy.newProxyInstance(gameUser.getClass().getClassLoader(),
                                                gameUser.getClass().getInterfaces(), 
                                                new PlayerInvocationHanlder(gameUser));
    }

    public GameUser getMasterProxy(GameUser gameUser){
        return (GameUser) Proxy.newProxyInstance(gameUser.getClass().getClassLoader(), 
                                                gameUser.getClass().getInterfaces(), 
                                                new MasterInvocationHandler(gameUser));
    }

    public void drive() throws IOException{
        System.out.print("ENTER USERID:");
        String input = buf.readLine();

        if (input.equals(player.getUserID())){
            System.out.println("登入權限為一般使用者...");
            GameUser playerProxy = getPlayerProxy(player);
            playerProxy.getCharacterAttack();
            System.out.println("原始攻擊力為: " + player.getCharacterAttack());
            try {
                playerProxy.CharacterAttack_adjust(500);
            } catch (Exception e) {
                System.out.println("無權限更改角色攻擊力!");
            }
            playerProxy.removeAccount();

        }else if (input.equals("MasterAccount")){
            System.out.println("登入權限為Master...");
            GameUser masterProxy = getMasterProxy(master);
            masterProxy.getCharacterAttack();
            System.out.println("原始攻擊力為 : " + master.getCharacterAttack());
            masterProxy.CharacterAttack_adjust(99999999);
            System.out.println("攻擊力調整為 : " + master.getCharacterAttack());
            try {
                masterProxy.removeAccount();
            } catch (Exception e) {
                System.out.println("無權限移除帳號!");
            }
            
        }else{
            System.out.println("輸入錯誤");
        }

    }
}
