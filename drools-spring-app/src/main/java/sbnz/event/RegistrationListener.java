package sbnz.event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import sbnz.model.ConfirmationToken;
import sbnz.model.User;
import sbnz.repository.ConfirmationTokenRepository;

@Component
public class RegistrationListener implements ApplicationListener<RegistrationSuccessEvent> {

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void onApplicationEvent(RegistrationSuccessEvent onRegistrationSuccessEvent) {
        this.confirmRegistration(onRegistrationSuccessEvent);
    }

    private void confirmRegistration(RegistrationSuccessEvent onRegistrationSuccessEvent) {

        User user = onRegistrationSuccessEvent.getUser();

        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        confirmationTokenRepository.save(confirmationToken);

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Registration confirmation");
        email.setText("Dear " + user.getName() + " " + user.getLastName() + ", \n\n" +
                "To confirm your account, please click the following link: \n"
                + "http://localhost:8081/api/auth/confirmAccount?token=" + confirmationToken.getToken()
        +   "\n\nPlease, confirm your account in next 24 hours. Otherwise, you will have to register again. \nThank you!");
        javaMailSender.send(email);
    }

}
