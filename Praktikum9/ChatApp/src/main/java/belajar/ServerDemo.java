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
public class ServerDemo {
    public static void main(String[] x) throws Exception {
		//1. Buka server socket di port 10000
		ServerSocket ss = new ServerSocket(10000);

		//2. Jika ada client yang connet, terima
		Socket s = ss.accept();

		//3. Tampilkan informasi client
		InetSocketAddress client = (InetSocketAddress) s.getRemoteSocketAddress();
		System.out.println("IP client : "+client.getAddress());
		System.out.println("Port client : "+client.getPort());
		System.out.println("Hostname client : "+client.getHostName());
		//4. Terima data

		//5. Tutup koneksi
		s.close();
	}
}
