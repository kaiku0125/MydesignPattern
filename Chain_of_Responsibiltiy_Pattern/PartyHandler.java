package Chain_of_Responsibiltiy_Pattern;

public abstract class PartyHandler {
    protected int maxIncome, minIncome;
    protected PartyHandler nextPartyHandler;

    public void setNextHandler(PartyHandler nextPartyHandler){
        this.nextPartyHandler = nextPartyHandler;
    }

    public void printMessage(int income){
        if(this.maxIncome > income && this.minIncome < income){
            System.out.println("此年薪範圍 : " + this.minIncome + "~" + this.maxIncome);
            System.out.println(write());
        }
        if(nextPartyHandler != null){
            nextPartyHandler.printMessage(income);
        }
        
    }

    abstract String write();
}
