package Chain_of_Responsibiltiy_Pattern;

public class BillionnaireHandler extends PartyHandler{
    
    private String message = "分配到豪華派對";
    public BillionnaireHandler(int maxIncome, int minIncome){
        this.maxIncome = maxIncome;
        this.minIncome = minIncome;
    }
   
    @Override
    String write() {
        
        return this.message;
    }
    
}
