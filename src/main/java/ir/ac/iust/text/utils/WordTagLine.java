package ir.ac.iust.text.utils;

import edu.stanford.nlp.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Majid on 04/06/2015.
 */
public class WordTagLine extends ColumnedLine {

    private WordTagDefinition definition;

    public WordTagLine(WordTagDefinition definition) {
        this.definition = definition;
    }

    public WordTagLine(String text, WordTagDefinition definition) {
        super(text);
        this.definition = definition;
    }

    public WordTagLine(int number, String text, WordTagDefinition definition1) {
        super(number, text);
        definition = definition1;
    }

    /**
     * pattern must have this elements connected by space:
     * word, trans, feature, pos, fdp, chunk
     *
     * @param definitionPattern for example: `word pos fdp chunk`
     * @param path              path of standard columned file
     * @return processed word lines
     * @throws IOException
     */
    public static List<WordTagLine> getLines(String definitionPattern, Path path) throws IOException {
        return processLines(definitionPattern, Files.readAllLines(path));
    }

    public static List<WordTagLine> processLines(String definitionPattern, List<String> lines) {
        WordTagDefinition definition = null;
        if (definitionPattern != null) definition = new WordTagDefinition(definitionPattern);
        List<WordTagLine> list = new ArrayList<>();
        int lineNumber = 0;
        for (String lineString : lines)
            list.add(new WordTagLine(lineNumber, lineString, definition));
        return list;
    }

    public WordTagLine copy() {
        return new WordTagLine(number, text, definition);
    }

    public WordTagLine copy(int position, int value) {
        WordTagLine line = new WordTagLine(number, text, definition);
        line.setColumn(position, value);
        return line;
    }

    public WordTagLine copy(int position, String value) {
        WordTagLine line = new WordTagLine(number, text, definition);
        columns[position] = value;
        text = StringUtils.join(columns, "\t");
        return line;
    }

    public String word() {
        return columns[definition.getWord()];
    }

    public void word(String newValue) {
        columns[definition.getWord()] = newValue;
    }

    public WordTagDefinition getDefinition() {
        return definition;
    }

    public String trans() {
        return columns[definition.getTransliterated()];
    }

    public void trans(String newValue) {
        columns[definition.getTransliterated()] = newValue;
    }

    public String feature() {
        return columns[definition.getFeature()];
    }

    public void feature(String newValue) {
        columns[definition.getFeature()] = newValue;
    }

    public String pos() {
        return columns[definition.getPos()];
    }

    public void pos(String newValue) {
        columns[definition.getPos()] = newValue;
    }

    public String fdp() {
        return columns[definition.getFdp()];
    }

    public void fdp(String newValue) {
        columns[definition.getFdp()] = newValue;
    }

    public String chunk() {
        return columns[definition.getChunk()];
    }

    public void chunk(String newValue) {
        columns[definition.getChunk()] = newValue;
    }

    public int chunkInt() {
        return Integer.parseInt(columns[definition.getChunk()]);
    }

    public void chunkInt(int newValue) {
        columns[definition.getChunk()] = String.valueOf(newValue);
    }

}
