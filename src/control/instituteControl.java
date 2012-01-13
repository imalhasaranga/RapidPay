
package control;

import java.io.Serializable;
import java.sql.ResultSet;
import model.DB;

/**
 *
 * @author Imal
 */
public final class instituteControl implements Serializable {

    private String instituteName;
    private String Addressno;
    private String Street;
    private String city;
    private String contact1;
    private String contact2;
    private String contact3;
    private String website;
    private String email;
    private String fax;
    instituteControl con = null;

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getAddressno() {
        return Addressno;
    }

    public void setAddressno(String Addressno) {
        this.Addressno = Addressno;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getContact3() {
        return contact3;
    }

    public void setContact3(String contact3) {
        this.contact3 = contact3;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public boolean addInstitute(instituteControl co) {

        try {

            DB.stexecuteUpdate("update institute_drtails set institute_name= '" + co.getInstituteName() + "',add_no= '" + co.getAddressno() + "',Street = '" + co.getStreet() + "',City = '" + co.getCity() + "',con1 = '" + co.getContact1() + "',con2='" + co.getContact2() + "',con3 = '" + co.getContact3() + "',web = '" + co.getWebsite() + "',email = '" + co.getEmail() + "',fax='" + co.getFax() + "' ");

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;

    }

    public instituteControl getInstitute(int i) throws Exception {

       // if (con == null && i == 0) {
            try {

                ResultSet rs = DB.getResultset("select* from institute_drtails");
                if (rs.next()) {
                    con = new instituteControl();

                    con.setInstituteName(rs.getString("institute_name"));
                    con.setAddressno(rs.getString("add_no"));
                    con.setStreet(rs.getString("Street"));
                    con.setCity(rs.getString("city"));
                    con.setContact1(rs.getString("con1"));
                    con.setContact2(rs.getString("con2"));
                    con.setContact3(rs.getString("con3"));
                    con.setWebsite(rs.getString("email"));
                    con.setEmail(rs.getString("web"));
                    con.setFax(rs.getString("fax"));

                }

            } catch (Exception e) {
                System.out.println(e);

          //  }
            return con;

        }
        return con;

    }
}
