/*
package BinarySave;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

*/
/**
 * Created by Danila on 22.02.2017.
 *//*

public class BinDemo {
    final static String FILE1="test1.dat";
    final static String FILE2="test2.dat";

    //1.1
    //static String[] namesOut ={"A"};
    //static int[] goldOut = { 12};
    //static double[] heightOut = { 19.99};

    //1.2
    static String[] strOut ={ "A", "B", "C", "D"};
    static int[] intOut = { 12, 8, 13, 29, 50 };
    static double[] dobOut = { 19.99, 9.99, 15.99, 3.99, 4.99 };


    static String[] strIn = new String[strOut.length];
    static int[] intIn = new int[intOut.length];
    static double[] dobIn = new double[dobOut.length];


    public static void main(String[] args) throws IOException {
        //1 Streams
        //writeOutStream();
        //readInStream();

        //System.out.println(namesOut[0].getBytes().length); //1 char - 1 byte if english; 2 bytes if russian

        //2 ByteArray
        writeOutBytes();
        readInBytes();
    }

    //1write
    public static void writeOutStream() {
        try {
            FileOutputStream fos = new FileOutputStream(FILE1);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);
            for (int i = 0; i < strOut.length; i ++) {
                dos.writeUTF(strOut[i]);
                dos.writeInt(intOut[i]);
                dos.writeDouble(dobOut[i]);
            }
            dos.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    //1read
    public static void readInStream() {
        try {
            FileInputStream fis=new FileInputStream(FILE1);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);
            for (int i=0; i<strIn.length; i++) {
                strIn[i]=dis.readUTF();
                intIn[i]=dis.readInt();
                dobIn[i]=dis.readDouble();
            }
            dis.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        soutValues();
    }

    public static void soutValues(){
            for (int i=0; i<strIn.length; i++) {
                System.out.println(strIn[i] + " " + intIn[i] + " " + dobIn[i]);
            }
    }


    //2write
    public static void writeOutBytes() throws IOException { //write 3 arrays
        byte[] bufStr = strToByteArr(strOut);
        byte[] bufInt = intToByteArr(intOut);
        byte[] bufDob = dobToByteArr(dobOut);
        Path path = Paths.get(FILE2);
        Files.write(path, bufStr);
        Files.write(path, bufInt, StandardOpenOption.APPEND);
        Files.write(path, bufDob, StandardOpenOption.APPEND);
    }

    //2read
    public static void readInBytes() throws IOException {
        Path path = Paths.get(FILE2);
        byte[] buf=Files.readAllBytes(path);
        int k=0, i=0;
        int strDataEnd=strIn.length*2;
        for(; i<strDataEnd; i+=2){ //read strings
            byte[] minibuf={buf[i], buf[i+1]};
            strIn[k]= String.valueOf(ByteBuffer.wrap(minibuf).getChar());
            k++;
        }
        k=0;
        int intDataEnd=strDataEnd+intIn.length*Integer.BYTES;
        for(;i<intDataEnd; i+=Integer.BYTES){ //read ints
            byte[] minibuf={buf[i], buf[i+1], buf[i+2], buf[i+3]};
            intIn[k]=ByteBuffer.wrap(minibuf).getInt();
            k++;
        }
        k=0;
        for(;i<buf.length;i+=Double.BYTES){ //read doubles
            byte[] minibuf={buf[i], buf[i+1], buf[i+2], buf[i+3], buf[i+4], buf[i+5], buf[i+6], buf[i+7]};
            dobIn[k]=ByteBuffer.wrap(minibuf).getDouble();
            k++;
        }
        soutValues();
    }

    //2convert string
    public static byte[] strToByteArr(String[] arr){
        ByteBuffer bb = ByteBuffer.allocate(arr.length*2);
        for(String x : arr){
            bb.putChar(x.charAt(0));
        }
        return bb.array();
    }

    //2convert int
    public static byte[] intToByteArr(int[] arr){
        ByteBuffer bb = ByteBuffer.allocate(Integer.BYTES*arr.length);
        for(int x : arr){
            bb.putInt(x);
        }
        return bb.array();
    }

    //2convert double
    public static byte[] dobToByteArr(double[] arr){
        ByteBuffer bb = ByteBuffer.allocate(Double.BYTES*arr.length);
        for(double x : arr){
            bb.putDouble(x);
        }
        return bb.array();
    }

}


*/
