package com.example.pj2be.controller.websocketcontroller;

import com.example.pj2be.domain.socket.ChatDTO;
import com.example.pj2be.domain.socket.Greeting;
import com.example.pj2be.domain.socket.HelloMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class WebSocketController {

//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public ChatDTO greeting(ChatDTO chatDTO) throws Exception {
//        System.out.println("소켓테스트확인됨");
//        System.out.println(chatDTO);
//        System.out.println("아이디: " + chatDTO.getId());
//        System.out.println("내용: " + chatDTO.getChat());
//
//        return chatDTO;
//    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ChatDTO greeting(ChatDTO chatDTO) throws Exception {
        System.out.println("소켓테스트확인됨");
        System.out.println(chatDTO);
        System.out.println("아이디: " + chatDTO.getId());
        System.out.println("내용: " + chatDTO.getChat());

        return chatDTO;
    }



}
