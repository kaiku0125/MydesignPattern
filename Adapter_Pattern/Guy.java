package Adapter_Pattern;

public class Guy implements Human{

    @Override
    public void walk() {
        System.out.println("正常走路");

    }

    @Override
    public void eat() {
        System.out.println("食用熟食");

    }
    
}
