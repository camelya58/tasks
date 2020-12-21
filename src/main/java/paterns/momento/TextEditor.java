package paterns.momento;

/**
 * Класс TextEditor
 *
 * @author Kamila Meshcheryakova
 * created 21.12.2020
 */
public class TextEditor {

    private String text;
    private int size;
    private String font;
    private int fieldOne;
    private int fieldTwo;

    public TextEditor(String text, int size, String font, int fieldOne, int fieldTwo) {
        this.text = text;
        this.size = size;
        this.font = font;
        this.fieldOne = fieldOne;
        this.fieldTwo = fieldTwo;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public Snapshot snapshot() {
        return new Snapshot(text, size, font, fieldOne, fieldOne);
    }

    public void load(Snapshot snapshot) {
        this.text = snapshot.getText();
        this.size = snapshot.getSize();
        this.font = snapshot.getFont();
        this.fieldOne = snapshot.getFieldOne();
        this.fieldTwo = snapshot.getFieldTwo();
    }

    @Override
    public String toString() {
        return "TextEditor{" +
                "text='" + text + '\'' +
                ", size=" + size +
                ", font='" + font + '\'' +
                ", fieldOne=" + fieldOne +
                ", fieldTwo=" + fieldTwo +
                '}';
    }
}
