package ir.ac.iust.text.utils;

import edu.stanford.nlp.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Majid on 30/05/2015.
 */
public class WordLine {
    public String text;
    public int number;
    public String[] splits;
    public boolean isEmpty;

    public WordLine() {
    }

    public WordLine(String text) {
        this.text = text;
        if (text.trim().length() == 0) {
            isEmpty = true;
            splits = new String[0];
        } else
            this.splits = text.split("\t");
    }

    public static List<WordLine> getLines(Path path) throws IOException {
        return processLines(Files.readAllLines(path), "\t");
    }

    public static List<WordLine> getLines(Path path, String splitter) throws IOException {
        return processLines(Files.readAllLines(path), splitter);
    }

    public static List<WordLine> processLines(List<String> lines, String splitter) {
        List<WordLine> list = new ArrayList<>();
        int lineNumber = 0;
        for (String lineString : lines) {
            WordLine line = new WordLine();
            line.text = lineString.trim();
            line.number = lineNumber;
            if (line.text.length() == 0)
                line.isEmpty = true;
            else {
                line.splits = lineString.split(splitter);
            }
            list.add(line);
        }
        return list;
    }

    public void setSplit(int position, int value) {
        splits[position] = String.valueOf(value);
        text = StringUtils.join(splits, "\t");
    }

    public void setSplit(int position, String value) {
        splits[position] = value;
        text = StringUtils.join(splits, "\t");
    }

    public int getSplitAsInt(int position) {
        return Integer.parseInt(splits[position]);
    }

    @Override
    public String toString() {
        if(splits == null || splits.length == 0) return "";
        return StringUtils.join(splits, "\t");
    }

    public String toString(int replaceIndex, String replace) {
        String old = splits[replaceIndex];
        splits[replaceIndex] = replace;
        String toReturn = StringUtils.join(splits, "\t");
        splits[replaceIndex] = old;
        return toReturn;
    }

    public WordLine copy() {
        return new WordLine(text);
    }

    public WordLine copy(int position, int value) {
        WordLine line = new WordLine(text);
        line.setSplit(position, value);
        return line;
    }

    public WordLine copy(int position, String value) {
        WordLine line = new WordLine(text);
        splits[position] = value;
        text = StringUtils.join(splits, "\t");
        return line;
    }
}