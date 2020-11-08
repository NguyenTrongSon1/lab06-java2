package lab6;

import java.sql.*;

public class vd {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop","root","");

                Statement stmt = conn.createStatement();
                ){
            String strUpdate = "update books set price * 0.7, qty = qty + 1 where id = 1001";
            System.out.println("The SQL statement is: " + strUpdate + "\n");
            int coundUpdate = stmt.executeUpdate(strUpdate);
            System.out.println(coundUpdate + "record affacted.\n");

            String strSelect = "select * from books where id = 1001";
            System.out.println("The SQL is: " +strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                System.out.println(rset.getInt("id") + ","
                            + rset.getString("title") + ","
                            + rset.getString("author") + ","
                            + rset.getDouble("price") + ","
                            + rset.getInt("qty"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
