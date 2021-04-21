package Template_Pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Man extends MorningSet{

    public String answer = null;

    @Override
    void hairset() {
        System.out.println("用髮蠟抓造型...");
    }

    @Override
    void makeup() {
        System.out.println("刮鬍子...");
    }

    @Override
    void perfume() {
        System.out.println("噴男士香水...");
    }

    @Override
    void wearing() {
        System.out.println("穿西裝...");
    }

    boolean havedate(){
        answer = getclientAnswer();
        if(answer.toLowerCase().startsWith("y")){
            return true;
        }else{
            return false;
        }
    }
    
    private String getclientAnswer(){
        System.out.println("請問今天要與心儀的人約會嗎?");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = input.readLine();
        } catch (Exception e) {
            System.out.println("error...");
        }
        if(answer == null){
            return null;
        }
        return answer;
    }
    
}
