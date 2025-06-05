package lld.notifier;

public class SmsNotification implements Notifier{
    @Override
    public void notify(String recepeint, String message) {
        System.out.println("Send SMS to "+ recepeint +":"+message);
    }
}
