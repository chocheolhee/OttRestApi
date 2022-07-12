package ott.cheol.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
public class RestApiController {

    @GetMapping("/api/addParty")
    public String addParty() {

        return "안녕하세요. 현재 서버시간은 " + new Date() + "입니다.! \n";
    }
}
