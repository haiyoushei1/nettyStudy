package nioStudy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileBufferStudy {
    public static void main(String[] str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\1.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(11);
        fileChannel.read(byteBuffer);
        fileChannel.close();
        fileInputStream.close();
        System.out.println(new String(byteBuffer.array()));
        byteBuffer.flip();  // buffer需要flip从写缓冲变成读缓冲
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\2.txt");
        fileChannel = fileOutputStream.getChannel();
        fileChannel.write(byteBuffer);
        fileChannel.close();
        fileOutputStream.close();
    }
}
