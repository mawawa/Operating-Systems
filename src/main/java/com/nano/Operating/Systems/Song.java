package com.nano.Operating.Systems;

import org.springframework.util.ResourceUtils;

import javax.naming.spi.DirectoryManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;

public class Song {
    public static String[] getSongs(){
        
        try {
            File songs = ResourceUtils.getFile("classpath:static/music");
            System.out.println(songs.list());
            String [] list = songs.list();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
