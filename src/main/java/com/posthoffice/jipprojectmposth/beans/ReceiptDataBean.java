
package com.posthoffice.jipprojectmposth.beans;


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
    public String toString() {
        return "ReceiptDataBean{" + "category=" + category + ", date=" + date + ", price=" + price + '}';
    }

}
