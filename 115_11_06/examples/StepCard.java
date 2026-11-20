
// 類別：StepCard（第 5 週範例）
// 意義：保存一次行動的指令與能源快照。
// 作用：示範封裝、this 與 Getter。
public class StepCard {

    // 指令編號
    private int command;

    // 執行後的能源
    private int energy;

    // 建構子：建立紀錄時設定指令與能源
    public StepCard(int command, int energy) {
        this.command = command;
        this.energy = energy;
    }

    // 回傳指令編號
    public int getCommand() {
        return command;
    }

    // 回傳能源快照
    public int getEnergy() {
        return energy;
    }
}
