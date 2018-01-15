public class WeatherBlockNow extends Block {
    private String currentTemperature;


    public WeatherBlockNow(String currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    @Override
    public String toString() {
        return "Сейчас в нашем прекрасном городе Харьков " + currentTemperature + " " + new WeatherIcons().getIcon();
    }
}
