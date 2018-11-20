package itech.helloWorldService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by heiko on 15.08.16.
 */
public class HelloWorldJsonExampleTest {


    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final HelloWorldJsonExample helloWorldJsonExample = new HelloWorldJsonExample("Deutsch", "Hallo Welt!");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/HelloWorldJsonExample.json"), HelloWorldJsonExample.class));

        assertThat(MAPPER.writeValueAsString(helloWorldJsonExample)).isEqualTo(expected);
    }

}