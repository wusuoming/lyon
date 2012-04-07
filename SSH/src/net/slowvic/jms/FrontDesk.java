package net.slowvic.jms;

import net.slowvic.modal.bean.Mail;

public interface FrontDesk {
    /**
     * 发送邮件
     * @param mail
     */
    void sendMail(Mail mail);
}
