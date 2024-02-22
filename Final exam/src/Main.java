
interface DiscountRate {
    double getProductDiscountRate(String userType);
    double getServiceDiscountRate(String userType);
}

class Customer implements DiscountRate {
    private String userType;

    public Customer(String userType) {
        this.userType = userType;
    }

    public double getProductDiscountRate(String userType) {
        switch (userType) {
            case "Premium":
            case "Gold":
            case "Silver":
                return 0.1;
            default:
                return 0.0;
        }
    }

    public double getServiceDiscountRate(String userType) {
        switch (userType) {
            case "Premium":
                return 0.2;
            case "Gold":
                return 0.15;
            case "Silver":
                return 0.1;
            default:
                return 0.0;
        }
    }
}

public class Sale {
    public static void main(String[] args) {
        Customer customer = new Customer("Premium");

        double productDiscountRate = customer.getProductDiscountRate(customer.userType);
        double serviceDiscountRate = customer.getServiceDiscountRate(customer.userType);

        System.out.println("Product discount rate: " + productDiscountRate);
        System.out.println("Service discount rate: " + serviceDiscountRate);
    }
}