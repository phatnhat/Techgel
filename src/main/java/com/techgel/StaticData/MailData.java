package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.Mail;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.enums.MailType;

import java.util.List;

public abstract class MailData {
    public static List<Mail> get() {
        return List.of(
                new Mail(1L, "smtp.gmail.com", 587, "info.techgel.mep@gmail.com", "xnxy apph lqjv rmhc", true, true, "info.techgel.mep@gmail.com",
                        "Techgel", "Ứng tuyển vị trí", "<div style=\"max-width: 600px; margin: auto; background-color: #ffffff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);\"><div style=\"background-color: #28a745; color: white; padding: 15px; border-radius: 8px 8px 0 0; text-align: center;\"><h2 style=\"margin: 0;\">THƯ ỨNG TUYỂN VIỆC LÀM</h2></div><div style=\"padding: 20px; color: #333333;\"><p><strong style=\"display: inline-block; width: 100px;\">Họ và tên:</strong><span>[[fullname]]</span></p><p><strong style=\"display: inline-block; width: 100px;\">Email:</strong><span>[[email]]</span></p><p><strong style=\"display: inline-block; width: 100px;\">SĐT:</strong><span>[[phone]]</span></p><p><strong style=\"display: inline-block; width: 100px;\">Vị trí:</strong><span>[[position]]</span></p><p><strong>Thư giới thiệu:</strong></p><div style=\"background: #f8f8f8; padding: 15px; border-left: 4px solid #28a745; margin-top: 10px;\">[[message]]</div><p style=\"margin-top: 20px;\"><strong>File đính kèm:</strong> CV (xem trong phần đính kèm email)</p></div><div style=\"text-align: center; font-size: 12px; color: #999999; padding-top: 20px;\">Email này được gửi từ biểu mẫu ứng tuyển trên website.</div></div>", MailType.APPLY_JOB),

                new Mail(2L, "smtp.gmail.com", 587, "info.techgel.mep@gmail.com", "xnxy apph lqjv rmhc", true, true, "info.techgel.mep@gmail.com",
                        "Techgel", "Thông tin liên hệ", "<div style=\"max-width: 600px; margin: auto; background-color: #ffffff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);\"><div style=\"background-color: #007bff; color: white; padding: 15px; border-radius: 8px 8px 0 0; text-align: center;\"><h2 style=\"margin: 0;\">LIÊN HỆ TỪ WEBSITE</h2></div><div style=\"padding: 20px; color: #333333;\"><p><strong style=\"display: inline-block; width: 80px;\">Họ và tên:</strong><span>[[fullname]]</span></p><p><strong style=\"display: inline-block; width: 80px;\">SĐT:</strong><span>[[phone]]</span></p><p><strong style=\"display: inline-block; width: 80px;\">Email:</strong><span>[[email]]</span></p><p><strong>Nội dung:</strong></p><p>[[message]]</p></div><div style=\"text-align: center; font-size: 12px; color: #999999; padding-top: 20px;\">Email được gửi từ biểu mẫu liên hệ trên website.</div></div>", MailType.CONTACT)
        );
    }
}
