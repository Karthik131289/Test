package com.sw.Utills.File;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Vector;
import java.util.zip.Checksum;

/**
 * Created by DV21 on 25-02-2015.
 */
public class FileTest {

    public static void main(String[] args) {
        new FileTest();
    }

    public FileTest() {
        /*copyDirContentsToDir();
        copyFileContentsToFile();
        copyFileToDir();
        */
        /*
        copyDirContentsToDir( true );
        copyFileContentsToFile( true );
        copyFileToDir( true );
        */
        /*
        copyFileContentsToFileByOutputStream();
        copyFileContentsByInputStreamToFile();
        */
        //copyFromURLToFile();

        //convertListToArray();
    }

    /**
     * It copies contents of 'src' dir and paste it in 'dest' dir.
     */
    void copyDirContentsToDir() {
        File src = new File( "D:/Log" );
        File dest = new File( "E:/Log" );
        try {
            FileUtills.copy( src , dest );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * It copies contents of 'src' dir and paste it in 'dest' dir.
     * @param preserveDate  true then it will not change the last modified date and time in 'dest' dir, otherwise last modified date and time is changed to current DT.
     */
    void copyDirContentsToDir( boolean preserveDate ) {
        File src = new File( "D:/Log" );
        File dest = new File( "E:/Log" );
        try {
            FileUtills.copy( src , dest , preserveDate );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * It copies contents of 'src' file and paste it in 'dest' file.
     */
    void copyFileContentsToFile() {
        File src = new File( "D:/Log/AppName.log" );
        File dest = new File( "E:/Log/AppName.log" );
        try {
            FileUtills.copy( src , dest );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * It copies contents of 'src' file and paste it in 'dest' file.
     * @param preserveDate  true then it will not change the last modified date and time in 'dest' file, otherwise last modified date and time is changed to current DT.
     */
    void copyFileContentsToFile( boolean preserveDate ) {
        File src = new File( "D:/Log/AppName.log" );
        File dest = new File( "E:/Log/AppName.log" );
        try {
            FileUtills.copy( src , dest , preserveDate );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * It copies the 'src' file and paste it in 'dest' dir.
     */
    void copyFileToDir() {
        File src = new File( "D:/Log/AppName.log" );
        File dest = new File( "E:/Log" );
        try {
            FileUtills.copy( src , dest );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * It copies the 'src' file and paste it in 'dest' dir.
     * @param preserveDate  true then it will not change the last modified date and time in 'dest' file, otherwise last modified date and time is changed to current DT.
     */
    void copyFileToDir( boolean preserveDate ) {
        File src = new File( "D:/Log/AppName.log" );
        File dest = new File( "E:/Log" );
        try {
            FileUtills.copy( src , dest , preserveDate );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void copyFileContentsToFileByOutputStream() {
        File src = new File( "D:/Log/AppName.log" );
        File dest = new File( "E:/Log/AppName.log" );

        try {
            FileOutputStream outputStream = new FileOutputStream( dest );
            FileUtills.copy( src , outputStream );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void copyFileContentsByInputStreamToFile() {
        File src = new File( "D:/Log/AppName.log" );
        File dest = new File( "E:/Log/AppName.log" );

        try {
            FileInputStream inputStream = new FileInputStream( src );
            FileUtills.copy( inputStream , dest );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void copyFromURLToFile() {
        File src = new File( "D:/Log/AppName.log" );
        File dest = new File( "E:/Log/AppName.log" );

        try {
            URL  srcUrl = new URL( "file:"+src.getPath() );
            FileUtills.copy( srcUrl , dest );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void getChecksum(){
        try {
            Checksum checksum = FileUtills.calculateChecksum(new File("D:/Log/AppName.log"));
            System.out.println( checksum );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    void convertListToArray() {
        try {
            List<File> fileList = new Vector<File>();
            fileList.add( new File("D:/Log") );
            fileList.add( new File("D:/Log/AppName.log"));
            File[] files = FileUtills.convertToFileArray( fileList );
            for ( File file : files )
                System.out.println( file.getPath() );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
