import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String a = "Hello there hey";
        String[] list = a.split(" ");
        System.out.println(Arrays.toString(list));

        String b = "Hello there hey";
        System.out.println(b.replace(" ", "."));
    }
}
