package ProtectProxy_Pattern.Self_Practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MasterInvocationHandler implements InvocationHandler{
    GameUser gameuser;

    public MasterInvocationHandler(GameUser gameUser){
        this.gameuser = gameUser;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            if(method.getName().startsWith("get")){
                return method.invoke(gameuser, args);
            }else if(method.getName().startsWith("Character")){
                return method.invoke(gameuser, args);
            }else if (method.getName().startsWith("set")){
                throw new IllegalAccessException();
            }else if (method.getName().startsWith("remove")){
                throw new IllegalAccessException();
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
