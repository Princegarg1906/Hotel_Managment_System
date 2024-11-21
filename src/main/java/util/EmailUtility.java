package util;

import javax.mail.*;
import javax.mail.Authenticator;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailUtility {

//    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_HOST = "smtp.mail.yahoo.com";	
    private static final String SMTP_PORT = "587";
    private static final String FROM_EMAIL = "programcmp@yahoo.com";  // Replace with your email
    private static final String EMAIL_PASSWORD = "bgnz xaws wgof omlm";  // Replace with your email password

    // Method to send the verification email
    public static void sendVerificationEmail(String toEmail, String Username, String verificationCode) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, EMAIL_PASSWORD);
            }
        });

        try {
        	// Construct the email message
            String subject = "King Hotel System Registration - Please Verify Your Email";
            String body = "<h2>Thank you for registering with King Hotel System!</h2>" 
                          + "<p>Dear " + Username + ",</p>" 
                          + "<p>To complete your account setup, Entern the OTP giver to verify your email address:"+verificationCode+"\r\n</p>"
                          + "<p> For security purposes, this OTP will expire in 5 Minutes, so please verify your account soon.\r\n</p>"
                          + "<p> \r\n </p> </p>"
                          + "<p> If you didn't sign up for this account or believe this message was sent in error, please disregard this email.\r\n </p>"
                          + "<p> \r\n </p>"
                          + "<p> Need help?\r\n </p>"
                          + "<p> If you have any questions, feel free to reach out to our support team at +91-8708993158.\r\n </p>"
                          + "<p> \r\n </p>"
                          + "<p> We look forward to welcoming you to King Hotel!\r\n </p>"
                          + "<p> \r\n </p>"
                          + "<p> Warm regards,\r\n </p>"
                          + "<p> The King Hotel Team \r\n </p>"
                          + "<p> www.KingHotel.com\r\n </p>"
                          + "<p> www.Facebook.com/KingHotel </p>";
            

        	//create the message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            // Set the email content as HTML
            message.setContent(body, "text/html");
            
            // Send the email
            Transport.send(message);
            System.out.println("Verification email sent to: " + toEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error sending verification email.");
        }
    }
    
//    public static void main(String args[]) {
//    	try {
//    		sendVerificationEmail("princk1430@gmail.com","Prince","www.google.com");
//    		}catch(Exception e) {
//    			e.printStackTrace();
//    		}
//    }
}
