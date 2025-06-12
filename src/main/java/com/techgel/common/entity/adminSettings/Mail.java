package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import com.techgel.common.entity.enums.MailType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mail")
public class Mail extends BasedEntity {
    private String host;
    private int port;
    private String username;
    private String password;
    private boolean smtpAuth;
    private boolean smtpSecured;
    private String fromEmail;
    private String senderName;
    private String emailSubject;
    @Lob
    private String emailContent;
    @Enumerated()
    private MailType mailType;

    public Mail(Long id, String host, int port, String username, String password, boolean smtpAuth, boolean smtpSecured, String fromEmail, String senderName, String emailSubject, String emailContent, MailType mailType) {
        super(id);
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.smtpAuth = smtpAuth;
        this.smtpSecured = smtpSecured;
        this.fromEmail = fromEmail;
        this.senderName = senderName;
        this.emailSubject = emailSubject;
        this.emailContent = emailContent;
        this.mailType = mailType;
    }
}
