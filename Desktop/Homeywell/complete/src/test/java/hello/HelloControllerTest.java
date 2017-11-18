package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\r\n  \"dataStreamName\": \"MyDataSource\",\r\n  \"type\": \"derived\",\r\n  \"application\": {\r\n    \"detailsUrl\": \"http://example.com\",\r\n    \"name\": \"Foo Example App\",\r\n    \"version\": \"1\"\r\n  },\r\n  \"dataType\": {\r\n    \"field\": [\r\n      {\r\n        \"name\": \"steps\",\r\n        \"format\": \"integer\"\r\n      }\r\n    ],\r\n    \"name\": \"com.google.step_count.delta\"\r\n  },\r\n  \"device\": {\r\n    \"manufacturer\": \"Example Manufacturer\",\r\n    \"model\": \"ExampleTablet\",\r\n    \"type\": \"tablet\",\r\n    \"uid\": \"1000001\",\r\n    \"version\": \"1\"\r\n  }\r\n}\r\n")));
    }
}
