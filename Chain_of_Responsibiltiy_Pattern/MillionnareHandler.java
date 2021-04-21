package Chain_of_Responsibiltiy_Pattern;

public class MillionnareHandler extends PartyHandler{
    private String message = "分配到中階派對";
    
    public MillionnareHandler(int maxIncome, int minIncome){
        this.maxIncome = maxIncome;
        this.minIncome = minIncome;
    }
    
    @Override
    String write() {
        // TODO Auto-generated method stub
        return this.message;
    }
    
}
