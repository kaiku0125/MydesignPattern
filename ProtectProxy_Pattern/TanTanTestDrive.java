package ProtectProxy_Pattern;

import java.lang.reflect.*;
import java.util.*;

public class TanTanTestDrive {
    HashMap<String, Account> datingDB = new HashMap<String, Account>();
    public static void main(String[] args) {
        TanTanTestDrive test = new TanTanTestDrive();
        test.drive();
    }
    public TanTanTestDrive(){
        initData();
    }

    void initData(){
        Account man = new User();
        man.setName("Handsome_Guy");
        man.setInterests("Cars, Computer, Music");
        man.setGeekRating(7);
        datingDB.put(man.getName(), man);

        Account lady = new User();
        lady.setName("Beautiful_Girl");
        lady.setInterests("Makeup, Movies, Music");
        lady.setGeekRating(6);
        datingDB.put(lady.getName(), lady);
    }

    Account getUserFromData(String name){
        return datingDB.get(name);
    }

    Account getOwnerProxy(Account account){
        return (Account) Proxy.newProxyInstance(account.getClass().getClassLoader(), 
                                        account.getClass().getInterfaces(), 
                                        new OwnerInvocationHandler(account));
    }
    
    Account getNonOwnerProxy(Account account){
        return (Account) Proxy.newProxyInstance(account.getClass().getClassLoader(), 
                                        account.getClass().getInterfaces(), 
                                        new NonOwnerInvocationHandler(account));
    }

    void drive(){
        Account man = getUserFromData("Handsome_Guy");
        Account ownerProxy = getOwnerProxy(man);
        System.out.println("Name : " + ownerProxy.getName());
        ownerProxy.setInterests("Sporting");
        System.out.println(ownerProxy.getName() + " set Intersert from owner proxy!");
        try {
            ownerProxy.setGeekRating(10);
        } catch (Exception e) {
            System.out.println("Cant set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getGeekRating());

        Account nonOwnerProxy = getNonOwnerProxy(man);
		System.out.println("Name is " + nonOwnerProxy.getName());
		try {
			nonOwnerProxy.setInterests("bowling, Go");
		} catch (Exception e) {
			System.out.println("Can't set interests from non owner proxy");
		}
		nonOwnerProxy.setGeekRating(3);
		System.out.println("Rating set from non owner proxy");
		System.out.println("Rating is " + nonOwnerProxy.getGeekRating());


    }



}
