package com.techgel.common.service.offline;

import com.techgel.StaticData.MailData;
import com.techgel.StaticData.NewsData;
import com.techgel.common.entity.adminSettings.Mail;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.enums.MailType;
import com.techgel.common.service.MailService;
import com.techgel.common.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("offline")
public class MailOfflineService implements MailService {

    public Mail getById(Long id){
        return this.getAll().stream().filter(mail -> mail.getId()
                .equals(id)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Mail not found"));
    }

    public List<Mail> getAll(){
        return MailData.get();
    }

    public Mail update(Mail mail){
        return null;
    }

    public Mail getByType(MailType type){
        return this.getAll().stream().filter(mail -> mail.getMailType().equals(type)).findFirst().orElse(null);
    }
}
