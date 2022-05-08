    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author vt1
 */
public class WriteAndRead {
    //Phương thức ghi dữ liệu vào file
   static public void writeObject(String path,Object objectNV) throws IOException {
      //Tạo đối tượng output từ ObjectOutputStream      
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(path));
            output.writeObject(objectNV);
        } catch (Exception e) {
             throw new RuntimeException(e);
        }finally{
            output.close();
        }
    }
   //Phương thức đọc dữ liệu từ file
   static public Object readObject(String path) throws IOException{
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream(path));
            Object values = input.readObject();
            return values;
        } catch (Exception e) {
             throw new RuntimeException(e);
        }finally{
            input.close();
        }
            
    }
}
