package maksym.shekhovtsov;

import maksym.shekhovtsov.bot.SimpleBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MainApp {

    public static void main(String... args) throws Exception {
      // Initialize Api Context
      ApiContextInitializer.init();

      // Instantiate Telegram Bots API
      TelegramBotsApi botsApi = new TelegramBotsApi();

      // Register our bot
      try {
        botsApi.registerBot(new SimpleBot());
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }

}

