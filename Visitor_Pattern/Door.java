package Visitor_Pattern;

public class Door implements CarPart {
    @Override
    public void accept(CarPartVisitor visitor) {
        visitor.visit(this);
    }

    public void dispaly() {
        System.out.println("確認門已關閉");
    }
}
