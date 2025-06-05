package lld.payment;

public class Payment {
    public enum Status{SUCCESS,FAILURE}

    public Status process(double amount){
        return Status.SUCCESS;
    }
}
