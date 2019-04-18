package main.java.com.example.joy.controller;

import com.example.joy.model.Message;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @GetMapping("/message")
    Message send(){
        return new Message("first message");
    }

    @PostMapping("/message")
    Message echo(@RequestBody Message message){
        return message;
    }
}
