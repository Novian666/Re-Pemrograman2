/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pemrograman2;

import java.io.*;
import java.net.*;
/**
 *
 * @author Rita Faria Candra
 */
public class TerimaFile {
    public static void main(String[] x) throws Exception {
		//1. File tujuan
		FileOutputStream output = 
		new FileOutputStream("target/lala.jpg");
		//2. Buka port
		Integer port = 10000;
		ServerSocket ss = new ServerSocket(port);
		System.out.println("Penerima siap di port" + port);
		//3. Terima koneksi
		Socket s = ss.accept();
		InputStream is = s.getInputStream();
		//4. Terima data
		int data;
		while((data = is.read()) != -1){
			output.write(data);
		}
		//5. Close resources
		output.close();
		is.close();
		s.close();
	}
}
