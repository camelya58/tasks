package null_object;

/**
 * Class Position represents a supporting class and the way to use null-object of Person to fill the vacancy.
 *
 * @author Kamila Meshcheryakova
 * created by 02.07.2020
 */
public class Position {
    private String title;
    private Person person;
    public Position(String jobTitle, Person employee) {
        title = jobTitle;
        person = employee;
        if(person == null)
            person = Person.NULL;
    }
    public Position(String jobTitle) {
        title = jobTitle;
        person = Person.NULL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person newPerson) {
        person = newPerson;
        if(person == null)
            person = Person.NULL;
    }

    @Override
    public String toString() {
        return "Position: " + title + " " + person;
    }
}
