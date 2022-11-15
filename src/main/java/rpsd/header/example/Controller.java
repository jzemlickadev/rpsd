package rpsd.header.example;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    @RequestMapping(value = "/headers", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> listAllHeaders(
            @RequestHeader Map<String, String> headers) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("--- Attributes ---\n");
        headers.forEach((key, value) -> {
            buffer.append(key).append(": ").append(value).append("\n");
        });

        return new ResponseEntity<>(buffer.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/sentry", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> sentry(
            @RequestHeader Map<String, String> headers) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("--- Attributes ---\n");
        headers.forEach((key, value) -> buffer.append(key).append(": ").append(value).append("\n"));

        throw new IllegalStateException(buffer.toString());
    }


}
