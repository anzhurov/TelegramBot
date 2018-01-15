public class WeatherBlock extends Block {
    private String minTemperature;
    private String maxTemperature;
    private String description;

    public WeatherBlock(String minTemperature, String maxTemperature, String description) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.description = description;
    }

    @Override
    public String toString() {
        return minTemperature + "..." + maxTemperature + " " + new WeatherIcons().getIcon() +" " + description;
    }
}
