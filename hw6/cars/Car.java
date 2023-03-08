public class Car {
    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
    }

    private void startElectricity() {
        System.out.println("Запуск електрики");
    }

    private void startCommand() {
        System.out.println("Натиск кнопки запуску");
    }

    private void startFuelSystem() {
        System.out.println("Запуск паливної системи");
    }
}