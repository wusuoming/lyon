package net.slowvic.jms;

import net.slowvic.modal.bean.Mail;

public interface BackOffice {
    /**
     * 接收邮件
     * @return
     */
    Mail receiveMail();
}
