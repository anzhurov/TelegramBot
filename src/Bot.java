import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        WeatherGetter weatherGetter = new WeatherGetter();
        if (message != null && message.hasText()) {
            if (message.getText().equals("/today") || message.getText().equals("/today" + getBotUsername()) ){
                sndMsg(message, weatherGetter.getWeather("today").toString());
            }
            if (message.getText().equals("/tomorrow") || message.getText().equals("/tomorrow" + getBotUsername())){
                sndMsg(message, weatherGetter.getWeather("tomorrow").toString());
            }
            if (message.getText().equals("/now") || message.getText().equals("/now" + getBotUsername())){
                sndMsg(message, weatherGetter.getWeather("now").toString());
            }
        }
    }

    private void sndMsg(Message message, String s){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getBotToken() {
        return "455638009:AAGKipY-HDhVn4KJrbJARm1zswtcGV-PcpY";
    }

    @Override
    public String getBotUsername() {
        return "@KharkovWeatherBratishka_bot";
    }
}
