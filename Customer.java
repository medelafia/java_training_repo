
class Account {}

public record Customer(Account account, String name, int customerId ) implements Serializable {
    public int customerId() {
        return customerId;
    }
    public void someMethod() {
        System.out.println("Some method");
    }

    public static void test{

    }

    static {
        System.out.println("Static block");
    }
    record InnerRecord(){

    }

}
