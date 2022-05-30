import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class RoadPerson implements Runnable {

    private Road road;

    public RoadPerson(Road road) {
        this.road = road;
    }

    @Override
    public void run(){
        try {
            while (true) {
                Thread.sleep(2000);
                road.persons++;
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss > ").format(Calendar.getInstance().getTime())
                        + Thread.currentThread().getName() + " count persons = " + road.persons);
                if (road.persons > 4) {
                    road.color = Color.GREEN;
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss > ").format(Calendar.getInstance().getTime())
                            + "Светофор для пешеходов включен. Цвет светофора для пешеходов " + road.colorForPrint());
                    road.persons = 0;
                }
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
