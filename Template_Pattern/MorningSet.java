package Template_Pattern;

public abstract class MorningSet {

    final void daily(){
        brushteeth();
        washface();
        maintenance();
        hairset();
        makeup();
        if(havedate()){
            perfume();
            wearing();
        }
    }
    void brushteeth(){
        System.out.println("刷牙...");
    }
    void washface(){
        System.out.println("洗臉...");
    }
    void maintenance(){
        System.out.println("保濕抹化妝水...");
    }
    abstract void hairset();
    abstract void makeup();

    abstract void perfume();
    abstract void wearing();
    boolean havedate(){
        return false;
    }
    
}
