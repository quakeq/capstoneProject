import utility.Constants.*;

import java.util.HashMap;

public class UserValues {


    private static HashMap<ShopItems, Integer> items = new HashMap<>(ShopItems.values().length);;
    private static double money = GameConstants.startMoney;

    public static void changeItemAmt(ShopItems item, int num){
        if ((items.get(item) + num) > 0){
            items.put(item, items.get(item) + num);
        }
    }

    public static Integer getItemAmt(ShopItems item){
        return items.get(item);
    }

    public static void changeMoneyAmt(double num){
        money += num;
    }

    public static double getMoneyAmt(){
        return money;
    }

}
