package State_Pattern;

public class WeaponStore {
    State hasMaterialState;
    State noMaterialState;
    State successState;
    State failureState;
    Weapon weapon;
    

    State state;

    public WeaponStore(Weapon weapon){
        hasMaterialState = new HasMaterialState(this);
        noMaterialState = new NoMaterialState(this);
        successState = new SuccessState(this);
        failureState = new FailureState(this);
        this.weapon = weapon;
        state = noMaterialState;
    }

    public void insertMaterial(){
        state.insertMaterial();
    }

    public void ejectMaterial(){
        state.ejectMaterial();
    }
    
    public void pressEnhancement(){
        state.pressEnhancement();
    }

    public void onceagain(){
        state.onceagain();
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }

    public State getNoMaterailState(){
        return noMaterialState;
    }

    public State getHasMaterialState(){
        return hasMaterialState;
    }
    public State getSuccessState(){
        return successState;
    }
    public State getFailureState(){
        return failureState;
    }




}
