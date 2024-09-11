package org.example;
import java.util.Scanner;
import java.net.*;
import java.rmi.UnknownHostException;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            System.out.println("Start client");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите свое имя: ");
            String name = scanner.nextLine();
            Socket socket = new Socket("localhost", 1400);
            Client client = new Client(socket, name);

            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("InetAddress: " + inetAddress);
            String remoteIp = inetAddress.getHostAddress();
            System.out.println("Remote IP: " + remoteIp);
            System.out.println("LocalPort: " + socket.getLocalPort());

            client.listenForMessage();
            client.sendMessage();



        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}