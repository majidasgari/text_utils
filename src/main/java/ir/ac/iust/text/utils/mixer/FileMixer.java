package ir.ac.iust.text.utils.mixer;

import ir.ac.iust.text.utils.ColumnedLine;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Majid on 01/06/2015.
 */
public class FileMixer {
    public static void mix(Path file1, String splitter1,
                           Path file2, String splitter2,
                           Path output, Column... columns) throws IOException {
        List<ColumnedLine> lines1 = ColumnedLine.getLines(file1, splitter1);
        removeTailedEmptyLines(lines1);
        List<ColumnedLine> lines2 = ColumnedLine.getLines(file2, splitter2);
        removeTailedEmptyLines(lines2);
        List<String> outputLines = new ArrayList<>();
        if (lines1.size() != lines2.size())
            return;
        StringBuilder builder = new StringBuilder();
        for (int i = 0, lines1Size = lines1.size(); i < lines1Size; i++) {
            ColumnedLine line1 = lines1.get(i);
            ColumnedLine line2 = lines2.get(i);
            builder.setLength(0);
            if (!line1.isEmpty())
                for (Column column : columns) {
                    ColumnedLine line = (column.getFileIndex() == 0 ? line1 : line2);
                    builder.append(line.column(column.getColumnIndex() < 0
                            ? line.getNumberOfColumns() + column.getColumnIndex()
                            : column.getColumnIndex())).append('\t');
                }
            else
                builder.append('\t');
            if (builder.length() > 0) builder.setLength(builder.length() - 1);
            outputLines.add(builder.toString());
        }
        Files.deleteIfExists(output);
        Files.write(output, outputLines, Charset.forName("UTF-8"));
    }

    private static void removeTailedEmptyLines(List<ColumnedLine> lines) {
        for (int i = lines.size() - 1; i >= 0; i--)
            if (lines.get(i).isEmpty())
                lines.remove(i);
            else break;
    }
}
