package ru.yandex.samokat.inputs;

public class Order {
    private String name;
    private String surname;
    private String address;
    private String metro;
    private String phone;
    private int date;
    private int term;
    private boolean black;
    private boolean gray;
    private String comment;
    private String orderButtonClassFeature;

    public Order(String name, String surname, String address, String metro, String phone,
                 int date, int term, boolean black, boolean gray, String comment, String orderButtonClassFeature) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.term = term;
        this.black = black;
        this.gray = gray;
        this.comment = comment;
        this.orderButtonClassFeature = orderButtonClassFeature;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getMetro() {
        return metro;
    }

    public String getPhone() {
        return phone;
    }

    public int getDate() {
        return date;
    }

    public int getTerm() {
        return term;
    }

    public boolean isBlack() {
        return black;
    }

    public boolean isGray() {
        return gray;
    }

    public String getComment() {
        return comment;
    }

    public String getOrderButtonClassFeature() {
        return orderButtonClassFeature;
    }
}