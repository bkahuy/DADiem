/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDiem;
import java.sql.*;
/**
 *
 * @author buikh
 */
public class XLDiem {
    private static Connection cn;
    
    public static void getcon(){
        if(cn == null ){
            try {
                cn = DriverManager.getConnection("jdbc:sqlserver://BKAHUYYYYY;database=DLDiem;user=sa;password=1;trustServerCertificate=true;");
                System.out.println("pass connect");
            } catch (SQLException e) {
                System.out.println("failed connect " + e.getMessage());
            }
        }
    }
    
    public static ResultSet getHV(){
        getcon();
        try {
            Statement st = cn.createStatement();
            return st.executeQuery("select * from tbHocvien");
        } catch (SQLException e) {
            System.out.println("getHV failed " + e.getMessage());
            return null;
        }
    }
    
    public static boolean insertHV(Hocvien hv){
        getcon();
        try {
            PreparedStatement pst = cn.prepareStatement("insert into tbHocvien values (?,?,?,?)");
            pst.setString(1, hv.getMahv());
            pst.setString(2, hv.getHoten());
            pst.setString(3, hv.getLop());
            pst.setInt(4, hv.getDiem());
            int res = pst.executeUpdate();
            return res>0;
        } catch (SQLException e) {
            System.out.println("insertHV failed " + e.getMessage());
            return false;
        }
    }
    //dành cho ai không học Gui thì làm console
//    public static void main(String[] args) {
//        getcon();
//        getHV();
//        Hocvien hv = new Hocvien("hv4", "kahuy", "64HTTT3", 45);
//        insertHV(hv);
//    }
}
