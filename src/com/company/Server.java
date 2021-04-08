package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Server {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM YYYY HH:mm",new Locale("ru","RU"));
        System.out.println("ФИО разработчика : Ногач Евгений Викторович");
        System.out.println("Дата запуска : " + formatter.format(time));
        try (ServerSocket server = new ServerSocket(500)) {
            while (true) {
                try (Socket socket = server.accept()) {
                    ObjectInputStream stream = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    Operation message = (Operation) stream.readObject();
                    System.out.println("Принятая операция : " + message);
                    int first = message.getFirstOpernad();
                    int second = message.getSecondOperand();
                    Answer result;
                    switch (message.getOperation()) {
                        case "+":
                            result = new Answer(first + second);
                            break;
                        case "-":
                            result = new Answer(first - second);
                            break;
                        case "*":
                            result = new Answer(first * second);
                            break;
                        case "/":
                            result = new Answer(first / second);
                            break;
                        default:
                            result = new Answer(0);
                            break;
                    }
                    out.writeObject(result);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}