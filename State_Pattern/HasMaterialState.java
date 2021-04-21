package State_Pattern;

public class HasMaterialState implements State{

    WeaponStore weaponStore;
    int tempLevel = 0;
    int random = 0;

    public HasMaterialState(WeaponStore weaponStore) {
        this.weaponStore = weaponStore;
	}

	@Override
    public void insertMaterial() {
        System.out.println("已經放入素材");
    }

    @Override
    public void ejectMaterial() {
        System.out.println("取回素材");
        weaponStore.setState(weaponStore.getNoMaterailState());
    }

    @Override
    public void pressEnhancement() {
        System.out.print("您按下強化按鈕,");
        System.out.println("強化中...");
        Weapon.Level = tempLevel;

        if(tempLevel > 2){
            random = (int)(Math.random()*100) + 1;
            // System.out.println("機率:" + random);
            if (random <= 70) {
                tempLevel = tempLevel + 1;
                Weapon.Level = tempLevel;
                System.out.println("強化成功!! 武器等級升為:+" + Weapon.getLevel());
                weaponStore.setState(weaponStore.getSuccessState());
            } else {
                tempLevel = tempLevel - 1;
                Weapon.Level = tempLevel;
                System.out.println("強化失敗...武器等級降為:+" + Weapon.getLevel());
                weaponStore.setState(weaponStore.getFailureState());
            }
        }else{
            System.out.println("強化100%成功");
            tempLevel = tempLevel + 1;
            Weapon.Level = tempLevel;
            System.out.println("武器等級為:+" + Weapon.getLevel());
            weaponStore.setState(weaponStore.getSuccessState());
        }
     
    }

    @Override
    public void onceagain() {
        System.out.println("無效動作!!");
    }
    
}
