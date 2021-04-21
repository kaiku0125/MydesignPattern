package Composite_Pattern;

public class Composite_Pattern {
    public static void main(String[] args) {
        MenuComponent sniperMenu = new GunMenu("SniperMenu");
        MenuComponent rifleMenu = new GunMenu("RifleMenu");
        MenuComponent machineMenu = new GunMenu("MachineMenu");
        MenuComponent airdropMenu = new GunMenu("AirdropMenu");

        MenuComponent allGunMenus = new GunMenu("AllGunMenus");

        allGunMenus.add(sniperMenu);
        allGunMenus.add(rifleMenu);
        allGunMenus.add(machineMenu);

        sniperMenu.add(new GunItem("KAR98K", 7.62, false, 72));
        sniperMenu.add(new GunItem("SKS", 7.62, false, 55));
        sniperMenu.add(new GunItem("VSS", 9, true, 35));
        sniperMenu.add(new GunItem("Mini14", 5.56, false, 44));
        sniperMenu.add(airdropMenu);

        airdropMenu.add(new GunItem("AWM", 0.300, false, 132));
        airdropMenu.add(new GunItem("M24", 7.62, false, 82));

        rifleMenu.add(new GunItem("AKM", 7.62, true, 48));
        rifleMenu.add(new GunItem("M416", 5.56, true, 41));
        rifleMenu.add(new GunItem("SCAR-L", 5.56, true, 41));
        rifleMenu.add(new GunItem("M16A4", 5.56, false, 41));

        machineMenu.add(new GunItem("UMP9", 9, true, 35));

        Overview overview = new Overview(allGunMenus);
        overview.printall();
        overview.printAutoGun();

    }
}
