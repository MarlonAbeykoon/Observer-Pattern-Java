/**
 * Chrissy Soulakian
 * ObserverPattern Project
 * Created on 4/17/2016
 */
public class TVStation implements WeatherObserver {

    private String name;

    public TVStation(String name) {
        this.name = name;
    }

    @Override
    public void update(int temp) {
        System.out.println("TV Station, " + name + ", just received a notification " +
                "that the temperature is now " + temp + " degrees Fahrenheit.");
    }
}
