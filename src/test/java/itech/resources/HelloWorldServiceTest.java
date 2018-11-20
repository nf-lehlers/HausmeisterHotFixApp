package itech.resources;

import itech.helloWorldService.HelloWorld;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HelloWorldServiceTest {

    @Test
    public void stringEqualsHalloWelt() throws Exception {
        assertEquals ("Hallo Welt!", HelloWorld.helloWorldString());
        assertNotEquals("Hallo Universum!", HelloWorld.helloWorldString());
    }
}