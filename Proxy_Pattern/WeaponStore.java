package Proxy_Pattern;

import java.rmi.server.*;
import java.rmi.*;

public class WeaponStore extends UnicastRemoteObject implements WeaponStoreRemote{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    State hasMaterialState;
    State noMaterialState;
    State successState;
    State failureState;
    Weapon weapon;
    String location;
    

    State state;

    public WeaponStore(String location) throws RemoteException{
        hasMaterialState = new HasMaterialState(this);
        noMaterialState = new NoMaterialState(this);
        successState = new SuccessState(this);
        failureState = new FailureState(this);
        // this.weapon = weapon;
        this.location = location;
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

    @Override
    public String getLocation(){
        
        return location;
    }
}
