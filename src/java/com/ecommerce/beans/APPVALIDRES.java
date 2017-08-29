/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.beans;

/**
 *
 * @author SIJAN
 */
public class APPVALIDRES extends CMNRES{

    public String getACCESSKEY() {
        return ACCESSKEY;
    }

    public void setACCESSKEY(String ACCESSKEY) {
        this.ACCESSKEY = ACCESSKEY;
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
    private String ACCESSKEY;
}
