package Chain_of_Responsibiltiy_Pattern;

import java.io.IOException;
import java.util.Scanner;

public class COR_testDrive {
    public static void main(String[] args) throws IOException {
        PartyHandler handler = getchainAllHandler();
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入年薪 : (單位/萬)...");
        int input = scanner.nextInt();
        handler.printMessage(input);
    }

    private static PartyHandler getchainAllHandler(){
        int max = 99999999;
        
        PartyHandler billion = new BillionnaireHandler(max, 1001);
        PartyHandler million = new MillionnareHandler(1000, 101);
        PartyHandler normal = new NormalHandler(100, 0);

        billion.setNextHandler(million);
        million.setNextHandler(normal);

        return billion;
    }
}
