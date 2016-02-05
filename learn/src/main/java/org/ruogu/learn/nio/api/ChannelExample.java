package org.ruogu.learn.nio.api;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ChannelExample
 * 
 * code ref:http://javapapers.com/java/java-nio-channel/
 * 
 * @author xueyintao 2016年2月5日 下午4:25:07
 */
public class ChannelExample {

	public static void main(String[] args) throws IOException {
		String fileName = ChannelExample.class.getResource("/").getPath() + "../../files/tmp_nio_read_file.txt";
		System.out.println(fileName);
		
		RandomAccessFile file = new RandomAccessFile(fileName, "r");
		FileChannel fileChannel = file.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(24);
		
		while (fileChannel.read(byteBuffer) > 0) {
			// flip the buffer to prepare for get operation
			// 设置 limit = position; position = 0;
			byteBuffer.flip();
			// while position < limit
			while (byteBuffer.hasRemaining()) {
				System.out.print((char)byteBuffer.get());
			}
			// clear the buffer ready for next sequence of read
			byteBuffer.clear();
//			System.out.println("--while-read-buffer--");
		}
		
		file.close();
	}

}
