package dev.iuhoay.webserver.undertow;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UpController {
    @GetMapping("/up")
    public String up() {
        log.info("up has been called");
        return "up";
    }
}
