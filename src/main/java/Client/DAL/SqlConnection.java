package Client.DAL;

import java.sql.*;

/**
 * Created by user on 26-9-2017.
 */
public class SqlConnection {
    private Connection connection;
    private Statement statement;
    private ResultSet result;

    public SqlConnection(String username, String password){
        connection = setConnection(username, password);
    }

    public Connection getConnection() {
        return connection;
    }

    // Deze is static omdat we niet weten waarom het static moet zijn, maar er genoeg reden voor waren, alleen die hebben we niet meer onthouden.
    public static Connection setConnection(String username, String password){
        try{
            String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(dbDriver).newInstance();

            return DriverManager.getConnection("jdbc:sqlserver://studsql01.fhict.local;databaseName=dbi299244;", username, password);
        }
        catch(Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResult() {
        return result;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }

    private void closeStatement(){
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeResultSet(){
        if (result != null) {
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeConnection(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeAll(){
        closeResultSet();
        closeStatement();
        closeConnection();
    }
}