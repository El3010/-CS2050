import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array to store the three Album objects
        Album[] albums = new Album[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for Album " + (i + 1));

            try {
                System.out.print("Title: ");
                String title = scanner.nextLine();

                System.out.print("Performer: ");
                String performer = scanner.nextLine();

                System.out.print("Genre: ");
                String genre = scanner.nextLine();

                System.out.print("Number of Songs: ");
                int numberOfSongs = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                // Create an Album object using the provided details
                albums[i] = new Album(title, performer, genre, numberOfSongs);

                // Display the details of the created album
                System.out.println("\nAlbum " + (i + 1) + " Details:");
                System.out.println(album[i]);
                System.out.println("Is album" + (i + 1) + " long? " + albums[i].isLong());

                System.out.println();
            } catch (Exception e) {
                System.err.println("Error: Invalid input. Please try again.");
                scanner.nextLine(); // Consume the invalid input
                i--; // Retry the current album input
            }
        }

        scanner.close();
    }
}
