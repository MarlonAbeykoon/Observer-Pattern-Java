/**
 * Chrissy Soulakian
 * ObserverPattern Project
 * Created on 4/17/2016
 */
public interface WeatherSubject {

    public void addObserver(WeatherObserver weatherObserver);

    public void removeObserver(WeatherObserver weatherObserver);

    public void sendNotification();

}
