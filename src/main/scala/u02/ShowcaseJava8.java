package u02;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class ShowcaseJava8 {

    public static void main(String[] args) {
        // using a 'lambda function' to express a functional strategy
        final Comparator<Integer> comparator = (a, b) -> a - b;
        final Set<Integer> set = new TreeSet<>(comparator);
        set.addAll(Arrays.asList(10, 20, 30, 40, 5, 6, 7, 60, 70));
        System.out.println(set);

        // declaratively working with streams: note str is an 'infinite' sequence!
        final Random random = new Random();
        final Stream<Integer> str = Stream.generate(() -> random.nextInt(6))
                                          .map(i -> i + 1);
        System.out.println(str.limit(20).collect(toList()));

        // simulating large-scale data processing with parallel streams
        final List<Double> l = IntStream.range(0, 10000000)
                .mapToObj(x -> Math.random())
                .collect(toList());
        // sequential
        long time = System.currentTimeMillis();
        System.out.println(l.stream().reduce((a,b)->Math.max(a,b)));
        time = System.currentTimeMillis() - time;
        System.out.println("Time: " + time);
        // parallel
        long time2 = System.currentTimeMillis();
        System.out.println(l.stream().parallel().reduce((a,b)->Math.max(a,b)));
        time2 = System.currentTimeMillis() - time2;
        System.out.println("Time2: " + time2);
        System.out.println("Gain: " + (((double)time)/time2));
    }
}
