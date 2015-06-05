package ir.ac.iust.text.utils;

/**
 * Created by Majid on 04/06/2015.
 */
public enum Color {
    red(31, false, null), green(32, false, null), yellow(33, false, null),
    blue(34, false, null), purple(35, false, null), cyan(36, false, null),
    white(37, false, null), whiteOnBlack(37, false, 43), black(30, false, null);

    private int colorNumber;
    private Integer bgColorNumber;
    private boolean brightness;

    Color(int colorNumber, boolean brightness, Integer bgColorNumber) {
        this.colorNumber = colorNumber;
        this.brightness = brightness;
        this.bgColorNumber = bgColorNumber;
    }

    public void setBlackBackgroundColor() {
        bgColorNumber = 43;
    }

    public void setBold() {
        brightness = true;
    }

    public int getColorNumber() {
        return colorNumber;
    }

    public Integer getBgColorNumber() {
        return bgColorNumber;
    }

    public boolean isBrightness() {
        return brightness;
    }
}
