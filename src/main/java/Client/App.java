package Client;

import Client.Business.User;
import Client.DAL.SqlUser;

public class App {
    private SqlUser sqlUser;
    private User user;

    public App() {
        setSqlUser();
    }

    private void setSqlUser() {
        sqlUser = new SqlUser("dbi299244", "PTS3Groep1");
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void login(String emailAddress, String password) {
        setUser(sqlUser.getUser(emailAddress, password));
        setSqlUser();
        user.setFriendList(sqlUser.getFriendlist(user.getId()));
    }
}
