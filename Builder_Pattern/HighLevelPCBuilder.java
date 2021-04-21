package Builder_Pattern;


public class HighLevelPCBuilder extends PCBuilder {
    String GPU = "RTX 3090";
    String CPU = "i9-10900k";
    String Power = "900W";
    int SSDcap =  1;
    int RAMnum = 2; 

    @Override
    PCBuilder setGPU() {  
        pc.addGPU(GPU);
        return this;
    }

    @Override
    PCBuilder setCPU() {
        pc.addCPU(CPU);
        return this;
    }

    @Override
    PCBuilder setPower() {
        pc.addPower(Power);
        return this;
    }

    @Override
    PCBuilder setSSD() {
        pc.addSSD(SSDcap);
        return this;
    }

    @Override
    PCBuilder setRAM() {
        pc.addRAM(RAMnum);
        return this;
    }  
}
