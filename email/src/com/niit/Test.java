package com.niit;

public class Test
{
	public static void main(String[] args){   
        //�������Ҫ�������ʼ�   
     MailSenderInfo mailInfo = new MailSenderInfo();    
     mailInfo.setMailServerHost("smtp.126.com");    
     mailInfo.setMailServerPort("25");    
     mailInfo.setValidate(true);
     //���������û���������
     mailInfo.setUserName("xxxx@126.com");    
     mailInfo.setPassword("pwdxxxx");   
     //���÷����ʼ��������
     mailInfo.setFromAddress("xxx@126.com");  
     //�����ʼ�������
     mailInfo.setToAddress("xxx@qq.com");    
     mailInfo.setSubject("�����ʼ�");    
     //�����ʼ�����
     mailInfo.setContent("<a href='#'>test Content</a>");    
        //�������Ҫ�������ʼ�   
     SimpleMailSender sms = new SimpleMailSender();   
         //sms.sendTextMail(mailInfo);//���������ʽ    
         sms.sendHtmlMail(mailInfo);//����html��ʽ   
   }  

}
