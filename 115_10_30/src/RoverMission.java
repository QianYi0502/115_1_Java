import java.util.Scanner;

public class RoverMission {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int energy = 20;
        int samples = 0;
        int actionCount = 0;
        boolean running = true;

        System.out.println("energy=" + energy + ", samples=" + samples + ", actionCount=" + actionCount);
        while (running && energy > 0 && samples < 5) {
            int command = input.nextInt();
            switch (command) {
                case 0:
                    running = false;
                    break;
                case 1:
                    // D1: 探索
                    if (energy >= 6) {
                        energy -= 6;
                        samples += 2;
                        actionCount++;
                    } else {
                        System.out.println("NOT_ENOUGH_ENERGY");
                    }
                    break;
                case 2:
                    // D2: 掃描
                    if (energy >= 2) {
                        energy -= 2;
                        samples += 1;
                        actionCount++;
                    } else {
                        System.out.println("NOT_ENOUGH_ENERGY");
                    }
                    break;
                case 3:
                    // D3: 充電
                    if (energy < 20) {
                        energy += 5;
                        if (energy > 20) {
                            energy = 20;
                        }
                        actionCount++;
                    } else {
                        System.out.println("FULL_ENERGY");
                    }
                    break;
                default:
                    System.out.println("UNKNOWN_COMMAND");
                    break;
            }
            System.out.println("energy=" + energy + ", samples=" + samples + ", actionCount=" + actionCount);
        }
        if (samples >= 5) {
            System.out.println("SUCCESS");
        } else if (energy == 0) {
            System.out.println("EXHAUSTED");
        } else {
            System.out.println("RETURNED");
        }
        input.close();
    }
}
