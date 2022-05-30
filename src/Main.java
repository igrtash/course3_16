/** Урок 14 - Многопоточность
 * Практическое упражнение №16
 * Создать программу используя полученные знания о многопоточности:
 * Есть класс Road с полями: int person, int cars.
 * Данный класс работает с 2 потоками.
 * Если количество человек на дороге больше 4, то в консоль выводится сообщение (Светофор для пешеходов включен).
 * Если количество машин на дороге больше 3, то в консоль выводится сообщение (Светофор для машин включен).
 * И после переключения светофора счётчик людей или машин сбрасываются на 0.
 * Люди приходят на переход каждые 2 секунды sleep(2000), а машины каждые 5 секунд sleep(5000).
 * Программа работает 30 секунд
 */
public class Main {
    public static void main(String[] args) {
        Road road = new Road();
        road.print();

        Thread thread1 = new Thread(new RoadPerson(road), "Thread-Persons");
        Thread thread2 = new Thread(new RoadCar(road), "Thread-Cars");

        try {
            thread1.start();
            thread2.start();

            Thread.sleep(30000);
            road.print();
            System.exit(0);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}

