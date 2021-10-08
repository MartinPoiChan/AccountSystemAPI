package za.ac.nwu.domain.exceptions;

public class CustomExceptionAdd extends Exception{

    public CustomExceptionAdd(){

    }
    public CustomExceptionAdd(Throwable thrw){
        super(thrw);
    }
    public CustomExceptionAdd(String mes){
        super(mes);
    }

    public CustomExceptionAdd(String mes, Throwable thrw){
        super(mes, thrw);
    }
}
