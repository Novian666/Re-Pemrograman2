package tugas.praktikum2;

import java.io.*;
import java.sql.*;
import java.text.*;

public class Main
{
static Integer lines;

    public static void main( String[] args ) throws Exception
    {
		Database db = new Database();
		Connection conn = db.getConnection();

		String namafile = "src/main/resources/mahasiswa.csv";
		FileWriter outwrite = new FileWriter(namafile);
		
		String sql = "SELECT * FROM mahasiswa";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		ResultSetMetaData rsmd = rs.getMetaData();
		String name1 = rsmd.getColumnName(1);
		String name2 = rsmd.getColumnName(2);
		String name3 = rsmd.getColumnName(3);
		String name4 = rsmd.getColumnName(4);
		String name5 = rsmd.getColumnName(5);
		String name6 = rsmd.getColumnName(6);
		outwrite.write(name1+","+name2+","+name3+","+name4+","+name5+","+name6);
		outwrite.write("\r\n");
		outwrite.flush();
		
		while(rs.next()){
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("id : "+rs.getInt("id"));
			System.out.println("nim : "+rs.getString("nim"));
			System.out.println("nama : "+rs.getString("nama"));
			System.out.println("telp : "+rs.getString("telp"));
			System.out.println("angkatan : "+rs.getInt("angkatan"));
			System.out.println("alamat : "+rs.getString("alamat"));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("");
			
			Integer id = rs.getInt("id");
			String nim = rs.getString("nim");
			String nama = rs.getString("nama");
			String telp = rs.getString("telp");
			Integer angkatan = rs.getInt("angkatan");
			String alamat = rs.getString("alamat");
			
			outwrite.write(id+","+nim+","+nama+","+telp+","+angkatan+","+alamat);
			outwrite.write("\r\n");
			outwrite.flush();
		}
    }
}