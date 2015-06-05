package ir.ac.iust.text.utils;

import java.util.Collection;
import java.util.List;

/**
 * Created by Majid on 04/06/2015.
 */
public class ListUtils {

    public static void removeLastElement(List list) {
        if (!list.isEmpty()) list.remove(list.size() - 1);
    }

    public static <T> T lastElement(List<T> list) {
        if (list.isEmpty()) return null;
        return list.get(list.size() - 1);
    }

    public static String[] array(String... input) {
        return input;
    }

    public static String join(Object... objects) {
        return joinByDelim(" ", objects);
    }

    public static String joinByDelim(String delim, Object... objects) {
        StringBuilder builder = new StringBuilder();
        for (Object object : objects) builder.append(object).append(delim);
        if (builder.length() > 0) builder.setLength(builder.length() - 1);
        return builder.toString();
    }

    public static String join(Collection objects) {
        return joinByDelim(" ", objects);
    }

    public static String joinByDelim(String delim, Collection objects) {
        StringBuilder builder = new StringBuilder();
        for (Object object : objects) builder.append(object).append(delim);
        if (builder.length() > 0) builder.setLength(builder.length() - 1);
        return builder.toString();
    }
}
