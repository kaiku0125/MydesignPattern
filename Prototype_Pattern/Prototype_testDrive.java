package Prototype_Pattern;

public class Prototype_testDrive {
    public static void main(String[] args) {
        Manager.loadAllobject();

        GameObject player5487 = Manager.getObject(1);
        System.out.print("GameObject :" + player5487.getType() + "__");
        player5487.ability();
        System.out.println("-----------");

        GameObject player6666 = Manager.getObject(1);
        System.out.print("GameObject :" + player6666.getType() + "__");
        player6666.ability();
        System.out.println("-----------");

        GameObject monster7777 = Manager.getObject(2);
        System.out.print("GameObject :" + monster7777.getType() + "__");
        monster7777.ability();
    }
}
