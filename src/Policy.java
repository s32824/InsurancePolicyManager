import java.util.Objects;

public class Policy {
    private String policyNumber;
    private String clientName;
    private double basePremium;
    private int riskLevel;
    private double vehicleValue;
    private boolean hasAlarm;
    private boolean claimFreeClient;

    private static int createdPolicyCount = 0;
    private static final double ADMINISTRATIVE_FEE = 50.0;

    public Policy (String policyNumber, String clientName, double basePremium, int riskLevel, double vehicleValue, boolean hasAlarm, boolean claimFreeClient) {
        this.policyNumber = policyNumber;
        this.clientName = clientName;
        this.basePremium = basePremium;
        this.riskLevel = riskLevel;
        this.vehicleValue = vehicleValue;
        this.hasAlarm = hasAlarm;
        this.claimFreeClient = claimFreeClient;

        createdPolicyCount++;
    }

    public double calculateFinalPremium() {
        double premium = basePremium + (riskLevel * 20.0) + (vehicleValue * 0.01);
        if(hasAlarm) premium -= 30.0;
        if(claimFreeClient) premium *= 0.90;
        return premium + ADMINISTRATIVE_FEE;
    }

    public double calculateRenewalPremium() {
        return calculateFinalPremium() * 1.05;
    }

    public String getRiskSummary() {
        if (riskLevel <= 2) {
            return "Low Risk";
        } else if (riskLevel <= 4) {
            return "Medium Risk";
        } else {
            return "High Risk";
        }
    }

    public static int getCreatedPolicyCount() {
        return createdPolicyCount;
    }

    @Override
    public String toString() {
        return String.format("Policy [%s] - Client: %s | Risk: %s | Premium: $%.2f", policyNumber, clientName, getRiskSummary(), calculateFinalPremium());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }
}
