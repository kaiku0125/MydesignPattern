package Builder_Pattern;

import Builder_Pattern.PC.CasesType;

public abstract class PCBuilder {
    CasesType casesType;
    PC pc = new PC();

    public PCBuilder setCasesType(CasesType casesType){
        this.casesType = casesType;
        pc.setCasesType(casesType);
        return this;
    }

    abstract PCBuilder setGPU();
    abstract PCBuilder setCPU();
    abstract PCBuilder setPower();
    abstract PCBuilder setSSD();
    abstract PCBuilder setRAM();

    public PC build(){
        return pc;
    }  
}
