package paterns.creational.abstract_factory;

/**
 * Класс ProjectTeamFactory
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public interface ProjectTeamFactory {
    Programmer getProgrammer();
    Tester getTester();
    Manager getManager();
}
