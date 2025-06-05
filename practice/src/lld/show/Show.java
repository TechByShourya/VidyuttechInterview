package lld.show;

import lld.Movire.Movie;
import lld.Movire.Seat;
import lld.Movire.Theater;

import java.util.ArrayList;
import java.util.List;

public class Show {
    int showId;
    Movie movie;
    Theater theater;
    List<Seat> seats = new ArrayList<>();

    public Show(int showId , Movie movie , Theater theater , int seatCount){
        this.showId = showId;
        this.movie = movie;
        this.theater=theater;
        for(int i=1;i<=seatCount;i++){
            seats.add(new Seat(i));
        }
    }

    public synchronized boolean bookSeats(List<Integer> seatNumber){
        for(int num : seatNumber){
            if(seats.get(num-1).isSeatBooked){
                return false;
            }
        }
        for(int num : seatNumber){
            seats.get(num-1).isSeatBooked=true;
        }
        return true;
    }
}
