package com.marcos.hexagonal.adapters.out;

import com.marcos.hexagonal.application.ports.out.SendCpfToValidationOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfToValidationOutputPort {

    @Autowired
    private KafkaTemplate<String, String> kakfaTemplate;

    @Override
    public void send(String cpf) {
        kakfaTemplate.send("tp-cpf-validation", cpf);
    }
}
