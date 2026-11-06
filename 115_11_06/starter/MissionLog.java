
import java.util.ArrayList;

public class MissionLog {

    public static void main(String[] args) {

        int energy = 20;
        int samples = 0;
        int actionCount = 0;

        int[] script = {3, 9, 0};

        ArrayList<MissionStep> history = new ArrayList<>();

        int[] counts = new int[10];

        int lowestEnergy = energy;
        String outcome = "SUCCESS";

        for (int command : script) {

            String result;

            switch (command) {

                case 1:
                    if (energy >= 6) {
                        energy -= 6;
                        samples += 2;
                        actionCount++;
                        result = "OK";
                    } else {
                        result = "REJECTED";
                    }
                    break;

                case 2:
                    if (energy >= 2) {
                        energy -= 2;
                        samples += 1;
                        actionCount++;
                        result = "OK";
                    } else {
                        result = "REJECTED";
                    }
                    break;

                case 3:
                    if (energy < 20) {
                        energy += 5;
                        if (energy > 20) {
                            energy = 20;
                        }
                        actionCount++;
                        result = "OK";
                    } else {
                        result = "ALREADY_FULL";
                    }
                    break;

                case 0:
                    result = "RETURN";
                    break;

                default:
                    result = "UNKNOWN_COMMAND";
                    break;
            }

            // TODO 4：建立任務紀錄並加入歷程
            history.add(new MissionStep(command, energy, result));

            if (result.equals("OK")) {
                counts[0]++;
            } else if (result.equals("REJECTED")) {
                counts[1]++;
            } else if (result.equals("UNKNOWN_COMMAND")) {
                counts[2]++;
            } else if (result.equals("RETURN")) {
                counts[3]++;
            } else if (result.equals("ALREADY_FULL")) {
                counts[4]++;
            }

            if (energy < lowestEnergy) {
                lowestEnergy = energy;
            }

            if (result.equals("RETURN")) {
                outcome = "RETURNED";
                break;
            }
        }

        // TODO 5：依照順序回放每一步任務紀錄
        System.out.println("=== Replay ===");

        for (int i = 0; i < history.size(); i++) {
            MissionStep step = history.get(i);

            int command = step.getCommand();
            int stepEnergy = step.getEnergy();
            String result = step.getResult();

            System.out.println("step " + (i + 1) + ": command=" + command
                    + ", result=" + result + ", energy=" + stepEnergy);
        }

        // TODO 6：統計成功與返回次數
        int ok = 0;
        int rejected = 0;
        int returned = 0;

        for (MissionStep step : history) {
            if (step.isSuccessful()) {
                ok++;
            }

            if ("RETURN".equals(step.getResult())) {
                returned++;
            }
        }

        rejected = history.size() - ok - returned;

        int ignored = script.length - history.size();

        System.out.println("=== Summary ===");
        System.out.println("steps=" + history.size());
        System.out.println("ok=" + ok);
        System.out.println("rejected=" + rejected);
        System.out.println("returned=" + returned);
        System.out.println("ignored=" + ignored);
        System.out.println("lowestEnergy=" + lowestEnergy);

        System.out.println("=== Final Status ===");
        System.out.println("energy=" + energy);
        System.out.println("samples=" + samples);
        System.out.println("actionCount=" + actionCount);
        System.out.println("outcome=" + outcome);

        double battery = energy / 20.0 * 100;
        System.out.println("battery=" + battery);
    }
}
