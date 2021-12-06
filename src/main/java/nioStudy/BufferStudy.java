package nioStudy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class BufferStudy {
    public static void main(String[] str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\1.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(15);
        fileChannel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
        fileChannel.close();
        fileInputStream.close();
    }
}
