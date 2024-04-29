package ex02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class BytesFileCopy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("대상 파일 : ");
		String src = sc.nextLine();

		System.out.print("사본 이름 : ");
		String dst = sc.nextLine();

		try {	// 파일을 바이트 단위로 읽고 쓰겠다.
			InputStream in = new FileInputStream("c:/upload/" + src);
			OutputStream out = new FileOutputStream("c:/upload/" + dst);

			byte[] bs = "korea".getBytes();
			
			out.write(bs);
			
			int data;

			while (true) {
				data = in.read();
				if (data == -1) {
					break;
				}
				System.out.println((char)data);
				out.write(data);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
