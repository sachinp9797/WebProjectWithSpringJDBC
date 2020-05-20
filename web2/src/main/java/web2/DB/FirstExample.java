package web2.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.springframework.stereotype.Component;


@Component
public class FirstExample {
    // JDBC driver name and database URL

    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@msi-l2047:1521:orcl";

    //  Database credentials
    static final String USER = "SP99";
    static final String PASS = "SP99";

    public String getEmployees() {
    	
    	String names = "";
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("conn" +  "  "  + conn);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            System.out.println("stmt" +  "  "  + stmt);
            String sql;
            sql = "SELECT id, first, last, age FROM Employee";
            ResultSet rs = stmt.executeQuery(sql);
            
            PreparedStatement stmt2 = conn.prepareStatement("update Employee set last = ? where id = ?");
            stmt2.setString(1, "Khan");
            stmt2.setLong(2, 100);
            
//            PreparedStatement stmt3 = conn.prepareStatement("insert into Employee values(?, ?, ? ,?)");
//            stmt3.setInt(1, 34);
//            stmt3.setInt(2, 20);
//            
//            stmt3.setString(3, "Khan");
//            stmt3.setObject(4, new Student(0, "sachin"));


//            System.out.println("rs" +  "  "  + rs.next());

            Res rs2 = stmt2.executeUpdate();
            
//            stmt3.execute();


            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                names = first;
                String last = rs.getString("last");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt2.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        
        return names;
    }//end main
}