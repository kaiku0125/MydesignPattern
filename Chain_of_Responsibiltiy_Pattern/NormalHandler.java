package Chain_of_Responsibiltiy_Pattern;

public class NormalHandler extends PartyHandler{
    private String message = "分配到一般派對";

    public NormalHandler(int maxIncome, int minIncome){
        this.maxIncome = maxIncome;
        this.minIncome = minIncome;
    }
   
    @Override
    String write() {
        // TODO Auto-generated method stub
        return this.message;
    }
    
}
