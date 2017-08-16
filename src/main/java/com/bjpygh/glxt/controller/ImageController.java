package com.bjpygh.glxt.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bjpygh.glxt.entity.DsImage;


@Controller
public class ImageController {
	
	private static final Log logger = LogFactory.getLog(ImageController.class);
	
	
    @RequestMapping(value = "/image_save")
    public void saveImage(HttpServletRequest servletRequest,HttpServletResponse response,
            @ModelAttribute DsImage dsImage, BindingResult bindingResult,
            Model model) {
    	
    	try {
    		PrintWriter out = response.getWriter();
    		List<MultipartFile> files = dsImage.getImages();

            List<String> fileNames = new ArrayList<String>();

            if (null != files && files.size() > 0) {
                for (MultipartFile multipartFile : files) {

                    String fileName = multipartFile.getOriginalFilename();
                    fileNames.add(fileName);
                    File image = new File(servletRequest.getServletContext().getRealPath("/dsimage"));
                    if(!image.exists()){
                    	image.mkdirs();
                    }
                    File imageFile = new File(servletRequest.getServletContext()
                            .getRealPath("/dsimage"), fileName);
                    try {
                        multipartFile.transferTo(imageFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            // save product here
            model.addAttribute("image", dsImage);
            out.print("http://120.24.184.86/glxt/dsimage/"+fileNames.get(0));
            out.flush();
            out.close();
    	} catch (IOException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
        
    }
	
}
