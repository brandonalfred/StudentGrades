package UpdProject;

import java.net.*;
import java.util.Scanner;

public class UpdClient
{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket ds = new DatagramSocket();
        /*
        The program would not function correctly when the commented statement below is used. For reference, I have included both statements in the code. The first one works, the second does not.
         */
        InetAddress ia = InetAddress.getLocalHost();
        //InetAddress ia = InetAddress.getByName("zeus.cs.txstate.edu");

        Scanner s = new Scanner(System.in);

        char answer;

        System.out.println("Client: You are the client...are you ready to start? (y/n):  ");
        answer = s.next().charAt(0);

        System.out.println("Client: Your answer is now being shown on the Server");

        byte[] b = String.valueOf(answer).getBytes();
        DatagramPacket dp = new DatagramPacket(b, b.length, ia, 9999);
        ds.send(dp);

        byte[] b1 = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
        ds.receive(dp1);


        String str = new String(dp1.getData());
        System.out.println(str.trim());
    }
}
