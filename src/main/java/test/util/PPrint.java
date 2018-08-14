package test.util;

import java.util.Arrays;
import java.util.Collection;

public class PPrint {

    public static String pform(Collection<?> c) {
        if (c.size() == 0) return "[]";
        StringBuilder result = new StringBuilder("[");
        for (Object elem : c) {
            if (c.size() != 1) {
                result.append("\n ");
            }
            result.append(elem);
        }
        if (c.size() != 1) {
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }

    public static void pprint(Collection<?> c) {
        System.out.println(pform(c));
    }

    public static void pprint(Object[] c) {
        System.out.println(pform(Arrays.asList(c)));
    }
}
