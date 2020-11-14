package paterns.abstract_factory;

/**
 * Класс Product
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
