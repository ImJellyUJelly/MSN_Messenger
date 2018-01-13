package Client.Business;

import Client.Business.Enums.StatusType;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class User implements IUser {
    private int id;
    private String emailAddress;
    private String name;
    private String password;
    private String personalMessage;
    private StatusType status;
    private Image profilePicture;

    private Socket socket;
    private String hostIP;
    private int port;

    private List<User> friendList;

    public User() throws IOException {
        friendList = new ArrayList<>();
        socket = new Socket();
        socket.connect(new InetSocketAddress(hostIP, port));
    }

    public User(int id, String name, String emailAddress, String password, String personalMessage, StatusType status) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.personalMessage = personalMessage;
        this.status = status;
    }

    public User(int id, String name, String emailAddress, String personalMessage, StatusType status) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.personalMessage = personalMessage;
        this.status = status;
    }

    // Getters & Setters
    @Override
    public int getId() {
        return id;
    }

    public String getEmailaddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAdress) {
        this.emailAddress = emailAdress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonalMessage() {
        return personalMessage;
    }

    public void setPersonalMessage(String personalMessage) {
        this.personalMessage = personalMessage;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public Image getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Image profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Methods
    public void setFriendList(List<User> friends) {
        friendList = friends;
    }

    public void addFriend(User contact) {
        friendList.add(contact);
    }

    public void removeFriend(User contact) {
        friendList.remove(contact);
    }

    public List<User> getFriendList() {
        return friendList;
    }

    public void sendMessage(Message message) {

    }

    @Override
    public String toString() {
        return name;
    }
}
