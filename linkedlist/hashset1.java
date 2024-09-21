package linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class hashset1 {
    public static void main(String[] args) {
        Set<String> votedUsers = new HashSet<>();
        Set<String> singers = new HashSet<>();
        singers.add("Ayuchan Maskare");
        singers.add("Saima");
        singers.add("Muazzam");
        singers.add("Kalpesh");
        singers.add("Rutika");

        Map<String, Integer> votesCountMap = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Reality Show Voting System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Vote for a singer");
            System.out.println("2. See Voting Results");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after nextInt()

            switch (choice) {
                case 1:
                    if (votedUsers.size() >= 5) {
                        System.out.println("Voting is complete. You have already voted for 5 singers.");
                    } else {
                        voteForSinger(scanner, votedUsers, singers, votesCountMap);
                    }
                    break;

                case 2:
                    if (votedUsers.isEmpty()) {
                        System.out.println("No votes recorded yet.");
                    } else {
                        displayVotingResults(singers, votesCountMap);
                    }
                    break;

                case 3:
                    System.out.println("Exiting Reality Show Voting System.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void voteForSinger(Scanner scanner, Set<String> votedUsers, Set<String> singers, Map<String, Integer> votesCountMap) {
        System.out.print("Enter your name to vote: ");
        String userName = scanner.nextLine();

        if (votedUsers.contains(userName)) {
            System.out.println("Sorry, " + userName + "! You have already voted.");
        } else {
            System.out.println("Please select a singer to vote for:");
            int i = 1;
            for (String singer : singers) {
                System.out.println(i + ". " + singer);
                i++;
            }

            System.out.print("Enter your choice (1-5): ");
            int voteChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after nextInt()

            if (voteChoice >= 1 && voteChoice <= 5) {
                String singerVoted = (String) singers.toArray()[voteChoice - 1];
                System.out.println(userName + " voted for " + singerVoted);
                votedUsers.add(userName);

                votesCountMap.put(singerVoted, votesCountMap.getOrDefault(singerVoted, 0) + 1);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayVotingResults(Set<String> singers, Map<String, Integer> votesCountMap) {
        System.out.println("Voting Results:");
        for (String singer : singers) {
            int votesReceived = votesCountMap.getOrDefault(singer, 0);
            System.out.println(singer + " - Votes: " + votesReceived);
        }
    }
}
