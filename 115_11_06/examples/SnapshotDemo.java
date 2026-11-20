
import java.util.ArrayList;

// 類別：SnapshotDemo（第 5 週範例）
// 意義：示範「目前狀態」與「歷史紀錄」的差別。
// 作用：每次行動後建立 StepCard，保存當下能源。
public class SnapshotDemo {

    public static void main(String[] args) {

        RoverBattery battery = new RoverBattery(20);
        ArrayList<StepCard> history = new ArrayList<>();

        // 第一次探索，能源 20 → 14
        battery.explore();
        history.add(new StepCard(1, battery.getEnergy()));

        // 充電，能源 14 → 19
        battery.charge();
        history.add(new StepCard(3, battery.getEnergy()));

        // 輸出每一步的歷史紀錄
        for (StepCard step : history) {
            System.out.println("指令=" + step.getCommand()
                    + ", 能源=" + step.getEnergy());
        }

        // 目前電池能源
        System.out.println("目前能源=" + battery.getEnergy());

        // 檢查是否為不同的紀錄物件
        System.out.println("各自獨立的紀錄="
                + (history.get(0) != history.get(1)));
    }
}
