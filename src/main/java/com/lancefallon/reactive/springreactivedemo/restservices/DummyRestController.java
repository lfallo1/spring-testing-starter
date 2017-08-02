package com.lancefallon.reactive.springreactivedemo.restservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dummy")
public class DummyRestController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Map<String, String>> getDummy() {
        Map<String, String> stuff = new HashMap<>();
        stuff.put("1", "Test1");
        stuff.put("2", "Tes2");
        stuff.put("3", "Tes3");
        return new ResponseEntity<>(stuff, HttpStatus.OK);
    }

}
