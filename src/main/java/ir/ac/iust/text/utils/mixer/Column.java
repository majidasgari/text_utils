package ir.ac.iust.text.utils.mixer;

/**
 * Created by Majid on 01/06/2015.
 */
public class Column {
    private int fileIndex;
    private int columnIndex;

    public Column(int fileIndex, int columnIndex) {
        this.fileIndex = fileIndex;
        this.columnIndex = columnIndex;
    }

    public Column() {

    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public int getFileIndex() {

        return fileIndex;
    }

    public void setFileIndex(int fileIndex) {
        this.fileIndex = fileIndex;
    }
}
