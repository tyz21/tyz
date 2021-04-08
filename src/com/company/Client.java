package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM YYYY HH:mm",new Locale("ru","RU"));
        System.out.println("ФИО разработчика : Ногач Евгений Викторович ");
        System.out.println("Дата запуска : " + formatter.format(time));
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int first = 0,second = 0;
        String operator = null;
        if(scan.hasNextInt()) {
            first = scan.nextInt();
        }
        System.out.print("Введите второе число: ");
        if(scan.hasNextInt()) {
            second = scan.nextInt();
        }
        System.out.print("Введите опертор: ");
        if(scan.hasNext()) {
            operator = scan.next();
        }
        Operation message = new Operation(first,second, operator);
        System.out.println("Отправляем сообщение на сервер");
        try (Socket socket = new Socket("127.0.0.1",500);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()) ;
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
            out.writeObject(message);
            Answer result = (Answer) in.readObject();
            System.out.println("Ответ: " + result.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}