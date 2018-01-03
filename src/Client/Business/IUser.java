package Client.Business;

import Client.Business.Enums.StatusType;
import javafx.scene.image.Image;

import java.util.List;

public interface IUser {
    String getEmailaddress();
    String getPassword();
    String getPersonalMessage();
    StatusType getStatus();
    Image getProfilePicture();
    String getName();
    List<IUser> getContacts();
    void addContact(IUser user);
    void removeContact(IUser user);
}
