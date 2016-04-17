/**
 * Chrissy Soulakian
 * ObserverPattern Project
 * Created on 4/17/2016
 */
public class WeatherCustomer implements WeatherObserver {

    private String name;

    public WeatherCustomer(String name) {
        this.name = name;
    }

    @Override
    public void update(int temp) {
        System.out.println("Weather customer, " + name + ", just received a notification " +
                "that the temperature is now " + temp + " degrees Fahrenheit.");
    }
}
