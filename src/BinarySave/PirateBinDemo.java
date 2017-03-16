package BinarySave;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Danila on 22.02.2017.
 */
public class PirateBinDemo {
    final static String FILE1="test1.dat"; //File for Stream I/O
    final static String FILE2="test2.dat"; //File for nio with Byte

    /*//Simple Output Data
    static String[] namesOut ={"A"};
    static int[] goldOut = {12};
    static double[] heightOut = { 1.99};*/

    //Output Data
    static String[] namesOut ={ "John", "Paul", "George", "Ringo"}; //String
    static int[] goldOut = { 8, 10, 16, 22 };                   //int
    static double[] heightOut = { 1.71, 1.72, 1.73, 1.74}; //double


    //Arrays for Input Data
    static String[] namesIn = new String[namesOut.length];
    static int[] goldIn = new int[goldOut.length];
    static double[] heightIn = new double[heightOut.length];


    public static void main(String[] args) throws IOException {
        //1 Streams
//        writeOutStream();
//        readInStream();

        //System.out.println("Z".getBytes().length); //1 char - 1 byte if english; 2 bytes if russian
        //System.out.println("Я".getBytes().length); //1 char - 1 byte if english; 2 bytes if russian

        //2 ByteArray
        writeOutBytes();
        readInBytes();
    }

    //1 Streams Write
    public static void writeOutStream() {
        try {
            FileOutputStream fos = new FileOutputStream(FILE1);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);

            for (int i = 0; i < namesOut.length; i ++) {
                dos.writeUTF(namesOut[i]);
                dos.writeInt(goldOut[i]);
                dos.writeDouble(heightOut[i]);
            }
            dos.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    //1 Stream Read
    public static void readInStream() {
        try {
            FileInputStream fis=new FileInputStream(FILE1);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);

            for (int i = 0; i< namesIn.length; i++) {
                namesIn[i]=dis.readUTF();
                goldIn[i]=dis.readInt();
                heightIn[i]=dis.readDouble();
            }
            dis.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        soutValues();
    }


    //Console sout
    public static void soutValues(){
            for (int i = 0; i< namesIn.length; i++) {
                System.out.println(namesIn[i] + " " + goldIn[i] + " " + heightIn[i]);
            }
    }


    //2 Java nio, Byte Write
    public static void writeOutBytes() throws IOException { //write 3 arrays
        byte[] bufStr = strToByteArr(namesOut);
        byte[] bufInt = intToByteArr(goldOut);
        byte[] bufDob = dobToByteArr(heightOut);

        Path path = Paths.get(FILE2);
        Files.write(path, bufStr);
        Files.write(path, bufInt, StandardOpenOption.APPEND);
        Files.write(path, bufDob, StandardOpenOption.APPEND);
    }

    //2 Java nio, Byte Read
    public static void readInBytes() throws IOException {
        Path path = Paths.get(FILE2);
        byte[] buf=Files.readAllBytes(path);

        int k=0, i=0;
        int strDataEnd= namesIn.length*2;
        int intDataEnd=strDataEnd+ goldIn.length*Integer.BYTES;

        for(; i<strDataEnd; i+=2){ //read strings
            byte[] minibuf={buf[i], buf[i+1]};
            namesIn[k]= String.valueOf(ByteBuffer.wrap(minibuf).getChar());
            k++;
        }

        k=0;
        for(;i<intDataEnd; i+=Integer.BYTES){ //read ints
            byte[] minibuf={buf[i], buf[i+1], buf[i+2], buf[i+3]};
            goldIn[k]=ByteBuffer.wrap(minibuf).getInt();
            k++;
        }

        k=0;
        for(;i<buf.length;i+=Double.BYTES){ //read doubles
            byte[] minibuf={buf[i], buf[i+1], buf[i+2], buf[i+3], buf[i+4], buf[i+5], buf[i+6], buf[i+7]};
            heightIn[k]=ByteBuffer.wrap(minibuf).getDouble();
            k++;
        }
        soutValues();
    }

    //2 convert string to byte array
    public static byte[] strToByteArr(String[] arr){
        ByteBuffer bb = ByteBuffer.allocate(arr.length*2);
        for(String x : arr){
            bb.putChar(x.charAt(0));
        }
        return bb.array();
    }

    //2 convert int to byte array
    public static byte[] intToByteArr(int[] arr){
        ByteBuffer bb = ByteBuffer.allocate(Integer.BYTES*arr.length);
        for(int x : arr){
            bb.putInt(x);
        }
        return bb.array();
    }

    //2 convert double to byta array
    public static byte[] dobToByteArr(double[] arr){
        ByteBuffer bb = ByteBuffer.allocate(Double.BYTES*arr.length);
        for(double x : arr){
            bb.putDouble(x);
        }
        return bb.array();
    }

}


