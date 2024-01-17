package com.bci.apirest.usecases;

public interface UseCase <I, O>{
    O execute(I in);
}
