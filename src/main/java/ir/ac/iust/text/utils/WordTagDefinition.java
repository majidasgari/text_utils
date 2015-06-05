package ir.ac.iust.text.utils;

/**
 * Created by Majid on 04/06/2015.
 */
public class WordTagDefinition {
    private int word = -1;
    private int transliterated = -1;
    private int feature = -1;
    private int pos = -1;
    private int fdp = -1;
    private int chunk = -1;

    public WordTagDefinition() {
    }

    public WordTagDefinition(String pattern) {
        String[] splits = pattern.split("\\s+");
        for (int i = 0; i < splits.length; i++) {
            switch (splits[i]) {
                case "word":
                    word = i;
                    break;
                case "transliterated":
                case "trans":
                    transliterated = i;
                    break;
                case "feature":
                    feature = i;
                    break;
                case "pos":
                    pos = i;
                    break;
                case "fdp":
                    fdp = i;
                    break;
                case "chunk":
                    chunk = i;
                    break;
            }
        }
    }

    public boolean hasWord() {
        return word != -1;
    }

    public boolean hasTransliterate() {
        return transliterated != -1;
    }

    public boolean hasFeature() {
        return feature != -1;
    }

    public boolean hasPOS() {
        return pos != -1;
    }

    public boolean hasFDP() {
        return fdp != -1;
    }

    public boolean hasChunk() {
        return chunk != -1;
    }

    public int getWord() {
        return word;
    }

    public void setWord(int word) {
        this.word = word;
    }

    public int getTransliterated() {
        return transliterated;
    }

    public void setTransliterated(int transliterated) {
        this.transliterated = transliterated;
    }

    public int getFeature() {
        return feature;
    }

    public void setFeature(int feature) {
        this.feature = feature;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getFdp() {
        return fdp;
    }

    public void setFdp(int fdp) {
        this.fdp = fdp;
    }

    public int getChunk() {
        return chunk;
    }

    public void setChunk(int chunk) {
        this.chunk = chunk;
    }
}
