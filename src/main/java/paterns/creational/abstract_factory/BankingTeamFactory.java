package paterns.creational.abstract_factory;

/**
 * Класс BankingTeamFactory
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class BankingTeamFactory implements ProjectTeamFactory{
    @Override
    public Programmer getProgrammer() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public Manager getManager() {
        return new LeadManager();
    }
}
