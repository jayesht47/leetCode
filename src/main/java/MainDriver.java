import stack.CarFleet;
import stack.DailyTemperature;

public class MainDriver {

    public static void main(String[] args) {

        CarFleet carFleet = new CarFleet();

        int target = 10;
        int[] position = {8, 6};
        int[] speed = {2, 3};

        System.out.println(carFleet.carFleet(target, position, speed));


    }
}
