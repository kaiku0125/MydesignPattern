package Mediator_Pattern;

public class TestDrive {
    public static void main(String[] args) {
        ChatRoomMediator chat = new ChatRoom();

        AbstractUser jack = new User("Jack", chat);
        AbstractUser rose = new User("Rose", chat);
        AbstractUser kevin = new User("kevin", chat);

        chat.addUser(jack);
        chat.addUser(rose);
        chat.addUser(kevin);

        kevin.send("hello guys~?");

    }
}
