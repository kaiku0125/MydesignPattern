package Mediator_Pattern;

import java.util.ArrayList;

public class ChatRoom implements ChatRoomMediator {
    private ArrayList<AbstractUser> userlist = new ArrayList<AbstractUser>();

    @Override
    public void addUser(AbstractUser user) {
        userlist.add(user);

    }

    @Override
    public void sendMessage(AbstractUser user, String msg) {
        userlist.forEach((e) -> {
            if (e.getname() != user.getname()) {
                e.receive(msg);
            }
        });

    }
}
