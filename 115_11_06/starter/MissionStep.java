
 // 類別：MissionStep（第 5 週學生實作）
 // 意義：保存任務日誌中已經發生的一步。
 // 記錄指令、執行後能源與執行結果。
 public class MissionStep {

     // 這一步讀取的指令編號
     private int command;

     // 執行後的能源快照
     private int energy;

     // 執行結果
     private String result;

     // 建構子：建立一筆完整的任務紀錄
     public MissionStep(int command, int energy, String result) {
         this.command = command;
         this.energy = energy;
         this.result = result;
     }

     // 回傳指令編號
     public int getCommand() {
         return command;
     }

     // 回傳執行後能源
     public int getEnergy() {
         return energy;
     }

     // 回傳執行結果
     public String getResult() {
         return result;
     }

     // 判斷這一步是否成功
     public boolean isSuccessful() {
         return "成功".equals(result);
     }
 }
