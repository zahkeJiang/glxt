package com.bjpygh.glxt.entity;
import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class DsImage implements Serializable {
    private static final long serialVersionUID = 78L;
    private List<MultipartFile> images;

    public List<MultipartFile> getImages() {
        return images;
    }
    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}