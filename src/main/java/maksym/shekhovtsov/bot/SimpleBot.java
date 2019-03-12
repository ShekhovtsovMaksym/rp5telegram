package maksym.shekhovtsov.bot;

import maksym.shekhovtsov.parser.Rp5parser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SimpleBot extends TelegramLongPollingBot
{



  @Override
  public void onUpdateReceived(Update update)
  {

    Rp5parser parser = new Rp5parser();

    if (update.hasMessage() && update.getMessage().hasText()) {

      long chat_id = update.getMessage().getChatId();

      SendMessage message = new SendMessage()
          .setChatId(chat_id)
          .setText(parser.getWay());
      try {
        execute(message);
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public String getBotUsername()
  {
    return "SimpleMaksymBot";
  }

  @Override
  public String getBotToken()
  {
    return "689824969:AAGYbGwztJUh0Vwu1rAbyHdMNy45mHndicI";
  }
}
