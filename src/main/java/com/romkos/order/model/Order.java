package main.java.com.romkos.order.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Order {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private String type; // standard or custom
    private String number; // RK-1
    private LocalDate shippingDate; // 31.01.2024
    private String clientLastName; // Shevchenko
    private String clientFirstName; // Stepan
    private String clientPhone; // 067-012-34-56
    private float amount; // 1000.5
    private float advancePayment; // 500.25
    private String deliveryCity; // Kharkiv
    private boolean assemblyNeed; // Y or N
    private PackagingType packagingType; // film or cardboard
    private String deliveryMethod; // self-pickup or carrier, department No. 1
    private String primaryColors; // White/Blue
    private String managerName; // is set automatically
    private final LocalDateTime registrationDate = LocalDateTime.now();

    @Override
    public String toString() {
        return "Order {"
                + "\n\tnumber = " + number
                + "\n\tshippingDate = " + shippingDate.format(DATE_FORMATTER)
                + "\n\tclientLastName = " + clientLastName
                + "\n\tclientFirstName = " + clientFirstName
                + "\n\tclientPhone = " + clientPhone
                + "\n\tamount = " + amount
                + "\n\tadvancePayment = " + advancePayment
                + "\n\tdeliveryCity = " + deliveryCity
                + "\n\tassemblyNeed = " + assemblyNeed
                + "\n\tpackagingType = " + packagingType
                + "\n\tdeliveryMethod = " + deliveryMethod
                + "\n\tprimaryColors = " + primaryColors
                + "\n\tmanagerName = " + managerName
                + "\n\tregistrationDate = " + registrationDate.format(DATE_TIME_FORMATTER)
                + "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Float.compare(amount, order.amount) == 0
                && Float.compare(advancePayment, order.advancePayment) == 0
                && assemblyNeed == order.assemblyNeed
                && Objects.equals(type, order.type)
                && Objects.equals(number, order.number)
                && Objects.equals(shippingDate, order.shippingDate)
                && Objects.equals(clientLastName, order.clientLastName)
                && Objects.equals(clientFirstName, order.clientFirstName)
                && Objects.equals(clientPhone, order.clientPhone)
                && Objects.equals(deliveryCity, order.deliveryCity)
                && Objects.equals(packagingType, order.packagingType)
                && Objects.equals(deliveryMethod, order.deliveryMethod)
                && Objects.equals(primaryColors, order.primaryColors)
                && Objects.equals(managerName, order.managerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, number, shippingDate,
                clientLastName, clientFirstName, clientPhone,
                amount, advancePayment, deliveryCity,
                assemblyNeed, packagingType, deliveryMethod,
                primaryColors, managerName);
    }

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

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = LocalDate.parse(shippingDate, DATE_FORMATTER);
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

    public PackagingType getPackagingType() {
        return packagingType;
    }

    public void setPackagingType(PackagingType packagingType) {
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

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public enum PackagingType {
        film("1"),
        cardboard("2"),
        UNKNOWN("0");

        private final String value;

        PackagingType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static PackagingType getPackagingTypeByValue(String value) {
            for (PackagingType t : PackagingType.values()) {
                if (t.value.equals(value)) {
                    return t;
                }
            }
            return PackagingType.UNKNOWN;
        }
    }
}
