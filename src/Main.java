public class Main {
    public static void main(String[] args) {
        //policy
        Policy p1 = new Policy("POL-001", "Alice", 500, 1, 20000, true, true);
        Policy p2 = new Policy("POL-002", "Bob", 500, 4, 30000, false, false);

        Policy p3 = new Policy("POL-001", "Alice", 600, 2, 25000, true, true);

        System.out.println("--- Testing Policy Data ---");
        System.out.println(p1);
        System.out.println(p2);

        System.out.println("\n--- Testing Business Logic ---");
        System.out.println("Renewal for Alice: $" + p1.calculateRenewalPremium());

        System.out.println("\n--- Testing Static Counter ---");
        System.out.println("Total Policies Created: " + Policy.getCreatedPolicyCount());

        System.out.println("\n--- Testing Equals Method ---");
        if (p1.equals(p3)) {
            System.out.println("SUCCESS: p1 and p3 are considered the same policy (matching IDs).");
        } else {
            System.out.println("FAILURE: IDs should match.");
        }

        //insurance office
        InsuranceOffice myOffice = new InsuranceOffice("SafeRoads Insurance Poland");

        Policy pA = new Policy("P100", "Kowalski", 400, 2, 15000, true, true);
        Policy pB = new Policy("P200", "Nowak", 600, 5, 45000, false, false);
        Policy pC = new Policy("P300", "Wiśniewski", 500, 3, 22000, true, false);

        myOffice.addPolicy(pA);
        myOffice.addPolicy(pB);
        myOffice.addPolicy(pC);

        Policy duplicate = new Policy("P100", "Duplicate Entry", 400, 2, 15000, true, true);
        myOffice.addPolicy(duplicate);

        myOffice.showReport();

        System.out.println("High Risk Policies count: " + myOffice.countHighRiskPolicies());
        System.out.println("Total Renewal Forecast: $" + myOffice.calculateTotalRenewalForecast());

        myOffice.printCheaperThan(700);

        Policy found = myOffice.findByNumber("P200");
        if(found != null) System.out.println("Found policy for: " + found.getClientName());
    }
}
