package org.example.controllers;




import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class PingController {
    @RequestMapping("/ping")
    public String ping() {
        return "OK";
    }
}
