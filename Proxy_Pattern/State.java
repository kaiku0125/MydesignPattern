package Proxy_Pattern;

import java.io.Serializable;

public interface State extends Serializable{
    public void insertMaterial();
    public void ejectMaterial();
    public void pressEnhancement();
    public void onceagain();

}

