
package com.ecommerce.entity;

import com.ecommerce.beans.CMNRES;
public class TRANSACTION_DETAIL extends CMNRES{
    private String TX_ID,TX_AMOUNT,TX_QTY,DISCOUNT,TX_STS,TX_TS,UPDATED_BY,UPDATED_TS,
            CATEGORY_NAME,PRODUCT_NAME,PRODUCT_IMG,BRAND_NAME;

    public String getTX_ID() {
        return TX_ID;
    }

    public void setTX_ID(String TX_ID) {
        this.TX_ID = TX_ID;
    }

    public String getTX_AMOUNT() {
        return TX_AMOUNT;
    }

    public void setTX_AMOUNT(String TX_AMOUNT) {
        this.TX_AMOUNT = TX_AMOUNT;
    }

    public String getTX_QTY() {
        return TX_QTY;
    }

    public void setTX_QTY(String TX_QTY) {
        this.TX_QTY = TX_QTY;
    }

    public String getDISCOUNT() {
        return DISCOUNT;
    }

    public void setDISCOUNT(String DISCOUNT) {
        this.DISCOUNT = DISCOUNT;
    }

    public String getTX_STS() {
        return TX_STS;
    }

    public void setTX_STS(String TX_STS) {
        this.TX_STS = TX_STS;
    }

    public String getTX_TS() {
        return TX_TS;
    }

    public void setTX_TS(String TX_TS) {
        this.TX_TS = TX_TS;
    }

    public String getUPDATED_BY() {
        return UPDATED_BY;
    }

    public void setUPDATED_BY(String UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY;
    }

    public String getUPDATED_TS() {
        return UPDATED_TS;
    }

    public void setUPDATED_TS(String UPDATED_TS) {
        this.UPDATED_TS = UPDATED_TS;
    }

    public String getCATEGORY_NAME() {
        return CATEGORY_NAME;
    }

    public void setCATEGORY_NAME(String CATEGORY_NAME) {
        this.CATEGORY_NAME = CATEGORY_NAME;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public String getPRODUCT_IMG() {
        return PRODUCT_IMG;
    }

    public void setPRODUCT_IMG(String PRPDUCT_IMG) {
        this.PRODUCT_IMG = PRPDUCT_IMG;
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
