import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();

        fillArr(arr);
        fillList(list);

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

//        for (int i = 0; i < 10; i++) {
//            arr[i] = arr[i] * 2;
//            list.set(i, list.get(i) * 2);
//        }



        arr = Arrays.stream(arr).map(a -> a * 2).toArray();
        list = list.stream().map(a -> a * 2).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

        //filter

        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillList(list2);
        fillArr(arr2);

        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println(list2);
        System.out.println(Arrays.toString(arr2));

        Arrays.stream(arr2).forEach(a -> System.out.println(a));
        list2.stream().forEach(a -> System.out.println(a));

        int[] arr3 = new int[10];
        fillArr(arr3);
        List<Integer> list3 = new ArrayList<>();
        fillList(list3);

        int sum1 = Arrays.stream(arr3).reduce((a, b) -> a + b).getAsInt();
        int sum2 = list3.stream().reduce((a, b) -> a * b).get();

        System.out.println(sum1);
        System.out.println(sum2);

        int[] arr4 = new int[10];
        fillArr(arr4);

        arr4 = Arrays.stream(arr4).filter(a -> a % 2 != 0).map(a -> a * 2).toArray();
        System.out.println(Arrays.toString(arr4));

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        System.out.println(set);

        set = set.stream().map(a -> a * 3).collect(Collectors.toSet());
        System.out.println(set);

    }

    private static void fillList(List<Integer> list) {
        for(int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    private static void fillArr(int[] arr) {
        for(int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }
}
