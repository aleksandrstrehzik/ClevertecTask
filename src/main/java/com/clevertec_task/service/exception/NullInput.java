package com.clevertec_task.service.exception;

public class NullInput extends IllegalArgumentException {

    public NullInput() {
        super("You enter nothing");
    }
}
