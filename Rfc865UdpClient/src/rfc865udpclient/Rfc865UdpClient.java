/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfc865udpclient;

import java.io.*;
import java.util.*;
import java.net.*;
/**
 *
 * @author mohit009
 */
public class Rfc865UdpClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        String quote="Prashant Mohit, TS2, 172.21.144.68";
        DatagramSocket socket=null;
        InetAddress IPAddress=InetAddress.getByName("Swl2-c2-v0102");
        byte[] send=new byte[512];
        byte[] receive=new byte[512];
        send=quote.getBytes();
        
        try{
            socket=new DatagramSocket();
            DatagramPacket request=new DatagramPacket(send, send.length, IPAddress, 17);
            socket.send(request);
            
            DatagramPacket reply=new DatagramPacket(receive, receive.length);
            socket.receive(reply);
            String response=new String(receive, 0, reply.getLength());
            System.out.println(response);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
//Name: Prashant Mohit
//Group: TS2
//IP Address: 172.21.144.68