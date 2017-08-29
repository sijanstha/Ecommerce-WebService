package com.ecommerce.webservice;
import com.ecommerce.beans.APPVALIDRES;
import com.ecommerce.beans.CMNRES;
import com.ecommerce.beans.CUSTAUTHRES;
import com.ecommerce.beans.TXCOMPLETERES;
import com.ecommerce.beans.TXCREATERES;
import com.ecommerce.dbconnection.CMNFunctions;
import com.ecommerce.entity.CATEGORY_DETAIL;
import com.ecommerce.entity.PRODUCT_DETAIL;
import com.ecommerce.entity.TRANSACTION_DETAIL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Ecommerce_WebService")
public class Ecommerce_WebService {

    private ResultSet resultSet;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "APP_VALIDATION")
    public APPVALIDRES APP_VALIDATION(@WebParam(name = "applicationType") String applicationType,
            @WebParam(name = "applicationVersion") String applicationVersion,
            @WebParam(name = "versionKey") String versionKey,
            @WebParam(name = "sessionId") String sessionId) {

        APPVALIDRES objAPPVALIDRES = new APPVALIDRES();

        if (applicationType == null || applicationType.isEmpty()) {
            applicationType = "";
        }
        if (applicationVersion == null || applicationVersion.isEmpty()) {
            applicationVersion = "";
        }
        if (versionKey == null || versionKey.isEmpty()) {
            versionKey = "";
        }
        if (sessionId == null || sessionId.isEmpty()) {
            sessionId = "";
        }

        String SPA_VERSION_DETAIL = "EXEC SP_VERSION_DETAIL @FLAG=1, @NAME_TYPE='" + applicationType + "', @VER='"
                + applicationVersion + "', @VER_KEY='" + versionKey + "', @SESSION_ID='" + sessionId + "'";
        CMNFunctions objCMNFunc = new CMNFunctions().executeStoredProcedure(SPA_VERSION_DETAIL);
        if (objCMNFunc.sts == 0) {
            resultSet = objCMNFunc.rs;
            try {
                while (resultSet.next()) {
                    objAPPVALIDRES.setCODE(resultSet.getString("CODE"));
                    objAPPVALIDRES.setMSG(resultSet.getString("MSG"));
                    if (objAPPVALIDRES.getCODE().equals("0")) {
                        objAPPVALIDRES.setACCESSKEY(resultSet.getString(3));
                    }
                }
                resultSet.close();
                objCMNFunc.con.close();
            } catch (SQLException ex) {
                objAPPVALIDRES.setCODE("SQLEXCEPTIONCODE");
                objAPPVALIDRES.setMSG(ex.toString());
            }
        } else {
            objAPPVALIDRES.setMSG(objCMNFunc.msg);
        }
        return objAPPVALIDRES;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "REGISTER_CUSTOMER")
    public CMNRES REGISTER_CUSTOMER(@WebParam(name = "firstName") String firstName,
            @WebParam(name = "middleName") String middleName,
            @WebParam(name = "lastName") String lastName,
            @WebParam(name = "email") String email,
            @WebParam(name = "loginPwd") String loginPwd,
            @WebParam(name = "dob") String dob,
            @WebParam(name = "address") String address,
            @WebParam(name = "contactNo") String contactNo,
            @WebParam(name = "accessKey") String accessKey) {

        CMNRES objCMNRES = new CMNRES();

        String insertSp = "EXEC SP_CUSTOMER_DETAIL @flag='r',@first_name='"
                + firstName + "',@middle_name='" + middleName + "',@last_name='" + lastName
                + "',@email='" + email + "',@login_pwd='" + loginPwd + "',@dob='" + dob
                + "',@address='" + address + "',@contact_no='" + contactNo
                + "',@ACCESS_KEY='" + accessKey + "'";

        CMNFunctions objCMNFunc = new CMNFunctions().executeStoredProcedure(insertSp);
        if (objCMNFunc.sts == 0) {
            resultSet = objCMNFunc.rs;
            try {
                if (resultSet.next()) {
                    objCMNRES.setCODE(resultSet.getString("CODE"));
                    objCMNRES.setMSG(resultSet.getString("MSG"));
                }
                resultSet.close();
                objCMNFunc.con.close();
            } catch (SQLException ex) {
                objCMNRES.setCODE("EXCEPTIONCODE");
                objCMNRES.setMSG(ex.toString());
            }
        } else {
            objCMNRES.setMSG(objCMNFunc.msg);
        }
        return objCMNRES;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CUSTOMER_AUTHENTICATION")
    public CUSTAUTHRES CUSTOMER_AUTHENTICATION(@WebParam(name = "email") String email,
            @WebParam(name = "loginPwd") String loginPwd,
            @WebParam(name = "accessKey") String accessKey,
            @WebParam(name = "portalName") String portalName) {

        CUSTAUTHRES objCUSTAUTHRES = new CUSTAUTHRES();

        String authenticateSp = "EXEC SP_CUSTOMER_DETAIL @FLAG='A',@ACCESS_KEY='" + accessKey
                + "',@EMAIL='" + email + "', @LOGIN_PWD='" + loginPwd + "', @PORTAL_NAME='" + portalName + "'";
        CMNFunctions objCMNFunc = new CMNFunctions().executeStoredProcedure(authenticateSp);
        if (objCMNFunc.sts == 0) {
            resultSet = objCMNFunc.rs;
            try {
                while (resultSet.next()) {
                    objCUSTAUTHRES.setCODE(resultSet.getString("CODE"));
                    objCUSTAUTHRES.setMSG(resultSet.getString("MSG"));
                    if (objCUSTAUTHRES.getCODE().equals("0")) {
                        objCUSTAUTHRES.setAUTH_ID(resultSet.getString(3));
                        objCUSTAUTHRES.setFIRST_NAME(resultSet.getString(4));
                        objCUSTAUTHRES.setMIDDLE_NAME(resultSet.getString(5));
                        objCUSTAUTHRES.setLAST_NAME(resultSet.getString(6));
                        objCUSTAUTHRES.setEMAIL(resultSet.getString(7));
                        objCUSTAUTHRES.setDOB(resultSet.getString(8));
                        objCUSTAUTHRES.setADDRESS(resultSet.getString(9));
                        objCUSTAUTHRES.setCONTACT_NO(resultSet.getString(10));
                    }

                }
                resultSet.close();
                objCMNFunc.con.close();
            } catch (SQLException ex) {
                objCUSTAUTHRES.setCODE("EXECPTIONERROR");
                objCUSTAUTHRES.setMSG(ex.toString());
            }
        } else {
            objCUSTAUTHRES.setMSG(objCMNFunc.msg);
        }
        return objCUSTAUTHRES;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "FETCH_CATEGORY")
    public ArrayList<CATEGORY_DETAIL> FETCH_CATEGORY() {
        String selectCat = "SELECT * FROM TBL_CATEGORY";
        ArrayList<CATEGORY_DETAIL> objArray = new ArrayList<>();
        CMNFunctions objCMNFunc = new CMNFunctions().executeStoredProcedure(selectCat);

        if (objCMNFunc.sts == 0) {
            resultSet = objCMNFunc.rs;
            try {
                while (resultSet.next()) {
                    CATEGORY_DETAIL objCatDet = new CATEGORY_DETAIL();
                    objCatDet.setCATEGORY_ID(resultSet.getInt(1));
                    objCatDet.setCATEGORY_NAME(resultSet.getString(2));
                    objArray.add(objCatDet);
                }
                resultSet.close();
                objCMNFunc.con.close();
            } catch (SQLException ex) {
            }
        } else {
        }
        return objArray;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "FETCH_PRODUCT")
    public ArrayList<PRODUCT_DETAIL> FETCH_PRODUCT(@WebParam(name = "PRODUCT_ID") String CATEGORY_ID) {
        String selectCat = "";
        if(CATEGORY_ID == null){
            CATEGORY_ID = "0";
        }
        if (CATEGORY_ID.equals("0")) {
            selectCat = "EXEC SP_PRODUCT_DETAIL @FLAG=''";
        } else {
            selectCat = "EXEC SP_PRODUCT_DETAIL @FLAG='D',@CATEGORY_ID=" + CATEGORY_ID;
        }
        ArrayList<PRODUCT_DETAIL> objArray = new ArrayList<>();
        CMNFunctions objCMNFunc = new CMNFunctions().executeStoredProcedure(selectCat);

        if (objCMNFunc.sts == 0) {
            resultSet = objCMNFunc.rs;
            try {
                while (resultSet.next()) {
                    PRODUCT_DETAIL objProductDet = new PRODUCT_DETAIL();
                    objProductDet.setCODE(resultSet.getString(1));
                    objProductDet.setMSG(resultSet.getString(2));
                    objProductDet.setPRODUCT_ID(resultSet.getInt(3));
                    objProductDet.setCATEGORY_ID(resultSet.getInt(4));
                    objProductDet.setPRODUCT_NAME(resultSet.getString(5));
                    objProductDet.setPRICE(resultSet.getFloat(6));
                    objProductDet.setAVAILIABLE_STOCK(resultSet.getString(7));
                    objProductDet.setDATE_ADDED(resultSet.getString(8));
                    objProductDet.setPRODUCT_IMG(resultSet.getString(9));
                    objProductDet.setBRAND_NAME(resultSet.getString(10));

                    objArray.add(objProductDet);
                }
                resultSet.close();
                objCMNFunc.con.close();
            } catch (SQLException ex) {
                PRODUCT_DETAIL objProductDet = new PRODUCT_DETAIL();
                objProductDet.setMSG(ex.toString());
                objArray.add(objProductDet);
            }
        } else {
            PRODUCT_DETAIL objProductDet = new PRODUCT_DETAIL();
            objProductDet.setMSG(objCMNFunc.msg);
            objArray.add(objProductDet);
        }
        return objArray;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "FETCH_PRODUCT_DETAIL")
    public PRODUCT_DETAIL FETCH_PRODUCT_DETAIL(@WebParam(name = "PROD_ID") String PROD_ID) {
        String selectProductDetail = "EXEC SP_PRODUCT_DETAIL @FLAG='PD',@PRODUCT_ID=" + PROD_ID;
        CMNFunctions objCMNFunc = new CMNFunctions().executeStoredProcedure(selectProductDetail);
        PRODUCT_DETAIL objProductDet = new PRODUCT_DETAIL();
        if (objCMNFunc.sts == 0) {
            resultSet = objCMNFunc.rs;
            try {
                while (resultSet.next()) {
                    objProductDet.setCODE(resultSet.getString(1));
                    objProductDet.setMSG(resultSet.getString(2));
                    objProductDet.setPRODUCT_ID(resultSet.getInt(3));
                    objProductDet.setCATEGORY_ID(resultSet.getInt(4));
                    objProductDet.setPRODUCT_NAME(resultSet.getString(5));
                    objProductDet.setPRICE(resultSet.getFloat(6));
                    objProductDet.setAVAILIABLE_STOCK(resultSet.getString(7));
                    objProductDet.setDATE_ADDED(resultSet.getString(8));
                    objProductDet.setPRODUCT_IMG(resultSet.getString(9));
                    objProductDet.setBRAND_NAME(resultSet.getString(10));
                }
                resultSet.close();
                objCMNFunc.con.close();
            } catch (SQLException ex) {
                objProductDet.setMSG(ex.toString());
            }
        } else {
            objProductDet.setMSG(objCMNFunc.msg);
        }
        return objProductDet;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "TRANSACTION_CREATE")
    public TXCREATERES TRANSACTION_CREATE(@WebParam(name = "email") String email,
            @WebParam(name = "aunthenticationId") String aunthenticationId,
            @WebParam(name = "accessKey") String accessKey,
            @WebParam(name = "productId") String productId,
            @WebParam(name = "quantity") String quantity) {

        String selectProductDetail = "EXEC SP_TRANSACTION_DETAIL @FLAG='C',@EMAIL='" + email + "',"
                + "@AUTH_ID='" + aunthenticationId + "'"
                + ",@ACCESS_KEY='" + accessKey + "',"
                + "@PRODUCT_ID='" + productId + "',@QUANTITY=" + quantity;
        CMNFunctions objCMNFunc = new CMNFunctions().executeStoredProcedure(selectProductDetail);
        TXCREATERES objCMNRES = new TXCREATERES();
        if (objCMNFunc.sts == 0) {
            resultSet = objCMNFunc.rs;
            try {
                while (resultSet.next()) {
                    objCMNRES.setCODE(resultSet.getString(1));
                    objCMNRES.setMSG(resultSet.getString(2));
                    if (objCMNRES.getCODE().equals("0")) {
                        objCMNRES.setTXN_ID(resultSet.getString(3));
                    }
                }
                resultSet.close();
                objCMNFunc.con.close();
            } catch (SQLException ex) {
                objCMNRES.setCODE("EXECPTIONERR");
                objCMNRES.setMSG(ex.toString());
            }
        } else {
            objCMNRES.setCODE("resultsetERR");
            objCMNRES.setMSG(objCMNFunc.msg);
        }
        return objCMNRES;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "TRANSACTION_CANCEL")
    public CMNRES TRANSACTION_CANCEL(@WebParam(name = "email") String email,
            @WebParam(name = "aunthenticationId") String aunthenticationId,
            @WebParam(name = "accessKey") String accessKey,
            @WebParam(name = "productId") String transactionId) {

        String selectProductDetail = "EXEC SP_TRANSACTION_DETAIL @FLAG='R',@EMAIL='" + email + "',"
                + "@AUTH_ID='" + aunthenticationId + "'"
                + ",@ACCESS_KEY='" + accessKey + "',"
                + "@TX_ID='" + transactionId + "'";
        CMNFunctions objCMNFunc = new CMNFunctions().executeStoredProcedure(selectProductDetail);
        CMNRES objCMNRES = new CMNRES();
        if (objCMNFunc.sts == 0) {
            resultSet = objCMNFunc.rs;
            try {
                while (resultSet.next()) {
                    objCMNRES.setCODE(resultSet.getString(1));
                    objCMNRES.setMSG(resultSet.getString(2));
                }
                resultSet.close();
                objCMNFunc.con.close();
            } catch (SQLException ex) {
                objCMNRES.setCODE("EXECPTIONERR");
                objCMNRES.setMSG(ex.toString());
            }
        } else {
            objCMNRES.setCODE("resultsetERR");
            objCMNRES.setMSG(objCMNFunc.msg);
        }
        return objCMNRES;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "TRANSACTION_PAYMENT")
    public TXCOMPLETERES TRANSACTION_PAYMENT(@WebParam(name = "email") String email,
            @WebParam(name = "aunthenticationId") String aunthenticationId,
            @WebParam(name = "accessKey") String accessKey,
            @WebParam(name = "transactionId") String transactionId) {

        String selectProductDetail = "EXEC SP_TRANSACTION_DETAIL @FLAG='P',@EMAIL='" + email + "',"
                + "@AUTH_ID='" + aunthenticationId + "'"
                + ",@ACCESS_KEY='" + accessKey + "',"
                + "@TX_ID='" + transactionId + "',@UPDATED_BY='DEFAULT'";
        CMNFunctions objCMNFunc = new CMNFunctions().executeStoredProcedure(selectProductDetail);
        TXCOMPLETERES objTXCOMPLETERES = new TXCOMPLETERES();
        if (objCMNFunc.sts == 0) {
            resultSet = objCMNFunc.rs;
            try {
                while (resultSet.next()) {
                    objTXCOMPLETERES.setCODE(resultSet.getString(1));
                    objTXCOMPLETERES.setMSG(resultSet.getString(2));
                    if (objTXCOMPLETERES.getCODE().equals("0")) {
                        objTXCOMPLETERES.setPRODUCT_NAME(resultSet.getString(3));
                        objTXCOMPLETERES.setORDERED_QUANTITY(resultSet.getString(4));
                        objTXCOMPLETERES.setTOTAL_PRICE(resultSet.getString(5));
                        objTXCOMPLETERES.setDISCOUNT_AMT(resultSet.getString(6));
                        objTXCOMPLETERES.setAMT_AFTER_DISCOUNT(resultSet.getString(7));
                    }
                }
                resultSet.close();
                objCMNFunc.con.close();
            } catch (SQLException ex) {
                objTXCOMPLETERES.setCODE("EXCEPTIONERR");
                objTXCOMPLETERES.setMSG(ex.toString());
            }
        } else {
            objTXCOMPLETERES.setMSG(objCMNFunc.msg);
        }
        return objTXCOMPLETERES;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "TRANSACTION_DETAILS")
    public ArrayList<TRANSACTION_DETAIL> TRANSACTION_DETAILS(@WebParam(name = "email") String email, 
            @WebParam(name = "authenticationId") String authenticationId, 
            @WebParam(name = "accessKey") String accessKey, 
            @WebParam(name = "portalName") String portalName) {
        
       String execSpTX = "EXEC [SP_TRANSACTION_DETAIL] @FLAG='D',@EMAIL='" + email + 
               "',@AUTH_ID='" + authenticationId + "'" +
               ",@ACCESS_KEY='" + accessKey + "',@PORTAL_NAME='" + portalName + "'";
        ArrayList<TRANSACTION_DETAIL> objArray = new ArrayList<>();
        CMNFunctions objCMNFunc = new CMNFunctions().executeStoredProcedure(execSpTX);

        if (objCMNFunc.sts == 0) {
            resultSet = objCMNFunc.rs;
            try {
                while (resultSet.next()) {
                    TRANSACTION_DETAIL objTXDET = new TRANSACTION_DETAIL();
                    objTXDET.setCODE(resultSet.getString(1));
                    objTXDET.setMSG(resultSet.getString(2));
                    
                    if(objTXDET.getCODE().equals("0")){
                       objTXDET.setTX_ID(resultSet.getString(3));
                       objTXDET.setTX_AMOUNT(resultSet.getString(4));
                       objTXDET.setTX_QTY(resultSet.getString(5));
                       objTXDET.setDISCOUNT(resultSet.getString(6));
                       objTXDET.setTX_STS(resultSet.getString(7));
                       objTXDET.setTX_TS(resultSet.getString(8));
                       objTXDET.setUPDATED_BY(resultSet.getString(9));
                       objTXDET.setUPDATED_TS(resultSet.getString(10));
                       objTXDET.setCATEGORY_NAME(resultSet.getString(11));
                       objTXDET.setPRODUCT_NAME(resultSet.getString(12));
                       objTXDET.setPRODUCT_IMG(resultSet.getString(13));
                       objTXDET.setBRAND_NAME(resultSet.getString(14));
                    }
                    objArray.add(objTXDET);
                }
                resultSet.close();
                objCMNFunc.con.close();
            } catch (SQLException ex) {
                TRANSACTION_DETAIL objTXDET = new TRANSACTION_DETAIL();
                objTXDET.setCODE("ExERR");
                objTXDET.setMSG(ex.toString());
                objArray.add(objTXDET);
            }
        } else {
            TRANSACTION_DETAIL objTXDET = new TRANSACTION_DETAIL();
            objTXDET.setMSG(objCMNFunc.msg);
            objArray.add(objTXDET);
        }
        return objArray;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CUSTOMER_LOGOUT")
    public CMNRES CUSTOMER_LOGOUT(@WebParam(name = "email") String email, 
            @WebParam(name = "accessKey") String accessKey, 
            @WebParam(name = "authenticationId") String authenticationId) {
        CMNRES objCMNRES = new CMNRES();
        String execSpCust = "EXEC [SP_CUSTOMER_DETAIL] @FLAG='L',@EMAIL='" + email + 
               "',@AUTH_ID='" + authenticationId + "'" +
               ",@ACCESS_KEY='" + accessKey + "'";
         CMNFunctions objCMNFunc = new CMNFunctions().executeStoredProcedure(execSpCust);

        if (objCMNFunc.sts == 0) {
            resultSet = objCMNFunc.rs;
            try {
                while (resultSet.next()) {
                    objCMNRES.setCODE(resultSet.getString(1));
                    objCMNRES.setMSG(resultSet.getString(2));
                }
                resultSet.close();
                objCMNFunc.con.close();
            } catch (SQLException ex) {
                objCMNRES.setCODE("EXERR");
                objCMNRES.setMSG(ex.toString());
            }
        } else {
            objCMNRES.setMSG(objCMNFunc.msg);
        }
        return objCMNRES;
    }
}
