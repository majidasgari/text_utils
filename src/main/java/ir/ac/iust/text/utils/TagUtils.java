package ir.ac.iust.text.utils;

/**
 * Created by Majid on 04/06/2015.
 */
public class TagUtils {

    public static boolean isVerbTag(WordTagLine wordTagLine) {
        if (wordTagLine == null) return false;
        String tag = wordTagLine.pos();
        return tag.equals("V") || tag.equals("ACT") || tag.equals("PASS");
    }

    public static boolean isConjunctionTag(WordTagLine wordTagLine) {
        if (wordTagLine == null) return false;
        String tag = wordTagLine.pos();
        return tag.equals("CONJ");
    }

    public static boolean isPunctuationTag(WordTagLine wordTagLine) {
        if (wordTagLine == null) return false;
        String tag = wordTagLine.pos();
        return tag.equals("PUNK");
    }

    public static boolean isPrepTag(WordTagLine wordTagLine) {
        if (wordTagLine == null) return false;
        String tag = wordTagLine.pos();
        return tag.equals("P") || tag.equals("PREP") || tag.equals("INAM");
    }

    public static boolean isPostPositionTag(WordTagLine wordTagLine) {
        if (wordTagLine == null) return false;
        String tag = wordTagLine.pos();
        return tag.equals("POSTP");
    }

    public static boolean isConnectorWord(WordTagLine wordTagLine) {
        if (wordTagLine == null) return false;
        String word = wordTagLine.word();
        return word.equals("و") || word.equals("،") || word.equals(",");
    }
}
