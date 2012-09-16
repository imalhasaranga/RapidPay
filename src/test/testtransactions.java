/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.*;

/**
 *
 * @author Imal
 */
public class testtransactions {

    public void modifyPricesByPercentage(String coffeeName,float priceModifier,float maximumPrice)throws SQLException {
        Connection con = DriverManager.getConnection("");
        con.setAutoCommit(false);

        Statement getPrice = null;
        Statement updatePrice = null;
        ResultSet rs = null;
        String query =
                "SELECT COF_NAME, PRICE FROM COFFEES "
                + "WHERE COF_NAME = '" + coffeeName + "'";

        try {
            Savepoint save1 = con.setSavepoint();
            getPrice = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            updatePrice = con.createStatement();
         
                rs = getPrice.executeQuery(query);
                rs.first();
                float oldPrice = rs.getFloat("PRICE");
                float newPrice = oldPrice + (oldPrice * priceModifier);
               

                updatePrice.executeUpdate(
                        "UPDATE COFFEES SET PRICE = "
                        + newPrice
                        + " WHERE COF_NAME = '"
                        + coffeeName + "'");

               
               
                
                con.commit();
            
        } catch (SQLException e) {
           
        } finally {
            if (getPrice != null) {
                getPrice.close();
            }
            if (updatePrice != null) {
                updatePrice.close();
            }
            con.setAutoCommit(true);
        }
    }
}
