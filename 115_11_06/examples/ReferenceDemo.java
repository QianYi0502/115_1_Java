
 // 類別：ReferenceDemo（第 5 週範例）
 // 意義：示範物件變數存的是「參考」。
 // 作用：比較別名、物件傳入方法後的狀態變化，
 // 以及在方法內重新指定參考的情況。
 public class ReferenceDemo {

     // main：程式進入點，依序執行三種參考實驗。
     public static void main(String[] args) {

         RoverBattery first = new RoverBattery(20);
         RoverBattery alias = first;
         RoverBattery other = new RoverBattery(20);

         // 別名指向同一個物件。
         alias.explore();

         System.out.println("建立別名後="
                 + first.getEnergy() + "/" + other.getEnergy());

         System.out.println("同一個參考="
                 + (first == alias));

         // 將物件傳入方法並修改其狀態。
         spend(first);

         System.out.println("扣除能源後="
                 + first.getEnergy());

         // 方法內重新指定參考。
         replaceLocal(first);

         System.out.println("重新指定參考後="
                 + first.getEnergy());
     }

     // spend：讓傳入的電池探索一次。
     static void spend(RoverBattery battery) {
         battery.explore();
     }

     // replaceLocal：在方法內建立新電池。
     // 重新指定參數不會改變呼叫端的參考。
     static void replaceLocal(RoverBattery battery) {
         battery = new RoverBattery(1);

         System.out.println("方法內新物件的能源="
                 + battery.getEnergy());
     }
 }
