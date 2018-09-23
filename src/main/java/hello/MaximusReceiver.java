package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaximusReceiver {
    @Autowired
    private SimpMessagingTemplate template;

    @PostMapping("/message")
    @SendTo("/topic/auto-loan")
    public Message messageFromMaximus(@RequestBody Message message) throws Exception {
        template.convertAndSend("/topic/auto-loan", message);
        return message;
    }
}
