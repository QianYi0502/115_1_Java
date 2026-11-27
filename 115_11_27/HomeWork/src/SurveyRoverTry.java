
public class SurveyRoverTry {

    public static void main(String[] args) {

        System.out.println("=== 案例一：正常任務 ===");
        test("精細採樣車", new SurveyRover(20, 0),
                new int[]{1, 1, 2});

        System.out.println("=== 案例二：能源剛好足夠 ===");
        test("精細採樣車", new SurveyRover(6, 4),
                new int[]{1, 3});

        System.out.println("=== 案例三：能源不足 ===");
        Rover low = new SurveyRover(5, 0);
        System.out.println(low.execute(1));
        show(low);

        System.out.println("=== 案例四：任務已停止 ===");
        Rover done = new SurveyRover(20, 5);
        System.out.println(done.execute(1));
        show(done);

        System.out.println("=== 案例五：反例與一般車比較 ===");
        test("一般探測車", new Rover(20, 3),
                new int[]{1, 2});

        test("精細採樣車", new SurveyRover(20, 3),
                new int[]{1, 2});
    }

    private static void test(String name, Rover rover,
                             int[] script) {

        Mission mission = new Mission(rover);
        mission.run(script);

        System.out.println(name);
        show(rover);
        System.out.println("已讀步數=" + mission.getStepCount());
        System.out.println("結果=" + mission.getOutcome());
        System.out.println();
    }

    private static void show(Rover rover) {
        System.out.println("能源=" + rover.getEnergy());
        System.out.println("樣本=" + rover.getSamples());
        System.out.println("行動次數=" + rover.getActionCount());
    }
}
