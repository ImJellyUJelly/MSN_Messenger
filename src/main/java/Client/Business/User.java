package Client.Business;

import Client.Business.Enums.StatusType;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.scene.image.Image;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

    private List<User> friendList;

    public static void main(String[] args) throws IOException {
        User user = new User(0, "Jelle Schräder", "jelleschrader@killerapp.fontys", "Hoi", StatusType.Online);
        user.start(user.getName());
    }

    public void start(String name) throws IOException {
        Socket socket;

        socket = new Socket("127.0.0.1", 4567);

        OutputStream out = socket.getOutputStream();
        out.write(("Hello, I'm " + name).getBytes());

        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[512];
        while (true) {
            inputStream.read(buffer);
            System.out.println(new String(buffer));
        }
    }

    public User() {
        friendList = new ArrayList<>();
    }

    public User(int id, String name, String emailAddress, String password, String personalMessage, StatusType status) throws IOException {
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

    public void sendMessage(String message) {

    }

    @Override
    public String toString() {
        return name;
    }
}
