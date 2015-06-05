package ir.ac.iust.text.utils;

/**
 * Created by Majid on 04/06/2015.
 */
public class StringColorizer {

    public static String colorize(String text, Color color) {
        StringBuilder builder = new StringBuilder();
        builder.append("\u001B[");// Prefix
        if (color.getBgColorNumber() != null)
            builder.append(color.getColorNumber()).append('m');//foreground
        builder.append(color.isBrightness() ? "1;" : "0;");//Brightness
        builder.append(color.getColorNumber()).append('m');//foreground
        builder.append(text);
        builder.append("\u001b[m ");//Prefix + Suffix to reset color
        return builder.toString();
    }

    public static String colorize(String text, String color, boolean bold) {
        StringBuilder builder = new StringBuilder().append("<span style='color:").append(color).append("'>");
        if (bold) builder.append("<b>");
        builder.append(text);
        if (bold) builder.append("</b>");
        builder.append("</span>");
        return builder.toString();
    }

}
