package model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public final class DB {

    public static Connection con;

    public static Connection getmyCon() throws Exception {
        Property prop = null;
        
        if (con == null) {
            try {
                FileInputStream condata1 = new FileInputStream(System.getProperty("user.dir") + "/data1.dat");
                ObjectInputStream input = new ObjectInputStream(condata1);
                prop = (Property) input.readObject();
                input.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            Class.forName(prop.getDriver()).newInstance();
            con = DriverManager.getConnection("jdbc:mysql://" + prop.getHost() + ":" + prop.getPort() + "/tutionDb?autoReconnect=true", prop.getUsername(), prop.getPassword());
        }
        return con;
    }

    public static ResultSet getResultset(String sql) throws Exception {
        getmyCon();
        return con.createStatement().executeQuery(sql);
    }

    public static void stexecuteUpdate(String sql) throws Exception {
        getmyCon();
        con.createStatement().executeUpdate(sql);
    }

    public static PreparedStatement Preparestatement(String sql) throws Exception {
        getmyCon();
        return con.prepareStatement(sql);
    }

    public static String lastinsertId(String table, String selectinid, Connection con) throws Exception {
        System.out.println("select max(" + selectinid + ") as id1 from " + table + " ");
        ResultSet res = con.createStatement().executeQuery("select max(" + selectinid + ") as id1 from " + table + " ");
        if (res.next()) {
            return res.getString("id1") == null ? "0" : res.getString("id1");
        }
        return "0";
    }
}
