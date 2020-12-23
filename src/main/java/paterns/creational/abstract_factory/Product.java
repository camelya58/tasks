package paterns.creational.abstract_factory;

/**
 * Class Product demonstrates the work of abstract factory pattern, which
 * defines the interface for creating all available types of products, and each specific implementation
 * of the factory generates products of one of the variations.
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class Product {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new BankingTeamFactory();
        Programmer programmer = projectTeamFactory.getProgrammer();
        Tester tester = projectTeamFactory.getTester();
        Manager manager = projectTeamFactory.getManager();
    }
}
