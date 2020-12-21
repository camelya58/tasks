package paterns.momento;

/**
 * Class MomentoPattern demonstrates the realization of momento pattern,
 * which allows to save the state of the object inside the object using encapsulation.
 *
 * @author Kamila Meshcheryakova
 * created 21.12.2020
 */
public class MomentoPattern {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor("Hello World!", 12, "Arial", 999, 111);
        System.out.println(textEditor);
        Snapshot snapshot = textEditor.snapshot();
        textEditor.setText("Just a text");
        textEditor.setSize(10);
        System.out.println(textEditor);
        textEditor.load(snapshot);
        System.out.println(textEditor);
    }
}
