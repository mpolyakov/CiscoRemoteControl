package com.kts.ciscorc.controller;

import java.util.List;

public class ConnectionObject {
    public String connect(){
        //Логика подключения к терминалу, авторизация
        return "OK";
    }
    public List<String> runDiagnostic(){
        //Запуск диагностики терминала, выдача результата

        return null;
    }
    public void getPhonebook(){
        //Запрос и выдача адресной книги

    }
    public void sendCommand(){
        //Отправка команд

    }
}
