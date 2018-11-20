package itech.helloWorldService;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by heiko on 15.08.16.
 */
public class HelloWorldJsonExample {

    @JsonProperty
    private String language;

    @JsonProperty
    private String helloWorld;

    public HelloWorldJsonExample () {

    }

    public HelloWorldJsonExample(String language, String helloWorld) {
        this.language = language;
        this.helloWorld = helloWorld;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

}
