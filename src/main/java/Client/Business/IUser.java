package Client.Business;

import Client.Business.Enums.StatusType;
import javafx.scene.image.Image;

import java.util.List;

public interface IUser {
    int getId();
    String getEmailaddress();
    String getPassword();
    String getPersonalMessage();
    StatusType getStatus();
    Image getProfilePicture();
    String getName();
    void setFriendList(List<User> friends);
    List<User> getFriendList();
    void addFriend(User user);
    void removeFriend(User user);
}
