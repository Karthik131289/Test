package com.scm;

import com.sw.Utills.File.FileUtills;
import com.sw.Utills.Jar.jarUtills;
import com.sw.Utills.Plugins.Manager;
import com.sw.Utills.Plugins.PluginDetails;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.config.plugins.util.PluginRegistry;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/**
 * Created by DV21 on 03-02-2015.
 */
public class Test {

    public static void main(String args[]) throws IOException {
        Date dt = new Date(115, 0, 13);
        System.out.println(dt);

        float f = new Float(10.0f);
        System.out.println(f);

        Calendar cal = Calendar.getInstance();
        System.out.println(cal);

        System.out.println(Math.toRadians(360));
        System.out.println(Math.PI);

        Map< Integer , String > map = new HashMap<Integer, String>();
        map.put( 1 , "AAAA" );
        map.put( 2 , "BBBB" );
        map.put( 3 , "CCCC" );
        map.put( 4 , "DDDD" );
        map.put( 5 , "AAAA" );
        map.put( 6 , "BBBB" );
        map.put( 7 , "CCCC" );
        map.put( 8 , "DDDD" );
        System.out.println( map.entrySet() );
        System.out.println( map.keySet() );

        System.out.println( System.getProperty( "java.library.path" ) );

        Checksum checksum = new CRC32();
        Checksum outCRC = FileUtils.checksum( new File("D:/Log/AppName.log") , checksum );
        System.out.println( outCRC.getValue() );

        process( "D:/Log" , "D:/done" );
    }

    private static void process( String ytpDirPath , String doneDirPath ) {
        try {
            File ytpDir = new File( ytpDirPath );
            File doneDir = new File( doneDirPath );

            if( ytpDir.isDirectory() ) {

                if( !doneDir.exists() )
                    doneDir.mkdirs();
                else
                    if( !doneDir.isDirectory() )
                        throw new Exception( "Not a valid Done directory..." );

                System.out.println( "Initial checkings completed..." );

                File[] ytpContents = ytpDir.listFiles();
                if( ytpContents.length > 0 ) {
                    for( int i=0; i<ytpContents.length; i++ ) {
                        File file = ytpContents[i];
                        System.out.println( "processing file : " + file.getName() );

                        FileUtills.copy( file , doneDir );
                        System.out.println( "File -- " + file.getName() + " copied to done directory...." );

                        file.delete();
                    }
                }
            } else {
                throw new Exception( "Not a valid YTP directory..." );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }
}