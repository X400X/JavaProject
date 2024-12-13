public class Test {
    public static void main(String[] args) {
        /*
        \\d - одна цифра
        \\w - одна английская буква

        \\d+ - одна или более цифр
        \\d* - ноль или более цифр
        -\\d*
        &
        ? - ноль или 1 символов символов до
        -?//d* - и отрицательные и положительные без знака +
        (-|\\+)?\\d* - для строк с числами со знаком +- и без знака

        [a-zA-Z] - все английские буквы
        [0-9] == \\d
        [^abc] - все кроме abc
        . - любой символ

        {2} - два символов (\\d{2})
        {2, } - ОТ 2 и более символов (\\d{2, })
        {2,4} - от 2 до 4 символов (\\d{2,4})

         */

        String a = "1";
        String b = "-12698544";
        String c = "+12698544";
        System.out.println(a.matches("\\d+"));
//        System.out.println(b.matches("(-|\\+)?\\d*"));
//        System.out.println(c.matches("(-|\\+)?\\d*"));

        String d = "g21484956";
        //System.out.println(d.matches("[a-zA-Z]?\\d*"));

        String e = "asdsf";
        //System.out.println(e.matches("[^abc]*"));

        String url = "http://www.google.com";
        //System.out.println(url.matches("http://www\\..+\\.(com|ru)"));

        String as = "45";
        //System.out.println(as.matches("\\d{2,4}"));
    }
}
