package com.github.Cnly.BeReplaced.BeReplaced;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils
{
    
    public static void copyFile(File source, File dest)
    {
        
        InputStream input = null;
        OutputStream output = null;
        
        try
        {
            
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) != -1)
                output.write(buf, 0, bytesRead);
            
        }
        catch (FileNotFoundException e)
        {
            Main.getInstance().getLogger().severe("File not found!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            Main.getInstance().getLogger()
                    .severe("An error occurred while copying the file!");
            e.printStackTrace();
        }
        finally
        {
            
            try
            {
                input.close();
            }
            catch (IOException e)
            {
                Main.getInstance()
                        .getLogger()
                        .severe("An error occurred while closing the input stream!");
                e.printStackTrace();
            }
            
            try
            {
                output.close();
            }
            catch (IOException e)
            {
                Main.getInstance()
                        .getLogger()
                        .severe("An error occurred while closing the output stream!");
                e.printStackTrace();
            }
            
        }
    }
    
}
