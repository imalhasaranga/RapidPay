/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import model.DB;

/**
 *
 * @author Imal
 */
public class epf {
    
    public static void main(String[] args) {
        try {
            Connection con = DB.getmyCon();
           
            
            Scanner scan = new Scanner(new File("D:/a.txt"));
            while(scan.hasNext()){
             String line = scan.nextLine();
             String ar[] = line.split(" ");
             
             String a[] =ar[0].split("-");
             String b[] =ar[2].split("-");
             String c[] =ar[4].split("-");
                System.out.println("INSERT INTO PAYE(afrom,ato,aval) values('"+a[0]+"','"+a[1]+"','"+ar[1]+"')");
             con.createStatement().executeUpdate("INSERT INTO PAYE(afrom,ato,aval) values('"+a[0]+"','"+a[1]+"','"+ar[1]+"')");
             con.createStatement().executeUpdate("INSERT INTO PAYE(afrom,ato,aval) values('"+b[0]+"','"+b[1]+"','"+ar[3]+"')");
             con.createStatement().executeUpdate("INSERT INTO PAYE(afrom,ato,aval) values('"+c[0]+"','"+c[1]+"','"+ar[5]+"')");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
    
}
