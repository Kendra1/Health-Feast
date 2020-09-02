package sbnz.event;

import org.springframework.context.ApplicationEvent;

import sbnz.model.User;

public class RegistrationSuccessEvent extends ApplicationEvent {

    private User user;

    public RegistrationSuccessEvent(User user) {
        super(user);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
