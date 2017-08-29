
package com.ecommerce.beans;

public class TXCOMPLETERES extends CMNRES{
    private String PRODUCT_NAME,ORDERED_QUANTITY,TOTAL_PRICE,DISCOUNT_AMT,AMT_AFTER_DISCOUNT;

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public String getORDERED_QUANTITY() {
        return ORDERED_QUANTITY;
    }

    public void setORDERED_QUANTITY(String ORDERED_QUANTITY) {
        this.ORDERED_QUANTITY = ORDERED_QUANTITY;
    }

    public String getTOTAL_PRICE() {
        return TOTAL_PRICE;
    }

    public void setTOTAL_PRICE(String TOTAL_PRICE) {
        this.TOTAL_PRICE = TOTAL_PRICE;
    }

    public String getDISCOUNT_AMT() {
        return DISCOUNT_AMT;
    }

    public void setDISCOUNT_AMT(String DISCOUNT_AMT) {
        this.DISCOUNT_AMT = DISCOUNT_AMT;
    }

    public String getAMT_AFTER_DISCOUNT() {
        return AMT_AFTER_DISCOUNT;
    }

    public void setAMT_AFTER_DISCOUNT(String AMT_AFTER_DISCOUNT) {
        this.AMT_AFTER_DISCOUNT = AMT_AFTER_DISCOUNT;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getMSG() {
        return MSG;
    }

    public void setMSG(String MSG) {
        this.MSG = MSG;
    }
    
    
}
