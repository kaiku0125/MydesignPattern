package Builder_Pattern;

import Builder_Pattern.PC.CasesType;

public class Builder_Pattern_testDrive {
    public static void main(String[] args) {
        PCBuilder pcBuilder = new HighLevelPCBuilder();
        PC mynewPC = pcBuilder.setCasesType(CasesType.OPEN)
                              .setGPU()
                              .setCPU()
                              .setPower()
                              .setRAM()
                              .setSSD()
                              .build();
                              
        System.out.println(mynewPC.print());
        // mynewPC.setCasesType(CasesType.CLOSURE);
        // System.out.println(mynewPC.pr);
    }
}
