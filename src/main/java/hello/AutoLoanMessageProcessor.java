package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class AutoLoanMessageProcessor {


    @MessageMapping("/hello")
    @SendTo("/topic/auto-loan")
    public Message newMessage(Message message) throws Exception {
        System.out.println(message.getName());
        Thread.sleep(1000); // simulated delay
        return message;
    }
}

