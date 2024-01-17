package com.bci.apirest.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RegexValidator<I> implements BciValidator<I> {

    abstract String getRegex();
    abstract String getMatcher(I input);
    abstract RuntimeException getException();
    public void validate(I input){
        Pattern pattern = Pattern.compile(getRegex());
        Matcher matcher = pattern.matcher(getMatcher(input));
        if(!matcher.find()){
            throw getException();
        }
    }
}
