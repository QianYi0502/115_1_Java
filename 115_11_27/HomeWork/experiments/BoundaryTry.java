public class BoundaryTry {

    public static void main(String[] args) {

        System.out.println("=== 案例一：能源剛好足夠 ===");
        test("一般車", new Rover(6, 2), new int[]{1, 3});
        test("重型車", new HeavyRover(6, 2), new int[]{1, 3});

        System.out.println("\n=== 案例二：能源不足 ===");
        test("一般車", new Rover(5, 0), new int[]{1});
        test("重型車", new HeavyRover(5, 0), new int[]{1});

        System.out.println("\n=== 案例三：反例測試 ===");
        test("一般車", new Rover(20, 4), new int[]{1, 2});
        test("重型車", new HeavyRover(20, 4), new int[]{1, 2});
    }

    private static void test(String name, Rover rover, int[] script) {

        Mission mission = new Mission(rover);
        mission.run(script);

        System.out.println(name);
        System.out.println("能源=" + rover.getEnergy());
        System.out.println("樣本=" + rover.getSamples());
        System.out.println("行動次數=" + rover.getActionCount());
        System.out.println("已讀步數=" + mission.getStepCount());
        System.out.println("結果=" + mission.getOutcome());
        System.out.println();
    }
}