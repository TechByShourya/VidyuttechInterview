package lld;

import lld.User.User;
import lld.notifier.EmailNotification;
import lld.notifier.Notifier;
import lld.notifier.SmsNotification;
import lld.payment.Payment;
import lld.show.Show;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    Payment payment = new Payment();
    List<Notifier> notifiers =new ArrayList<>();
    public BookingService(){
        notifiers.add(new EmailNotification());
        notifiers.add(new SmsNotification());
    }

    public void book(User user, Show show, List<Integer> noOfSeats){
        boolean isLocked;
        synchronized (show){isLocked=show.bookSeats(noOfSeats);}
        if(!isLocked){
            System.out.println("Ticket Has been booked");
            return;
        }
        if(payment.process(250*noOfSeats.size())==Payment.Status.SUCCESS){
            for(Notifier notifier : notifiers){
                notifier.notify(user.userEmail,"Booking confirmed: "+ user.personName);
            }

        }else{
            System.out.println("Payment Failed");
        }
    }
}
