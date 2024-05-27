package candidacy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HiringProcess {
    public static void main(String[] args) {
        // Defining the base salary value
        double baseSalary = 2000.00;

        // Array with the list of candidates
        String[] candidates = {"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA", "DANIELA", "JORGE"};

        // List to store the names of selected candidates
        List<String> selectedCandidates = new ArrayList<>();

        for (String candidate : candidates) {
            // Simulating the desired value by the candidate
            double desiredSalary = desiredValue();

            // Displaying the desired salary with two decimal places
            System.out.println(candidate + " - Desired salary: " + String.format("%.2f", desiredSalary));

            // Flow control based on salary comparison
            if (baseSalary > desiredSalary) {
                System.out.println("CALL THE CANDIDATE " + candidate);
                selectedCandidates.add(candidate);
            } else if (baseSalary == desiredSalary) {
                System.out.println("CALL THE CANDIDATE " + candidate + ", WITH COUNTER PROPOSAL");
                selectedCandidates.add(candidate);
            } else {
                System.out.println("WAITING FOR THE RESULTS OF THE OTHER CANDIDATES");
            }

            // Checks if 5 candidates have already been selected
            if (selectedCandidates.size() >= 5) {
                System.out.println("Maximum number of candidates selected for interview reached.");
                break;
            }
        }

        // Print the list of selected candidates
        printSelectedCandidates(selectedCandidates);

        // Make calls to selected candidates
        makeCalls(selectedCandidates);
    }

    // Method that simulates the desired value
    static double desiredValue() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    // Method to print the list of selected candidates
    static void printSelectedCandidates(List<String> selectedCandidates) {
        System.out.println("\nList of selected candidates:");
        for (String candidate : selectedCandidates) {
            System.out.println(candidate);
        }
    }

    // Method to make calls to selected candidates
    static void makeCalls(List<String> selectedCandidates) {
        System.out.println("\nMaking calls to selected candidates:");
        for (String candidate : selectedCandidates) {
            int attempts = 0;
            while (attempts < 3) {
                attempts++;
                if (attempts == 1) {
                    System.out.println("Attempt " + attempts + " for candidate " + candidate);
                } else {
                    System.out.println("Attempt " + attempts + " for candidate " + candidate + " (previous attempt unsuccessful)");
                }

                // Simulate whether the candidate answers the call or not
                boolean answersCall = ThreadLocalRandom.current().nextBoolean();
                if (answersCall) {
                    System.out.println("WE GOT IN TOUCH WITH THE CANDIDATE " + candidate + " AFTER " + attempts + " ATTEMPT(S)");
                    break;
                } else {
                    System.out.println("WE COULD NOT REACH THE CANDIDATE " + candidate);
                }
            }
        }
    }
}
