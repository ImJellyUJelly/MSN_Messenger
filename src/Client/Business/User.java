package Client.Business;

import Client.Business.Enums.StatusType;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser {
    private String emailAddress;
    private String name;
    private String password;
    private String personalMessage;
    private StatusType status;
    private Image profilePicture;

    private List<IUser> contactList;

    public User() {
        contactList = new ArrayList<>();
    }

    // Getters & Setters
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
    public void addContact(IUser contact) {
        contactList.add(contact);
    }

    public void removeContact(IUser contact) {
        contactList.remove(contact);
    }

    public List<IUser> getContacts() {
        return contactList;
    }

    public void sendMessage(Message message) {

    }

    @Override
    public String toString() {
        return name;
    }
}
