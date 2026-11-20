
// 第五週：MissionLog 任務日誌
// 使用 ArrayList<MissionStep> 保存每一步的指令、能源及結果。

import java.util.ArrayList;
import java.util.Arrays;

public class MissionLog {

    public static void main(String[] args) {
        int[] script = {1, 1, 2};
        runMission(script, 20, 0);
    }

    // 執行一次完整任務
    static void runMission(int[] script, int energy, int samples) {
        int actionCount = 0;
        boolean running = true;

        ArrayList<MissionStep> history = new ArrayList<>();

        for (int i = 0;
             i < script.length && running && energy > 0 && samples < 5;
             i++) {

            int command = script[i];
            String result;

            switch (command) {
                case 1:
                    if (energy >= 6) {
                        energy -= 6;
                        samples += 2;
                        actionCount++;
                        result = "成功";
                    } else {
                        result = "能源不足";
                    }
                    break;

                case 2:
                    if (energy >= 2) {
                        energy -= 2;
                        samples++;
                        actionCount++;
                        result = "成功";
                    } else {
                        result = "能源不足";
                    }
                    break;

                case 3:
                    if (energy < 20) {
                        energy = Math.min(20, energy + 5);
                        actionCount++;
                        result = "成功";
                    } else {
                        result = "能源已滿";
                    }
                    break;

                case 0:
                    running = false;
                    result = "返回";
                    break;

                default:
                    result = "無效指令";
                    break;
            }

            // 建立每一步的獨立紀錄
            history.add(new MissionStep(command, energy, result));
        }

        String outcome;

        if (samples >= 5) {
            outcome = "任務成功";
        } else if (energy == 0) {
            outcome = "能源耗盡";
        } else if (!running) {
            outcome = "已返回";
        } else {
            outcome = "任務未完成";
        }

        printReplay(history);

        System.out.println("指令次數[0..3]="
                + Arrays.toString(countCommands(history)));

        printSummary(script.length, history);

        System.out.println("最終能源=" + energy
                + ", 樣本數=" + samples
                + ", 行動次數=" + actionCount
                + " -> " + outcome);

        System.out.println("電量百分比="
                + calculateBatteryPercent(energy));
    }

    // 統計指令 0～3 的出現次數
    static int[] countCommands(ArrayList<MissionStep> history) {
        int[] counts = new int[4];

        for (MissionStep step : history) {
            int command = step.getCommand();

            if (command >= 0 && command < counts.length) {
                counts[command]++;
            }
        }

        return counts;
    }

    // 回放任務歷程
    static void printReplay(ArrayList<MissionStep> history) {
        System.out.println("=== 任務回放 ===");

        for (int i = 0; i < history.size(); i++) {
            MissionStep step = history.get(i);

            System.out.println("步驟 " + (i + 1)
                    + ": 指令=" + step.getCommand()
                    + ", 結果=" + step.getResult()
                    + ", 能源=" + step.getEnergy());
        }
    }

    // 輸出任務摘要
    static void printSummary(
            int scriptLength,
            ArrayList<MissionStep> history) {

        int ok = 0;
        int returned = 0;

        for (MissionStep step : history) {
            if (step.isSuccessful()) {
                ok++;
            } else if ("返回".equals(step.getResult())) {
                returned++;
            }
        }

        int steps = history.size();
        int rejected = steps - ok - returned;
        int ignored = scriptLength - steps;

        System.out.println("步數=" + steps
                + ", 成功=" + ok
                + ", 拒絕=" + rejected
                + ", 略過=" + ignored);

        if (history.isEmpty()) {
            System.out.println("最低能源=無紀錄");
        } else {
            int lowest = history.get(0).getEnergy();

            for (MissionStep step : history) {
                if (step.getEnergy() < lowest) {
                    lowest = step.getEnergy();
                }
            }

            System.out.println("最低能源=" + lowest);
        }
    }

    // 計算剩餘電量百分比
    static double calculateBatteryPercent(int energy) {
        return energy / 20.0 * 100;
    }
}
