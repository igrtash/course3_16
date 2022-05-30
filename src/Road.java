import java.awt.Color;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Road {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    int persons; // кол-во пешеходов
    int cars; // кол-во машин
    Color color; // светофор для пешеходов

    public Road() {
        this.color = Color.YELLOW;
    }

    public static String colorName(Color c) {
        for (Field f : Color.class.getDeclaredFields()) {
            //we want to test only fields of type Color
            if (f.getType().equals(Color.class))
                try {
                    if (f.get(null).equals(c))
                        return f.getName().toLowerCase();
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    // shouldn't not be thrown, but just in case print its stacktrace
                    e.printStackTrace();
                }
        }
        return "";
    }

    public String colorForPrint() {
        return (color == Color.RED ? ANSI_RED + colorName(color) + ANSI_RESET :
                    (color == Color.YELLOW ? ANSI_YELLOW + colorName(color) + ANSI_RESET :
                            (color == Color.GREEN ? ANSI_GREEN + colorName(color) + ANSI_RESET :
                                    colorName(color)
                            )
                    )
               );
    }

    public void print() {
        System.out.println(
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss > ").format(Calendar.getInstance().getTime()) +
            "Road{" +
                    "persons=" + persons +
                    ", cars=" + cars +
                    ", color=" + colorForPrint() +
                    '}');
    }

    @Override
    public String toString() {
        return "Road{" +
                "persons=" + persons +
                ", cars=" + cars +
                ", color=" + colorName(color) +
                '}';
    }
}
