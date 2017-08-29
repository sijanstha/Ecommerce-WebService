/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.entity;

import com.ecommerce.beans.CMNRES;

public class PRODUCT_DETAIL extends CMNRES{
    private int PRODUCT_ID;
    private int CATEGORY_ID;

    public int getCATEGORY_ID() {
        return CATEGORY_ID;
    }

    public void setCATEGORY_ID(int CATEGORY_ID) {
        this.CATEGORY_ID = CATEGORY_ID;
    }
    private String PRODUCT_NAME;
    private float PRICE;
    private String AVAILIABLE_STOCK;
    private String DATE_ADDED;
    private String PRODUCT_IMG;
    private String BRAND_NAME;

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public float getPRICE() {
        return PRICE;
    }

    public void setPRICE(float PRICE) {
        this.PRICE = PRICE;
    }

    public String getAVAILIABLE_STOCK() {
        return AVAILIABLE_STOCK;
    }

    public void setAVAILIABLE_STOCK(String AVAILIABLE_STOCK) {
        this.AVAILIABLE_STOCK = AVAILIABLE_STOCK;
    }

    public String getDATE_ADDED() {
        return DATE_ADDED;
    }

    public void setDATE_ADDED(String DATE_ADDED) {
        this.DATE_ADDED = DATE_ADDED;
    }

    public String getPRODUCT_IMG() {
        return PRODUCT_IMG;
    }

    public void setPRODUCT_IMG(String PRODUCT_IMG) {
        this.PRODUCT_IMG = PRODUCT_IMG;
    }

    public String getBRAND_NAME() {
        return BRAND_NAME;
    }

    public void setBRAND_NAME(String BRAND_NAME) {
        this.BRAND_NAME = BRAND_NAME;
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
