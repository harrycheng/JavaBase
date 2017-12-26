/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.hellojava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author chenghao
 */
public class BigFileHandle {
    
    private static String src = "D:\\work\\softpackage\\519276833_8.mp4";
    private static String des = "D:\\work\\softpackage\\519276833_8_back.mp4";
            
    public static void main(String[] args) throws IOException{
        
        //FileChannelCopy();
        //StreamCopy();
        FilesCopy();
        //System.out.println(123);
    }
    
    public static void FileChannelCopy() throws IOException{
        FileChannel fcInput = FileChannel.open(Paths.get(src), StandardOpenOption.READ);
        FileChannel fcOutput = FileChannel.open(Paths.get(des), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        long size = fcInput.size();
        fcInput.transferTo(0, size, fcOutput);        
    }
    
    public static void StreamCopy() throws FileNotFoundException, IOException{
        FileInputStream fsIn = new FileInputStream(src);
        FileOutputStream fsOut = new FileOutputStream(des);
        byte[] buffer = new byte[10* 1024*1024];
        int r = 0;       
        
        r = fsIn.read(buffer);
        while(-1 != r){
            fsOut.write(buffer, 0 , r);
            r = fsIn.read(buffer);
        }
    }
    
    public static void FilesCopy() throws IOException{
        Files.copy(Paths.get(src), Paths.get(des), REPLACE_EXISTING);        
    }
}
