package Mediator_Pattern;

public class User extends AbstractUser {
    ChatRoomMediator chatRoomMediator;

    public User(String name, ChatRoomMediator chatRoomMediator) {
        this.name = name;
        this.chatRoomMediator = chatRoomMediator;
    }

    @Override
    void send(String msg) {
        chatRoomMediator.sendMessage(this, msg);
    }

    @Override
    void receive(String msg) {
        System.out.println(name + " reveive " + msg);
    }
}
