package Builder_Pattern;

public class PC {
    enum CasesType {CLOSURE, OPEN}
    CasesType casesType;
    String caseDiscription;
    String GPU, CPU, Power;
    int SSDcap, RAMnum;
    
    public PC setCasesType(CasesType casesType){
        this.casesType = casesType;
        switch (casesType){
            case CLOSURE : 
                this.caseDiscription = "封閉式機殼";
                break;

            case OPEN :
                this.caseDiscription = "開放式機殼";
                break;
        }
        return this;
    }    

    PC addGPU(String GPU){
        this.GPU = GPU;
        return this;
    }

    PC addCPU(String CPU){
        this.CPU = CPU;
        return this;
    }

    PC addPower(String Power){
        this.Power = Power;
        return this;
    }

    PC addSSD(int SSDcap){
        this.SSDcap = SSDcap;
        return this;
    }

    PC addRAM(int RAMnum){
        this.RAMnum = RAMnum;
        return this;
    }

    public String print(){
       StringBuilder display = new StringBuilder();
       display.append("外殼 : " + this.caseDiscription + "\n");
       display.append("GPU : " + this.GPU + "\n");
       display.append("CPU : " + this.CPU + "\n");
       display.append("Power : " + this.Power + "\n");
       display.append("SSD : " + this.SSDcap + "TB\n");
       display.append("RAM : 16GB*" + this.RAMnum + "\n");
    
       return display.toString();
    }

}
