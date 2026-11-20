
public class CargoRover extends Rover {

    private int cargo;

    public CargoRover(int energy, int samples) {
        super(energy, samples);
        cargo = 0;
    }

    public int getCargo() {
        return cargo;
    }

    public String load(int amount) {
        if (isStopped()) {
            return "任務已停止";
        }

        if (amount <= 0 || amount > 3 - cargo) {
            return "已拒絕";
        }

        cargo += amount;
        return "成功";
    }
}
