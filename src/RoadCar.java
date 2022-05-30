import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RoadCar implements Runnable {

    private Road road;

    public RoadCar(Road road) {
        this.road = road;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(5000);
                road.cars++;
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss > ").format(Calendar.getInstance().getTime())
                        + Thread.currentThread().getName() + " count cars = " + road.cars);
                if (road.persons > 3) {
                    road.color = Color.RED;
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss > ").format(Calendar.getInstance().getTime())
                            + "Светофор для машин включен. Цвет светофора для пешеходов " + road.colorForPrint());
                    road.cars = 0;
                }
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}
