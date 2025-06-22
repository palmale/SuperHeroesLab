import java.util.Scanner;

class Superhero {
    String name;
    String ability;
    int powerLevel;

    public Superhero(String name, String ability, int powerLevel) {
        this.name = name;
        this.ability = ability;
        this.powerLevel = powerLevel;
    }

    public void displayHero() {
        System.out.println("Name: " + name);
        System.out.println("Ability: " + ability);
        System.out.println("Power Level: " + powerLevel);
        System.out.println("------------------------");
    }
}

public class SuperheroRoster {

    public static void main(String[] args) {
        // Create array of Superhero objects
        Superhero[] heroes = {
            new Superhero("Spider-Man", "Web-slinging", 85),
            new Superhero("Iron Man", "Flying and high-tech armor", 90),
            new Superhero("Captain Marvel", "Energy Manipulation", 80),
            new Superhero("Black Panther", "Vibranium Energy Daggers", 75),
            new Superhero("Thor", "Mjolnir", 100),
            new Superhero("Captain America", "Superhuman Strength", 105)
        };

        // Display each hero's details
        System.out.println("=== Superhero Roster ===");
        for (Superhero hero : heroes) {
            hero.displayHero();
        }

        // Get user input for search
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the name of the hero to search for: ");
        String target = scanner.nextLine();

        // Search for hero
        System.out.println("\n=== Search Result ===");
        searchHero(heroes, target);

        // Calculate and display average power level
        double average = calculateAveragePower(heroes);
        System.out.printf("\nAverage Power Level: %.2f%n", average);

        scanner.close();
    }

    // Search method
    public static void searchHero(Superhero[] heroes, String target) {
        boolean found = false;
        for (Superhero hero : heroes) {
            if (hero.name.equalsIgnoreCase(target)) {
                hero.displayHero();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Hero not found.");
        }
    }

    // Calculate average power
    public static double calculateAveragePower(Superhero[] heroes) {
        int sum = 0;
        for (Superhero hero : heroes) {
            sum += hero.powerLevel;
        }
        return (double) sum / heroes.length;
    }
}
