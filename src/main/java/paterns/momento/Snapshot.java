package paterns.momento;

/**
 * Класс Snapshot
 *
 * @author Kamila Meshcheryakova
 * created 21.12.2020
 */
public class Snapshot {

    private final String text;
    private final int size;
    private final String font;
    private final int fieldOne;
    private final int fieldTwo;

    public Snapshot(String text, int size, String font, int fieldOne, int fieldTwo) {
        this.text = text;
        this.size = size;
        this.font = font;
        this.fieldOne = fieldOne;
        this.fieldTwo = fieldTwo;
    }

    public String getText() {
        return text;
    }

    public int getSize() {
        return size;
    }

    public String getFont() {
        return font;
    }

    public int getFieldOne() {
        return fieldOne;
    }

    public int getFieldTwo() {
        return fieldTwo;
    }
}
