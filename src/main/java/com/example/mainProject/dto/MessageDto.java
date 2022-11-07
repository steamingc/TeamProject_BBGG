package com.example.mainProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Getter
@AllArgsConstructor
public class MessageDto {

    private String message;
    private String redirectUrl;
    private RequestMethod method;
    private Map<String, Object> data;
}
