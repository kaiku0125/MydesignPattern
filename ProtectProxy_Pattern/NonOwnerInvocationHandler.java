package ProtectProxy_Pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NonOwnerInvocationHandler implements InvocationHandler{
    Account account;

    public NonOwnerInvocationHandler(Account account){
        this.account = account;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
			if (method.getName().startsWith("get")) {
				return method.invoke(account, args);
   			} else if (method.getName().equals("setGeekRating")) {
				return method.invoke(account, args);
			} else if (method.getName().startsWith("set")) {
				throw new IllegalAccessException();
			} 
        } catch (Exception e) {
            e.printStackTrace();
        } 
		return null;
	}
}
    


