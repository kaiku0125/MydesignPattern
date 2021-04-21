package ProtectProxy_Pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler{
    Account account;

    public OwnerInvocationHandler(Account account){
        this.account = account;
    }

    

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if(method.getName().startsWith("get")){
                return method.invoke(account, args);
            }else if (method.getName().equals("setGeekRating")){
                throw new IllegalAccessException();
            }else if (method.getName().startsWith("set")){
                return method.invoke(account, args);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
