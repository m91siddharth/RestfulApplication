package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "{\r\n  \"dataStreamName\": \"MyDataSource\",\r\n  \"type\": \"derived\",\r\n  \"application\": {\r\n    \"detailsUrl\": \"http://example.com\",\r\n    \"name\": \"Foo Example App\",\r\n    \"version\": \"1\"\r\n  },\r\n  \"dataType\": {\r\n    \"field\": [\r\n      {\r\n        \"name\": \"steps\",\r\n        \"format\": \"integer\"\r\n      }\r\n    ],\r\n    \"name\": \"com.google.step_count.delta\"\r\n  },\r\n  \"device\": {\r\n    \"manufacturer\": \"Example Manufacturer\",\r\n    \"model\": \"ExampleTablet\",\r\n    \"type\": \"tablet\",\r\n    \"uid\": \"1000001\",\r\n    \"version\": \"1\"\r\n  }\r\n}\r\n";
    }
    
}
