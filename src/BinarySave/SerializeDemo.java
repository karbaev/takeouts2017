package BinarySave;

import PiratesSort.DataNode;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Danila on 22.02.2017.
 */


public class SerializeDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<DataNode> nodeList = new ArrayList<>();
        nodeList.add(new DataNode("Bill", 200));
        nodeList.add(new DataNode("Silver", 100));
        nodeList.add(new DataNode("One-leg", 5));

        Object o = nodeList;
        byte[] buff = serialize(o);
        for(byte x: buff) System.out.print((char)x);
        System.out.println();

        Path path = Paths.get("testSer.dat");
        Files.write(path, buff);

        byte[] buff1=Files.readAllBytes(path);
        List<DataNode> nodeList1=(List<DataNode>)deserialize(buff1);
        System.out.println(nodeList1);
    }

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }
    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }
}
