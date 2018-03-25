package UpdProject;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UpdServer
{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket ds = new DatagramSocket(9999);

        StudentQueue sq = new StudentQueue();

        byte[] b1 = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b1, b1.length);
        ds.receive(dp);

        InetAddress ia = dp.getAddress();

        String str = new String(dp.getData());
        System.out.println("\nServer: Your answer is " + str.trim());

        if(str.trim().equals("y"))
        {
            System.out.println("Server: Starting program.....\n");
            sq.start();

            String exitCall = "\nServer: Program finished! Exiting....";

            byte[] b2 = String.valueOf(exitCall).getBytes();

            DatagramPacket dp1 = new DatagramPacket(b2, b2.length, ia, dp.getPort());

            ds.send(dp1);
        }
        else
        {
            String exitCall = "\nServer: You said no! Exiting....";

            byte[] b2 = String.valueOf(exitCall).getBytes();

            DatagramPacket dp1 = new DatagramPacket(b2, b2.length, ia, dp.getPort());

            ds.send(dp1);
        }
    }
}