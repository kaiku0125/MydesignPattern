package test;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> mylist = new ArrayList<Integer>();
        int tempMax;
        int max1, max2, max3, min1, min2;
        int Max;
        int Min;

        mylist.add(-5);
        mylist.add(-7);
        mylist.add(-10);
        mylist.add(2);
        mylist.add(5);

        int length = mylist.size();
        for (int i = 0; i < mylist.size(); i++) {
            for (int j = 0; j < mylist.size() - 1; j++) {
                if (mylist.get(j) > mylist.get(j + 1)) {
                    tempMax = mylist.get(j);
                    mylist.set(j, mylist.get(j + 1));
                    mylist.set(j + 1, tempMax);
                }
            }
        }

        for (int i = 0; i < mylist.size(); i++) {
            System.out.println(mylist.get(i));
        }

        max1 = mylist.get(4);
        max2 = mylist.get(3);
        max3 = mylist.get(2);
        min1 = mylist.get(0);
        min2 = mylist.get(1);

        Max = max1 * max2 * max3;
        Min = min1 * min2 * max1;
        System.out.println("MAX : " + compare(Max, Min));
    }

    static int compare(int MAX, int MIN) {
        if (MAX > MIN) {
            return MAX;
        }
        return MIN;
    }
}
