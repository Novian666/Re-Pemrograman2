/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajar;
import java.net.*;
/**
 *
 * @author Rita Faria Candra
 */
public class ClientDemo {
   public static void main(String[] x) throws Exception{
		//1. IP Adress dan port Server
		String ipServer = "127.0.0.1";
		Integer portServer = 10000;

		//2. Connect menggunakan socket
		Socket s = new Socket(ipServer,portServer);  

		//3. Tampilkan informasi server
		InetSocketAddress server = (InetSocketAddress) s.getRemoteSocketAddress();
		System.out.println("IP Server : "+server.getAddress());
		System.out.println("Port Server : "+server.getPort());
		System.out.println("Hostname Server : "+server.getHostName());

		//4. Tutup Koneksi
		s.close();
	} 
}
