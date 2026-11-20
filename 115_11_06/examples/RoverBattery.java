
// 類別：RoverBattery（第 5 週範例）
// 意義：探測車的電池，保存目前能源，數值會隨探索和充電改變。
// 作用：示範用 private 欄位保護狀態，外部只能透過方法修改能源。
// 建構前提：initialEnergy 為 0～20；本週不處理不合法的呼叫。
public class RoverBattery {

    // energy：目前能源格數（0～20）。
    private int energy;

    // 建構子：設定電池的初始能源。
    public RoverBattery(int initialEnergy) {
        energy = initialEnergy;
    }

    // getEnergy：回傳目前能源。
    public int getEnergy() {
        return energy;
    }

    // explore：探索一次，消耗 6 格能源。
    // 能源不足時回傳 false，能源不變。
    public boolean explore() {
        if (energy < 6) {
            return false;
        }

        energy -= 6;
        return true;
    }

    // charge：充電一次，增加 5 格能源，最多 20 格。
    // 已經滿電時回傳 false。
    public boolean charge() {
        if (energy == 20) {
            return false;
        }

        energy += 5;

        if (energy > 20) {
            energy = 20;
        }

        return true;
    }
}
