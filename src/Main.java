public class Main {
    public static void main(String[] args) {
        Policy p1 = new Policy("POL-001", "Alice", 500, 1, 20000, true, true);
        Policy p2 = new Policy("POL-002", "Bob", 500, 4, 30000, false, false);

        Policy p3 = new Policy("POL-001", "Alice", 600, 2, 25000, true, true);

        System.out.println("--- Testing Policy Data ---");
        System.out.println(p1);
        System.out.println(p2);

        System.out.println("\n--- Testing Business Logic ---");
        System.out.println("Renewal for Alice: $" + String.format("%.2f", p1.calculateRenewalPremium()));

        System.out.println("\n--- Testing Static Counter ---");
        System.out.println("Total Policies Created: " + Policy.getCreatedPolicyCount());

        System.out.println("\n--- Testing Equals Method ---");
        if (p1.equals(p3)) {
            System.out.println("SUCCESS: p1 and p3 are considered the same policy (matching IDs).");
        } else {
            System.out.println("FAILURE: IDs should match.");
        }
    }
}
