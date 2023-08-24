package com.example.demo.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service // Serve para ser instanciada a partir de um injecao de dependencia
@Slf4j // Serve para criar logs de menssagens informativcas
public class SendEmailService {

    @Autowired
    private final JavaMailSender envioDeEmail;

    public SendEmailService(final JavaMailSender javaMailSender){
        this.envioDeEmail = javaMailSender;
    }

    public void enviar (String para, String titulo, String conteudo){
        log.info("Enviando email para confirmacao de cadastro...");

        var menssagem = new SimpleMailMessage();
        menssagem.setTo(para);
        menssagem.setSubject(titulo);
        menssagem.setText(conteudo);
        envioDeEmail.send(menssagem);
        log.info("Email enviado com sucesso.");
    }

}
