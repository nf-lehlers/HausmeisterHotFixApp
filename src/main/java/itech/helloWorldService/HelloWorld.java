package itech.helloWorldService;

/**
 * Created by heiko on 14.08.16.
 */
public class HelloWorld {

    public static String helloWorldString(){
        return "Hallo Welt!";
    }

    public static String helloWorldStringAdvanced (String name, Gender gender) {
        String salutation;
        if (gender.equals(Gender.FEMALE)) {
            salutation = "liebe";
        } else {salutation = "lieber";}

        return "Hallo Welt! " + "Hallo " + salutation + " " + name + "!"; }
}
