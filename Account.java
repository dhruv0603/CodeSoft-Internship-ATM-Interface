public class Account {

    // Instance variable
    private  String  accountHolderName;
    private  int     accountNumber;
    private  int     amount;
    private  int     customerPIN;
    private  String  userId;

    // Getter and Setter
    // accountHolderName
    public String getAccountHolderName() {
        return accountHolderName;
    }
    // accountNumber
    public int getAccountNumber() {
        return accountNumber;
    }
    // Amount
    public int getAmount() {
        return amount;
    }
    // Customer PIN
    public int getCustomerPIN() {
        return customerPIN;
    }
    public String getUserID() {
        return userId;
    }

    // Setter
    public void setAccountHolderName(String name) {
        this.accountHolderName=name;
    }
    public void setAccountNumber(int number) {
        this.accountNumber=number;
    }
    public void setAmount(int amount) {
        this.amount=amount;
    }
    public void setCustomerPIN(int pin) {
        this.customerPIN=pin;
    } 
    public void setUserID(String id) {
        this.userId=id;
    }
}