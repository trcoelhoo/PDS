package ex3;
import java.util.*;
public class ChatRoom implements IChatRoom {
 
    private Map<String, User> usersMap = new HashMap<>();
 
    @Override
    public void sendMessage(String msg, String userId) 
    {
        User usr = usersMap.get(userId);
        usr.receive(msg);
    }
 
    @Override
    public void addUser(User user) {
        this.usersMap.put(user.getId(), user);
    }
}