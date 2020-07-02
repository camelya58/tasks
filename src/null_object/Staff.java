package null_object;

import java.util.ArrayList;

/**
 * Class Staff
 *
 * @author Kamila Meshcheryakova
 * created by 02.07.2020
 */
@SuppressWarnings("unused")
public class Staff extends ArrayList<Position> {
    public void add(String tittle, Person person) {
        add(new Position(tittle, person));
    }
    public void add(String... titles) {
        for(String title: titles)
            add(new Position(title));
    }
    public Staff(String... titles) {
        add(titles);
    }
    public boolean positionAvailable(String title) {
        for(Position position: this) {
            if(position.getTitle().equals(title) && position.getPerson() == Person.NULL)
                return true;
        }
            return false;
    }
    public void fillPosition(String title, Person hire) {
        for(Position position: this) {
            if(position.getTitle().equals(title) && position.getPerson() == Person.NULL) {
                position.setPerson(hire);
                return;
            }
        } throw new RuntimeException("Position " + title + " not available");
    }

    public static void main(String[] args) {
        Staff staff = new Staff("President", "CTO", "Marketing manager", "Project Lead",
                "Software Engineer", "Software Engineer", "Software Engineer", "Software Engineer",
                "Test Engineer");
        staff.fillPosition("President",
                new Person("Ivan", "Golev", "Moscow, Russia"));
        staff.fillPosition("Project Lead",
                new Person("Olga", "Krasnova", "S.-Petersburg, Russia"));
        if(staff.positionAvailable("Software Engineer")) {
            staff.fillPosition("Software Engineer",
                    new Person("Oleg", "Sedyh", "Saratov, Russia"));
        }
        System.out.println(staff);
    }
} /* Output:
[Position: President Person: Ivan Golev, Moscow, Russia, Position: CTO NullPerson,
Position: Marketing manager NullPerson, Position: Project Lead Person: Olga Krasnova, S.-Petersburg, Russia,
Position: Software Engineer Person: Oleg Sedyh, Saratov, Russia, Position: Software Engineer NullPerson,
Position: Software Engineer NullPerson, Position: Software Engineer NullPerson, Position: Test Engineer NullPerson]
*/
