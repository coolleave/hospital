package com.kd.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@RestController
public class AIDeepSeekController {

    private static final Logger logger = LoggerFactory.getLogger(AIDeepSeekController.class);

    private final RestTemplate restTemplate = new RestTemplate(); // 直接实例化
    @CrossOrigin(origins = "http://localhost:80") // 允许来自这个地址的请求


    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody Map<String, Object> requestMap) {
        String userMessage = (String) requestMap.get("userMessage");

        // 创建请求体
        Map<String, Object> requestBody = new HashMap<>();
        Map<String, String> systemMessage = new HashMap<>();
        systemMessage.put("role", "system");
        systemMessage.put("content", "你是一个数据分析师，根据用户的数据简单分析身体状况如何，原始数据尽量减少引用，重点说出评价就行，但是评价不需要太长几句话就行");
        Map<String, String> userMessageMap = new HashMap<>();
        userMessageMap.put("role", "user");
        userMessageMap.put("content", userMessage);
        requestBody.put("messages", new Object[]{systemMessage, userMessageMap});
        requestBody.put("model", "deepseek-chat");
        requestBody.put("stream", false);

        // 打印请求体以供调试
        logger.info("Request Body: {}", requestBody);

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer sk-26f3ac84846a497aa17dccd61097cf64");

        // 创建HttpEntity对象
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            // 发送POST请求
            ResponseEntity<String> response = restTemplate.exchange(
                    "https://api.deepseek.com/chat/completions",
                    HttpMethod.POST,
                    entity,
                    String.class
            );

            // 打印响应状态码和响应体以供调试
            logger.info("Response Status Code: {}", response.getStatusCode());
            logger.info("Response Body: {}", response.getBody());

            return response;
        } catch (Exception e) {
            logger.error("Error occurred while calling DeepSeek API", e);
            return new ResponseEntity<>("Error occurred while processing your request.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}