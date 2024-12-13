import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String text = "maks@gmail.com ghjbnd rfr ltkf \n" +
                "nick@yandex.ru sjvnj skdfjvj weurhf jaljhfdvh";

        Pattern email = Pattern.compile("(\\w+)@(gmail|yandex)\\.(com|ru)");
        Matcher matcher = email.matcher(text);

        while(matcher.find())
            System.out.println(matcher.group(2));
    }
}
