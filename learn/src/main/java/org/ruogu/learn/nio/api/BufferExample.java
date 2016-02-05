package org.ruogu.learn.nio.api;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * BufferExample
 * 
 * ref:http://javapapers.com/java/java-nio-buffer/
 * @author xueyintao 2016年2月5日 下午7:10:06
 */
public class BufferExample {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("files/tmp_nio_read_write.txt");
		System.out.println(path.toAbsolutePath());
		write(path);
		read(path);
	}

	private static void write(Path path) throws IOException {
		String input = "NIO Buffer Hello World!";
		byte[] inputBytes = input.getBytes();
		ByteBuffer byteBuffer = ByteBuffer.wrap(inputBytes);

		FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		fileChannel.write(byteBuffer);
		fileChannel.close();
	}
	
	private static void read(Path path) throws IOException {
		FileChannel fileChannel = FileChannel.open(path);
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		fileChannel.read(byteBuffer);
		byte[] byteArray = byteBuffer.array();
		String fileContent = new String(byteArray);
		System.out.println("fileContent:" + fileContent);
		fileChannel.close();
	}
}
