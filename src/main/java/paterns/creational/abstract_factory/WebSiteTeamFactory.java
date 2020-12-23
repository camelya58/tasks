package paterns.creational.abstract_factory;

/**
 * Класс WebSiteTeamFactory
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class WebSiteTeamFactory implements ProjectTeamFactory{
    @Override
    public Programmer getProgrammer() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public Manager getManager() {
        return new LinearManager();
    }
}
