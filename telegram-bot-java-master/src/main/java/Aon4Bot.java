import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Aon4Bot extends TelegramLongPollingBot {


        public void onUpdateReceived(Update update) {

//            System.out.println(update.getMessage().getText());
//            System.out.println(update.getMessage().getFrom().getFirstName() );

            String command=update.getMessage().getText();
            
            String FN = update.getMessage().getFrom().getFirstName();
            
            String LN = update.getMessage().getFrom().getLastName();
            
             if((update.getMessage().getFrom().getLastName())==null){
                   LN="You don't have last name";  
             }
            if((update.getMessage().getFrom().getFirstName())==null){
                   FN="You don't have first name";  
             }
                        
            SendMessage message = new SendMessage();

            if(command.equals("/myname")){

                System.out.println(FN);

                message.setText(FN);
            }

            if (command.equals("/mylastname")){

                System.out.println(LN);
                message.setText(LN);
            }

            if (command.equals("/myfullname")){
                System.out.println(FN+" "+LN);
                if ("You don't have last name".equals(LN)) {
                    message.setText(FN);
                } else message.setText(FN+" "+LN);
                
            }
            
            if (command.equals("/fuckyou")){

                System.out.println("Îx§A");
                message.setText("Îx§A");
            }

            System.out.println(update.getMessage().getChatId());
            
            message.setChatId(update.getMessage().getChatId());
            
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


        }

        public String getBotUsername() {
            return "Aon4Bot";
        }
        
             
        public String getBotToken() {
            return "1746105916:AAEp_gGqEHtCFcjoGuI9Ya_U9fDTOJNxyBY";
        }
    }
