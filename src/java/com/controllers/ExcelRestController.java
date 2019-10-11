/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.Helper.ExcelHelper;
import com.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.repositories.CustomerRepositories;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Radar
 */
@RestController
@RequestMapping("excel")
public class ExcelRestController {
    
    @Autowired
    private CustomerRepositories customerRepository;
    
    private static String DIR_UPLOAD="Uploads";
    
    
    @RequestMapping(
            value = "Uploads",
            method = RequestMethod.POST,
            consumes = {MimeTypeUtils.MULTIPART_FORM_DATA_VALUE}
    
    )
    public String upload(
    @RequestParam(value ="file") MultipartFile file,
      HttpServletRequest request)
    {
        try
        {
          String fileName= file.getOriginalFilename();
          ServletContext sc = request.getSession().getServletContext();
          String path = sc.getRealPath("")
                  + DIR_UPLOAD + File.separator
                  +fileName;
          System.out.print(path);
          saveFile(file.getInputStream(),path);
          importExcel(path);
          return fileName;
        }
        catch(Exception ee)
        {
            return null;
        }
    }
    
    private void importExcel(String path)
    {
        try
        {
            ExcelHelper excelHelper = new ExcelHelper(path);
          excelHelper.readData(path);
            
        }
        catch(Exception eee)
        {
            System.err.println(eee.getMessage());
            
        }
        
    }
    
    private void saveFile(InputStream inputStream,String path)
    {
        
        try
        {
            OutputStream outputStream = new FileOutputStream(new File(path));
            int read = 0;
            byte[] bytes = new byte[1024];
            while((read=inputStream.read(bytes))!= -1)
            {
                outputStream.write(bytes, 0, read);
                
            }
            outputStream.flush();
            outputStream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
}
