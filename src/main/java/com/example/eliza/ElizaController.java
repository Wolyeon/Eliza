package com.example.eliza;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElizaController {

    private final ElizaService elizaservice;

    public ElizaController(ElizaService es)
    {
        this.elizaservice = es;
    }

    @GetMapping
    public String getResponse(@RequestBody String sent)
    {
        return this.elizaservice.interpretSentence(sent);
    }
    
}
