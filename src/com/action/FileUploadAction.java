/**  
 * @Title: FileUploadAction.java
 * @Package com.action
 * @Description: TODO
 * @author Victor
 * @date 2017年8月27日
 */
package com.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.po.Log;
import com.po.Management;
import com.service.CourseService;
import com.service.LogService;
import com.util.ExcelUtil;

/**
 * ClassName: FileUploadAction
 * 
 * @Description: TODO
 * @author Victor
 * @date 2017年8月27日
 */
@SuppressWarnings("serial")
public class FileUploadAction extends ActionSupport {
	private String years;
	private File uploadImage; //得到上传的文件
    private String uploadImageContentType; //得到文件的类型
    private String uploadImageFileName; //得到文件的名称
    
    public String execute() throws FileNotFoundException{
    	 
        /*System.out.println("fileName:"+this.getUploadImageFileName());
        System.out.println("contentType:"+this.getUploadImageContentType());
        System.out.println("File:"+this.getUploadImage());*/
        
        //获取要保存文件夹的物理路径(绝对路径)
        String realPath=ServletActionContext.getServletContext().getRealPath("/manager/upload");
        File file = new File(realPath);
        
        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
        if(!file.exists())file.mkdirs();
        
        try {
            //重命名保存文件
        	Date date = new Date();
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdHHmmssSSS");
        	String newFileName = sdf.format(date)+".xls";
            FileUtils.copyFile(uploadImage, new File(file,newFileName));
            File f = new File(realPath+"/"+newFileName);
    		ArrayList<ArrayList<Object>> data = ExcelUtil.readExcel(f);
    		boolean result = false;
    		result = CourseService.addCoursePlan(data, years);
    		if(result){
    			Management management = (Management) ServletActionContext.getRequest().getSession()
    					.getAttribute("manager");
    			// String str=t.getTid();
    			Log log = new Log("", management.getMid(), management.getMname(),
    					years + "", "", "必修计划库导入", "管理员");
    			LogService.addLog(log);
    			return "success";
    		}else{
    			return "error";
    		}
    		
        } catch (IOException e) {
            return "error";
        }
    }

    public File getUploadImage() {
        return uploadImage;
    }

    public void setUploadImage(File uploadImage) {
        this.uploadImage = uploadImage;
    }

    public String getUploadImageContentType() {
        return uploadImageContentType;
    }

    public void setUploadImageContentType(String uploadImageContentType) {
        this.uploadImageContentType = uploadImageContentType;
    }

    public String getUploadImageFileName() {
        return uploadImageFileName;
    }

    public void setUploadImageFileName(String uploadImageFileName) {
        this.uploadImageFileName = uploadImageFileName;
    }

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}
    

    
	
}
