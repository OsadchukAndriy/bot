package org.bot;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class MyTelegramBot extends TelegramLongPollingBot {

    public MyTelegramBot() {
    }

    @Override
    public String getBotUsername() {
        return "Dsa_fghj_dfgg_bot";
    }

    @Override
    public String getBotToken() {
        return "6831425151:AAFW3KPLVHD5rrQ16Pn0zcjtSQLGCBVU7Hg";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("Received update: " + update);

        // Отримуємо текст повідомлення від користувача
        String messageText = update.getMessage().getText();

        // Обробляємо команди в залежності від тексту повідомлення
        if ("/start".equals(messageText)) {
            sendStartMessage(update.getMessage().getChatId());
        } else if ("/help".equals(messageText)) {
            sendHelpMessage(update.getMessage().getChatId());
        }
        // Додайте інші обробники команд за необхідності
    }

    private void sendStartMessage(Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("Вітаю в мому боті, чим допомогти?");

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendHelpMessage(Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("This is a help message. How can I assist you?");

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}