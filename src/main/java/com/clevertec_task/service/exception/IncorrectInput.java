package com.clevertec_task.service.exception;

public class IncorrectInput extends Exception{
    public IncorrectInput() {
        super("Your order contains an error");
    }
}
