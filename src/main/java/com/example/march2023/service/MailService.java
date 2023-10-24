package com.example.march2023.service;

import com.example.march2023.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailService {
    private final MailSender mailSender;

    public void notifyCreatorCar(CarDto createdCar){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(System.getProperty("spring.mail.username"));
        message.setTo("gulini32@gmail.com");
        message.setSubject("New Car");
        message.setText("A new car was creator id: %d, model: %s, producer: %s, power: %d".formatted(createdCar.getId(), createdCar.getModel(), createdCar.getProducer(), createdCar.getPower()));
        mailSender.send(message);
    }

    public void notifyDeleteCar(int id){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(System.getProperty("spring.mail.username"));
        message.setTo("gulini32@gmail.com");
        message.setSubject("delete Car");
        message.setText("car with id: %d was delete".formatted(id));
        mailSender.send(message);
    }
}
