package ex3;

public class Main 
{
    public static void main(String[] args) 
    {
        IChatRoom chatroom = new ChatRoom();
         
        User user1 = new ChatUser(chatroom,"1", "Cristiano Ronaldo");
        User user2 = new ChatUser(chatroom,"2", "Jorge Jesus");
        User user3 = new ChatUser(chatroom,"3", "José Mourinho");
        User user4 = new ChatUser(chatroom,"4", "João Félix");
         
        chatroom.addUser(user1);
        chatroom.addUser(user2);
        chatroom.addUser(user3);
        chatroom.addUser(user4);
 
        user1.send("Hello Jorge Jesus", "2");
        user2.send("Hey Cristiano Ronaldo", "1");
    }
}
