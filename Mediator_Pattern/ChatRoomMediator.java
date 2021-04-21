package Mediator_Pattern;

public interface ChatRoomMediator {
    void addUser(AbstractUser user);

    void sendMessage(AbstractUser user, String msg);
}
