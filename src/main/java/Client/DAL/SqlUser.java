package Client.DAL;

import Client.Business.Enums.StatusType;
import Client.Business.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlUser {
    private SqlConnection connection;

    public SqlUser(String dbUsername, String dbPassword) {
        connection = new SqlConnection(dbUsername, dbPassword);
    }

    public User getUser(String emailaddress, String password) {
        try {
            connection.setStatement(connection.getConnection().createStatement());
            String query = "SELECT UserId, UFullName, UPersonalMessage, UStatus FROM Userobject WHERE UEmailaddress = ? AND UPassword = ?;";

            PreparedStatement ps = connection.getConnection().prepareStatement(query);

            ps.setString(1, emailaddress);
            ps.setString(2, password);

            connection.setResult(ps.executeQuery());

            connection.getResult().next();
            int userId = connection.getResult().getInt(1);
            String name = connection.getResult().getString(2);
            String personalMessage = connection.getResult().getString(3);
            StatusType status = StatusType.valueOf(connection.getResult().getString(4));

            User user = new User(userId, name, emailaddress, password, personalMessage, status);

            return user;

        } catch(SQLException sex) {
            System.out.println("Query is fout denk");
            sex.printStackTrace();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            connection.closeAll();
        }
        return null;
    }

    public List<User> getFriendlist(int userId) {
        try {
            connection.setStatement(connection.getConnection().createStatement());
            String query = "SELECT ub.UserId, ub.UFullName, ub.UEmailaddress, ub.UPersonalMessage, ub.UStatus FROM Friendlist JOIN Userobject us ON us.UserId = FlUserId JOIN Userobject ub ON ub.UserId = FlFriendId WHERE us.UserId = ?;";

            PreparedStatement ps = connection.getConnection().prepareStatement(query);

            ps.setInt(1, userId);

            connection.setResult(ps.executeQuery());

            List<User> users = new ArrayList<>();
            while(connection.getResult().next()) {
                int id = connection.getResult().getInt(1);
                String name = connection.getResult().getString(2);
                String emailaddress = connection.getResult().getString(3);
                String personalMessage = connection.getResult().getString(4);
                StatusType status = StatusType.valueOf(connection.getResult().getString(5));

                users.add(new User(id, name, emailaddress, personalMessage, status));
            }
            return users;

        } catch(SQLException sex) {
            System.out.println("Query is fout denk");
            sex.printStackTrace();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            connection.closeAll();
        }
        return null;
    }
}
