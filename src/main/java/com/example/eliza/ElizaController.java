package com.example.eliza;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class ElizaController {

    private final ElizaService elizaservice;

    public ElizaController(ElizaService es)
    {
        this.elizaservice = es;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public String getResponse(@RequestBody String userMessage)
    {
        String resp = this.elizaservice.interpretSentence(userMessage);
        System.out.println(userMessage + " " + resp);
        return resp;
    }
    
}
