package project.database;
import project.models.Property;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author sqlitetutorial.net
 */
public class DBConnection {

    public static Connection conn = null;
    static  Statement state=null;
    static  ResultSet res=null;
    /**
     * Connect to a sample database
     */
    public static Connection connect() {

        try {
            String dbName="jdbc:sqlite:/Applications/www/RentalSystem/src/project/database/db.sqlite3";

            // db parameters
                try {
                    Class.forName("org.sqlite.JDBC");

                String url = dbName;
                // create a connection to the database
                conn = DriverManager.getConnection(url);

                System.out.println("Connection to SQLite has been established.");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            return conn;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return  conn;

    }

    public void insert(  String streetName,String suburb,String streetNumber, String status,int numOfBedRoom) {
        String sql = "INSERT INTO property( streetNumber,suburb,status,numOfBedRoom,streetNumber) VALUES(?,?,?,?,?)";

        try (

                PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1,streetName);
                pstmt.setString(2,suburb);
                pstmt.setString(3,streetNumber);
                pstmt.setString(4,status);
                pstmt.setInt(5,numOfBedRoom);

                pstmt.executeUpdate();
                System.out.println("Property inserted successfully ");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }

    public static void view(){
        try {


            state = conn.createStatement();
            res = state.executeQuery("SELECT * FROM property ");
        }

        catch (SQLException e){
            e.printStackTrace();
        }





        try {
            while (res.next()) {


                String streetName  = res.getString("streetName");
                String streetNumber = res.getString("streetNumber");
                System.out.println(streetName  + "\t\t" + streetNumber);


            }
            }
            catch (SQLException e){
                    e.printStackTrace();
                }

    }




    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();

        DBConnection conn=new DBConnection();
        conn.insert( "Adisadel Street","connerstone","78333","available",3);

        view();


    }
}