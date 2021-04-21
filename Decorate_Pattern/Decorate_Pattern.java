package Decorate_Pattern;

public class Decorate_Pattern {

    public static void main(String[] args){

       Character character = new warrior();
       System.out.println(character.getDescription()+",總防禦力:"+character.defense());


       Character character2 = new warrior();
       character2 = new helmet(character2);
       System.out.println(character2.getDescription()+",總防禦力:"+character2.defense());

       Character character3 = new warrior();
       character3 = new helmet(character3) ;
       character3 = new armor(character3);
       System.out.println(character3.getDescription()+",總防禦力:"+character3.defense());

    }
    
}
