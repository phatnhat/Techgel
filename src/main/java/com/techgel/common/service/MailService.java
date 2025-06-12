package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.Mail;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.enums.MailType;

import java.util.List;

public interface MailService {
    Mail getById(Long id);
    List<Mail> getAll();
    Mail update(Mail mail);

    Mail getByType(MailType mailType);
}
