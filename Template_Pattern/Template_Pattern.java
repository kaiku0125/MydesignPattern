package Template_Pattern;

public class Template_Pattern {
    public static void main(String[] args) {
        
        Man man = new Man();
        Lady lady = new Lady();
        System.out.println("女人每天出門前:");
        lady.daily();
        System.out.println("-----------------------");
        System.out.println("男人每天出門前:");
        man.daily();
        
    }
    
}
