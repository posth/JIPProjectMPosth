package com.posthoffice.jipprojectmposth.beans;

import java.util.Objects;

public class ReceiptDataBean {

    private String category;
    private String date;
    private String price;

    public ReceiptDataBean() {
        super();
        this.category = "";
        this.date = "";
        this.price = "";
    }

    public ReceiptDataBean(String category, String date, String price) {
        super();
        this.category = category;
        this.date = date;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.category);
        hash = 11 * hash + Objects.hashCode(this.date);
        hash = 11 * hash + Objects.hashCode(this.price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReceiptDataBean other = (ReceiptDataBean) obj;
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReceiptDataBean{" + "category=" + category + ", date=" + date + ", price=" + price + '}';
    }
}
