package ir.ac.iust.text.utils;

import edu.stanford.nlp.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Majid on 30/05/2015.
 */
public class ColumnedLine {
    protected String text;
    protected int number;
    protected String[] columns;
    protected boolean isEmpty;

    public ColumnedLine() {
    }

    public ColumnedLine(String text) {
        setText(text);
    }

    public ColumnedLine(int number, String text) {
        setText(text);
        this.number = number;
    }

    public static List<ColumnedLine> getLines(Path path) throws IOException {
        return processLines(Files.readAllLines(path), "\t");
    }

    public static List<ColumnedLine> getLines(Path path, String splitter) throws IOException {
        return processLines(Files.readAllLines(path), splitter);
    }

    public static List<ColumnedLine> processLines(List<String> lines, String delim) {
        List<ColumnedLine> list = new ArrayList<>();
        int lineNumber = 0;
        for (String lineString : lines) {
            ColumnedLine columnedLine = new ColumnedLine();
            columnedLine.setText(lineString, delim);
            columnedLine.setLineNumber(lineNumber);
            list.add(columnedLine);
        }
        return list;
    }

    public void setText(String text, String delim) {
        this.text = text;
        if (text.trim().length() == 0) {
            isEmpty = true;
            columns = new String[0];
        } else
            this.columns = text.split(delim);
    }

    public void addSplit(Object newSplit) {
        text = text + "\t" + newSplit;
        columns = Arrays.copyOf(columns, columns.length + 1);
        columns[columns.length - 1] = newSplit.toString();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        setText(text, "\t");
    }

    public int getNumber() {
        return number;
    }

    public int getNumberOfColumns() {
        return columns.length;
    }

    public String column(int position) {
        return columns[position];
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setColumn(int position, int value) {
        columns[position] = String.valueOf(value);
        text = StringUtils.join(columns, "\t");
    }

    public void setColumn(int position, String value) {
        columns[position] = value;
        text = StringUtils.join(columns, "\t");
    }

    public int getColumnAsInt(int position) {
        return Integer.parseInt(columns[position]);
    }

    @Override
    public String toString() {
        if (columns == null || columns.length == 0) return "";
        return StringUtils.join(columns, "\t");
    }

    public String toString(int replaceIndex, String replace) {
        String old = columns[replaceIndex];
        columns[replaceIndex] = replace;
        String toReturn = StringUtils.join(columns, "\t");
        columns[replaceIndex] = old;
        return toReturn;
    }

    public ColumnedLine copy() {
        return new ColumnedLine(number, text);
    }

    public ColumnedLine copy(int position, int value) {
        ColumnedLine line = new ColumnedLine(number, text);
        line.setColumn(position, value);
        return line;
    }

    public ColumnedLine copy(int position, String value) {
        ColumnedLine line = new ColumnedLine(number, text);
        columns[position] = value;
        text = StringUtils.join(columns, "\t");
        return line;
    }

    public void setLineNumber(int lineNumber) {
        this.number = lineNumber;
    }
}