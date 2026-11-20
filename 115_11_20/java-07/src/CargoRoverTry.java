
public class CargoRoverTry {
    public static void main(String[] args) {
        CargoRover rover = new CargoRover(20, 0);

        System.out.println(rover.load(2) + "/" + rover.getCargo());
        System.out.println(rover.load(2) + "/" + rover.getCargo());
        System.out.println(rover.load(1) + "/" + rover.getCargo());
        System.out.println(rover.load(0) + "/" + rover.getCargo());

        System.out.println(rover.getEnergy() + "/"
                + rover.getSamples() + "/"
                + rover.getActionCount());

        CargoRover noEnergy = new CargoRover(0, 0);
        System.out.println(noEnergy.load(1) + "/" + noEnergy.getCargo());

        CargoRover fullSamples = new CargoRover(20, 5);
        System.out.println(fullSamples.load(1) + "/" + fullSamples.getCargo());

        // 額外邊界測試：負數裝載
        System.out.println(rover.load(-1) + "/" + rover.getCargo());
    }
}
