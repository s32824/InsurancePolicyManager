import java.util.ArrayList;

public class InsuranceOffice {
    private String name;
    private ArrayList<Policy> policies;

    public InsuranceOffice(String name) {
        this.name = name;
        this.policies = new ArrayList<>();
    }

    public void addPolicy(Policy p) {
        if (!policies.contains(p)) {
            policies.add(p);
            System.out.println("Policy " + p.getPolicyNumber() + " added successfully.");
        } else {
            System.out.println("Error: Policy #" + p.getPolicyNumber() + " already exists in the system.");
        }
    }

    public double getTotalPortfolioValue() {
        double total = 0;
        for (Policy p : policies) {
            total += p.calculateFinalPremium();
        }
        return total;
    }

    public void showReport() {
        System.out.println("\n--- INSURANCE OFFICE REPORT ---");

        for (Policy p : policies) {
            System.out.println(p.toString());
        }

        System.out.println("--------------------------------");

        System.out.println("Total Portfolio Value: $" + getTotalPortfolioValue());
        System.out.println("Total Policies Created (Global): " + Policy.getCreatedPolicyCount());
    }

    public double calculateTotalRenewalForecast() {
        double total = 0;
        for (Policy p : policies) {
            total += p.calculateRenewalPremium();
        }
        return total;
    }

    public int countHighRiskPolicies() {
        int count = 0;
        for (Policy p : policies) {
            if (p.getRiskLevel() >= 4) count++;
        }
        return count;
    }

    public Policy findByNumber(String policyNumber) {
        for (Policy p : policies) {
            if (p.getPolicyNumber().equals(policyNumber)) {
                return p;
            }
        }
        return null; // Not found
    }

    public void printCheaperThan(double threshold) {
        System.out.println("Policies cheaper than $" + threshold + ":");
        for (Policy p : policies) {
            if (p.calculateFinalPremium() < threshold) {
                System.out.println("- " + p.getClientName() + " ($" + p.calculateFinalPremium() + ")");
            }
        }
    }
}