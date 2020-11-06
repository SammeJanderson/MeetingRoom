package com.gituhub.sammejanderson.meetingroom.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ErrorDetails {
    private Date timestamp; //data e hora do erro
    private String messager; //menssagem do erro
    private String details; //detalhes do erro


}
