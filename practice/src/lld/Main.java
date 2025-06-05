package lld;

import lld.Movire.Movie;
import lld.Movire.Theater;
import lld.User.User;
import lld.show.Show;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie(1,"abc");
        Movie movie1 = new Movie(2,"abcd");
        Movie movie2 = new Movie(3,"abcef");

        Theater theater= new Theater(1,"PVR");
        Show show = new Show(1,movie,theater,10);


        User user1 = new User( 1,"Shourya","xyz@gmail.com");
        User user2 = new User( 2,"Yash","abc@gmail.com");

        BookingService service = new BookingService();

        Thread t1 = new Thread(()->service.book(user1,show, Arrays.asList(1,2)));
        Thread t2 = new Thread(()->service.book(user2,show, Arrays.asList(1,2,3)));

        t1.start();
        t2.start();





    }
}
