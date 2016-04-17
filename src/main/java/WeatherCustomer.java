/**
 * Chrissy Soulakian
 * ObserverPattern Project
 * Created on 4/17/2016
 *
 * WeatherCustomer is one of two ConcreteObservers that stores the current
 * temperature. It also keeps a reference to the Subject to check the
 * current temperature when a notification is received.
 */
public class WeatherCustomer implements WeatherObserver {

    private String name;
    private WeatherStation station;
    private int currentTemp;

    public WeatherCustomer(String name, WeatherStation station) {
        this.name = name;
        this.station = station;
        this.currentTemp = station.getTemp();
    }

    @Override
    public void update() {
        currentTemp = station.getTemp();
        System.out.println("Weather customer, " + name + ", received a notification. " +
                "The current temperature is " + currentTemp + " degrees Fahrenheit.");
    }
}
