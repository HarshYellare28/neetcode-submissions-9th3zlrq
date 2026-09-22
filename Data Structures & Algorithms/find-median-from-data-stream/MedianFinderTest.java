public class MedianFinderTest {
    public static void main(String[] args) {
        String[] ops = {
            "MedianFinder",
            "addNum",
            "addNum",
            "findMedian",
            "addNum",
            "findMedian",
            "addNum",
            "addNum",
            "findMedian",
            "addNum",
            "findMedian"
        };
        Integer[] argsList = {null, 2, 3, null, 4, null, 1, 8, null, 5, null};
        Object[] expected = {null, null, null, 2.5, null, 3.0, null, null, 3.0, null, 3.5};

        MedianFinder mf = null;
        Object[] actual = new Object[ops.length];
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "MedianFinder":
                    mf = new MedianFinder();
                    actual[i] = null;
                    break;
                case "addNum":
                    mf.addNum(argsList[i]);
                    actual[i] = null;
                    break;
                case "findMedian":
                    actual[i] = mf.findMedian();
                    break;
                default:
                    throw new IllegalArgumentException(ops[i]);
            }
        }

        System.out.println("ops:  [\"MedianFinder\",\"addNum\",\"addNum\",\"findMedian\",\"addNum\",\"findMedian\",\"addNum\",\"addNum\",\"findMedian\",\"addNum\",\"findMedian\"]");
        System.out.println("args: [[],[2],[3],[],[4],[],[1],[8],[],[5],[]]");
        System.out.print("out:  [");
        for (int i = 0; i < actual.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(format(actual[i]));
        }
        System.out.println("]");

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] == null) {
                continue;
            }
            double want = (Double) expected[i];
            double got = (Double) actual[i];
            if (Double.compare(want, got) != 0) {
                throw new AssertionError("index " + i + " expected " + want + " got " + got);
            }
        }
        System.out.println("PASS");
    }

    private static String format(Object v) {
        if (v == null) {
            return "null";
        }
        double d = (Double) v;
        if (d == Math.rint(d)) {
            return String.format("%.1f", d);
        }
        return Double.toString(d);
    }
}
