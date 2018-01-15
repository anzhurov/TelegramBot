import java.text.SimpleDateFormat;
import java.util.Date;

public class BotDate {
    public static String getDate(String string){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(string.equals("today")) {
            return simpleDateFormat.format(date);
        } else {
            return simpleDateFormat.format(new Date(date.getTime() + 24*60*60*1000));
        }
    }
}