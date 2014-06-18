/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pemrograman2;

import java.io.*;
import java.io.FileReader;

/**
 *
 * @author Rita Faria Candra
 */
public class CopyFile {
    public static void main(String[] x) throws Exception {
		FileReader asal = 
			new FileReader("src/main/resources/mahasiswa.csv");
		FileWriter tujuan = 
			new FileWriter("target/mahasiswa.csv");

		System.out.println("---------------------");
		int data;
		while((data = asal.read()) != -1){
			System.out.print((char) data);
			tujuan.write(data);
			tujuan.flush();
		}		
		System.out.println("---------------------");
		asal.close();
		tujuan.close();
	}
}
