package main.java.com.romkos.order.model;

public class Order {

    private String type; // standard or custom
    private String number; // RK-1
    private String shippingDate; // 12.01.2024
    private String clientLastName; // Shevchenko
    private String clientFirstName; // Stepan
    private String clientPhone; // 067-012-34-56
    private float amount; // 1000.5
    private float advancePayment; // 500.25
    private String deliveryCity; // Kharkiv
    private boolean assemblyNeed; // Y or N
    private String packagingType; // film or cardboard
    private String deliveryMethod; // self-pickup or carrier, department No. 1
    private String primaryColors; // White/Blue
    private String manager; // is set automatically

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = Float.parseFloat(amount);
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(String advancePayment) {
        this.advancePayment = Float.parseFloat(advancePayment);
    }

    public void setAdvancePayment(float advancePayment) {
        this.advancePayment = advancePayment;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public boolean getAssemblyNeed() {
        return assemblyNeed;
    }

    public void setAssemblyNeed(String assemblyNeed) {
        this.assemblyNeed = assemblyNeed.toLowerCase().startsWith("y");
    }

    public void setAssemblyNeed(boolean assemblyNeed) {
        this.assemblyNeed = assemblyNeed;
    }

    public String getPackagingType() {
        return packagingType;
    }

    public void setPackagingType(String packagingType) {
        this.packagingType = packagingType;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getPrimaryColors() {
        return primaryColors;
    }

    public void setPrimaryColors(String primaryColors) {
        this.primaryColors = primaryColors;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
