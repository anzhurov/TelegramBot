import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WeatherGetter {
    private final String urlToday = "https://sinoptik.ua/%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0-%D1%85%D0%B0%D1%80%D1%8C%D0%BA%D0%BE%D0%B2/" + BotDate.getDate("today");
    private final String urlTomorrow = "https://sinoptik.ua/%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0-%D1%85%D0%B0%D1%80%D1%8C%D0%BA%D0%BE%D0%B2/"  + BotDate.getDate("tomorrow");

    public Block getWeather(String day) {
        Document documentToday = null;
        Document documentTomorrow = null;
        try {
            documentToday = Jsoup.connect(urlToday).get();
            documentTomorrow = Jsoup.connect(urlTomorrow).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements temperature = documentTomorrow.getElementsByClass("temperature");
        Elements currentTemperatureToday = documentToday.getElementsByClass("today-temp");
        Elements descriptionsToday = documentToday.getElementsByClass("description");
        Elements descriptionTomorrow = documentTomorrow.getElementsByClass("description");

        if (day.equals("today")){
            return new WeatherBlock(temperature.get(0).child(0).text().replaceAll("мин.",""), temperature.get(0).child(1).text().replaceAll("макс.",""), descriptionsToday.get(0).text());
        } else if (day.equals("tomorrow")){
            return new WeatherBlock(temperature.get(1).child(0).text().replaceAll("мин.",""), temperature.get(1).child(1).text().replaceAll("макс.",""), descriptionTomorrow.get(0).text());
        } else if (day.equals("now")) {
            return new WeatherBlockNow(currentTemperatureToday.get(0).text());
        }
        return null;
    }
}
