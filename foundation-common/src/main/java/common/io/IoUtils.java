package common.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by el on 2015/3/3.
 */
public class IoUtils {


    /**
     * Nio 文件复制
     * @param in
     * @param out
     * @throws IOException
     */
    public static void copyFile(String in, String out) throws IOException {
        FileInputStream inputStream = new FileInputStream(in);
        FileOutputStream outputStream = new FileOutputStream(out);
        FileChannel readChannel = inputStream.getChannel();
        FileChannel writeChannel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            buffer.clear();
            int len=readChannel.read(buffer);
            if(len == -1){
                break;
            }
            buffer.flip();
            writeChannel.write(buffer);
        }
        readChannel.close();
        writeChannel.close();
    }


    public static void main(String[] argsu){
        String in="E:\\360Downloads\\Apk";
        String out="E:\\360Downloads\\Apk\\1";
        try {
            copyFile(in,out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
