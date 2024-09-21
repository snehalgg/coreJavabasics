interface Notification {
    void sendNotification(String message);
}
class EmailNotification implements Notification {
    private String recipientEmail;

    public EmailNotification(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public void sendNotification(String message) {
        System.out.println("Sending an email to " + recipientEmail + ": " + message);
       
    }
}
class SmsNotification implements Notification {
    private String recipientPhoneNumber;

    public SmsNotification(String recipientPhoneNumber) {
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public void sendNotification(String message) {
        System.out.println("Sending an SMS to " + recipientPhoneNumber + ": " + message);

    }
}

class NotificationService {
    public void sendNotificationMessage(Notification notification, String message) {
        notification.sendNotification(message);
    }
}
public class notify {
    public static void main(String[] args) {
        Notification emailNotification = new EmailNotification("urusaibakayaro@example.com");
        Notification smsNotification = new SmsNotification("9988776655");

        NotificationService notificationService = new NotificationService();
        notificationService.sendNotificationMessage(emailNotification, "Konnichiwa, this is an email notification.");
        notificationService.sendNotificationMessage(smsNotification, "Yo, this is an SMS notification.");
    }
}