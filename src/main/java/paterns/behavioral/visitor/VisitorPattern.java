package paterns.behavioral.visitor;

/**
 * Class VisitorPattern demonstrates the work of visitor pattern, which
 * allows
 *
 * @author Kamila Meshcheryakova
 * created 29.12.2020
 */
public class VisitorPattern {
    public static void main(String[] args) {
        Project project = new Project();
        IDeveloper junior = new JuniorDeveloper();
        IDeveloper senior = new SeniorDeveloper();

        System.out.println("Junior in Action...");
        project.beWrittenBy(junior);

        System.out.println("**********************");
        project.beWrittenBy(senior);
    }
}

class Project implements IProjectElement {
    IProjectElement[] projectElements;

    public Project() {
        this.projectElements = new IProjectElement[]{
                new ProjectClass(),
                new Database(),
                new Test(),
        };
    }

    @Override
    public void beWrittenBy(IDeveloper developer) {
        for (IProjectElement el : projectElements) {
            el.beWrittenBy(developer);
        }
    }
}