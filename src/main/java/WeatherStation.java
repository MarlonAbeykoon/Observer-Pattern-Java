import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Chrissy Soulakian
 * ObserverPattern Project
 * Created on 4/17/2016
 */
public class WeatherStation implements WeatherSubject {

    Set<WeatherObserver> setOfWeatherObservers;
    int temp;
    String name;

    public WeatherStation(String name, int temperature) {
        setOfWeatherObservers = new HashSet<>();
        this.temp = temperature;
        this.name = name;
    }

    @Override
    public void addObserver(WeatherObserver weatherObserver) {
        setOfWeatherObservers.add(weatherObserver);
    }

    @Override
    public void removeObserver(WeatherObserver weatherObserver) {
        setOfWeatherObservers.remove(weatherObserver);
    }

    @Override
    public void sendNotification() {
        for(WeatherObserver observer : setOfWeatherObservers) {
            observer.update(temp);
        }
    }

    public void setTemp(int newTemperature) {
        System.out.println("\nWeather Station " + name + " is setting the temperature to " + newTemperature + ".");
        temp = newTemperature;
        sendNotification();
    }
}
