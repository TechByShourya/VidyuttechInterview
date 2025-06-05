package lld.notifier;

public class EmailNotification implements Notifier{
    public void notify(String recepeint, String message){
        System.out.println("Send email to "+ recepeint+":"+message);
    }
}
