package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        assertThat(response.getBody(), equalTo("{\r\n  \"dataStreamName\": \"MyDataSource\",\r\n  \"type\": \"derived\",\r\n  \"application\": {\r\n    \"detailsUrl\": \"http://example.com\",\r\n    \"name\": \"Foo Example App\",\r\n    \"version\": \"1\"\r\n  },\r\n  \"dataType\": {\r\n    \"field\": [\r\n      {\r\n        \"name\": \"steps\",\r\n        \"format\": \"integer\"\r\n      }\r\n    ],\r\n    \"name\": \"com.google.step_count.delta\"\r\n  },\r\n  \"device\": {\r\n    \"manufacturer\": \"Example Manufacturer\",\r\n    \"model\": \"ExampleTablet\",\r\n    \"type\": \"tablet\",\r\n    \"uid\": \"1000001\",\r\n    \"version\": \"1\"\r\n  }\r\n}\r\n"));
    }
}
