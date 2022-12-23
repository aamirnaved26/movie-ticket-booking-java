package utilityPkg;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDao {
    public static MyDao md = null;
    private MyDao(){
        
    }
    
    public static MyDao getInstance(){
        if(md==null){
            md = new MyDao();
        }
        
        return md;
    }
    
    public Statement getConnection(String url,String user,String password) throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,user,password).createStatement();
    }
    public boolean dataLoader(Statement st, String query) throws SQLException{
        return st.execute(query);
    }
    public ResultSet fetchData(Statement st, String query) throws SQLException{
        return st.executeQuery(query);
    }
    public boolean deleteData(Statement st, String query) throws SQLException{
        return st.execute(query);
    }
}

