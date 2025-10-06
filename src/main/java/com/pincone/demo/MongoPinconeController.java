package com.pincone.demo;


import com.pincone.demo.setup.MongoToPinconeETL;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class MongoPinconeController {
    private final MongoToPinconeETL mongoToPinconeETL;
    @GetMapping("/load")
    public void load(){
        mongoToPinconeETL.dump();
    }

}
