package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;  
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;  
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.xssf.usermodel.XSSFCell;  
import org.apache.poi.xssf.usermodel.XSSFRow;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

import com.po.Log;
import com.po.ScoreManagement;
import com.vo.ElectiveStudentVO;

public class ExcelUtil {
	
	//默认单元格内容为数字时格式  
    private static DecimalFormat df = new DecimalFormat("0");  
    // 默认单元格格式化日期字符串   
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
    // 格式化数字  
    private static DecimalFormat nf = new DecimalFormat("#.#");
    public static ArrayList<ArrayList<Object>> readExcel(File file){  
        if(file == null){  
            return null;  
        }  
        if(file.getName().endsWith("xlsx")){  
            //处理ecxel2007  
            return readExcel2007(file);  
        }else{  
            //处理ecxel2003  
            return readExcel2003(file);  
        }  
    }  
    /*  
     * @return 将返回结果存储在ArrayList内，存储结构与二位数组类似  
     * lists.get(0).get(0)表示过去Excel中0行0列单元格  
     */  
    public static ArrayList<ArrayList<Object>> readExcel2003(File file){  
        try{  
            ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();  
            ArrayList<Object> colList;  
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));  
            HSSFSheet sheet = wb.getSheetAt(0);  
            HSSFRow row;  
            HSSFCell cell;  
            Object value;  
            for(int i = sheet.getFirstRowNum() , rowCount = 0; rowCount < sheet.getPhysicalNumberOfRows() ; i++ ){  
                row = sheet.getRow(i);  
                colList = new ArrayList<Object>();  
                if(row == null){  
                    //当读取行为空时  
                    if(i != sheet.getPhysicalNumberOfRows()){//判断是否是最后一行  
                        rowList.add(colList);  
                    }  
                    continue;  
                }else{  
                    rowCount++;  
                }  
                for( int j = row.getFirstCellNum() ; j <= row.getLastCellNum() ;j++){  
                    cell = row.getCell(j);  
                    if(cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){  
                        //当该单元格为空  
                        if(j != row.getLastCellNum()){//判断是否是该行中最后一个单元格  
                            colList.add("");  
                        }  
                        continue;  
                    }  
                    switch(cell.getCellType()){  
                     case XSSFCell.CELL_TYPE_STRING:    
                            /*System.out.println(i + "行" + j + " 列 is String type");*/    
                            value = cell.getStringCellValue().trim();    
                            break;    
                        case XSSFCell.CELL_TYPE_NUMERIC:    
                            if ("@".equals(cell.getCellStyle().getDataFormatString())) {    
                                value = df.format(cell.getNumericCellValue());    
                            } else if ("General".equals(cell.getCellStyle()    
                                    .getDataFormatString())) {    
                                value = nf.format(cell.getNumericCellValue()).trim();    
                            } else {    
                                value = sdf.format(HSSFDateUtil.getJavaDate(cell    
                                        .getNumericCellValue())).trim();    
                            }    
                            /*System.out.println(i + "行" + j    
                                    + " 列 is Number type ; DateFormt:"    
                                    + value.toString());*/   
                            break;    
                        case XSSFCell.CELL_TYPE_BOOLEAN:    
                            /*System.out.println(i + "行" + j + " 列 is Boolean type"); */   
                            value = Boolean.valueOf(cell.getBooleanCellValue());  
                            break;    
                        case XSSFCell.CELL_TYPE_BLANK:    
                            /*System.out.println(i + "行" + j + " 列 is Blank type");*/    
                            value = "";    
                            break;    
                        default:    
                            /*System.out.println(i + "行" + j + " 列 is default type");*/    
                            value = cell.toString().trim();    
                    }// end switch  
                    
                    colList.add(value);  
                }//end for j  
                rowList.add(colList);  
            }//end for i  
              
            return rowList;  
        }catch(Exception e){  
            return null;  
        }  
    }  
      
    public static ArrayList<ArrayList<Object>> readExcel2007(File file){  
        try{  
            ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();  
            ArrayList<Object> colList;  
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));  
            XSSFSheet sheet = wb.getSheetAt(0);  
            XSSFRow row;  
            XSSFCell cell;  
            Object value;  
            for(int i = sheet.getFirstRowNum() , rowCount = 0; rowCount < sheet.getPhysicalNumberOfRows() ; i++ ){  
                row = sheet.getRow(i);  
                colList = new ArrayList<Object>();  
                if(row == null){  
                    //当读取行为空时  
                    if(i != sheet.getPhysicalNumberOfRows()){//判断是否是最后一行  
                        rowList.add(colList);  
                    }  
                    continue;  
                }else{  
                    rowCount++;  
                }  
                for( int j = row.getFirstCellNum() ; j <= row.getLastCellNum() ;j++){  
                    cell = row.getCell(j);  
                    if(cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){  
                        //当该单元格为空  
                        if(j != row.getLastCellNum()){//判断是否是该行中最后一个单元格  
                            colList.add("");  
                        }  
                        continue;  
                    }  
                    switch(cell.getCellType()){  
                     case XSSFCell.CELL_TYPE_STRING:    
                            /*System.out.println(i + "行" + j + " 列 is String type");*/    
                            value = cell.getStringCellValue().trim();    
                            break;    
                        case XSSFCell.CELL_TYPE_NUMERIC:    
                            if ("@".equals(cell.getCellStyle().getDataFormatString())) {    
                                value = df.format(cell.getNumericCellValue()).trim();    
                            } else if ("General".equals(cell.getCellStyle()    
                                    .getDataFormatString())) {    
                                value = nf.format(cell.getNumericCellValue()).trim();    
                            } else {    
                                value = sdf.format(HSSFDateUtil.getJavaDate(cell    
                                        .getNumericCellValue())).trim();    
                            }    
                            /*System.out.println(i + "行" + j    
                                    + " 列 is Number type ; DateFormt:"    
                                    + value.toString());*/   
                            break;    
                        case XSSFCell.CELL_TYPE_BOOLEAN:    
                            /*System.out.println(i + "行" + j + " 列 is Boolean type");*/    
                            value = Boolean.valueOf(cell.getBooleanCellValue());  
                            break;    
                        case XSSFCell.CELL_TYPE_BLANK:    
                            /*System.out.println(i + "行" + j + " 列 is Blank type");*/    
                            value = "";    
                            break;    
                        default:    
                            /*System.out.println(i + "行" + j + " 列 is default type");*/    
                            value = cell.toString().trim();    
                    }// end switch  
                    colList.add(value);  
                }//end for j  
                rowList.add(colList);  
            }//end for i  
              
            return rowList;  
        }catch(Exception e){  
            /*System.out.println("exception");*/  
            return null;  
        }  
    }  
	
	
    /**
     * 成绩库下载（新增课程编码，院系，身份证号信息）
     * @Description: TODO
     * @param @param list
     * @param @param URL
     * @return boolean  
     * @author zhaoqian
     * @date 2018年7月17日
     */
	@SuppressWarnings({ "deprecation", "unused" })
	public static boolean createExcel(List<Object[]> list, String URL){
		 //第一步创建workbook  
        HSSFWorkbook wb = new HSSFWorkbook();  
          
        //第二步创建sheet  
        HSSFSheet sheet = wb.createSheet("最新录入学生成绩库");  
          
        //第三步创建行row:添加表头0行  
        HSSFRow row = sheet.createRow(0);  
        HSSFCellStyle  style = wb.createCellStyle();      
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中  
          
          
        //第四步创建单元格  
        HSSFCell cell = row.createCell((short) 0); //第一个单元格 
        // 设置单元格内容为字符串型
        cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
        // 为了能在单元格中输入中文,设置字符集为UTF_16
        /*cell.setEncoding(HSSFCell.ENCODING_UTF_16);*/
        /*cell.setCellValue("姓名");  */
        cell.setCellValue(new HSSFRichTextString("序号"));
        cell.setCellStyle(style);                   //内容居中  
          
        cell = row.createCell((short) 1);                   //第二个单元格     
        /*cell.setCellValue("身份证"); */
        cell.setCellValue(new HSSFRichTextString("学号"));
        cell.setCellStyle(style);  
          
        cell = row.createCell((short) 2);                   //第三个单元格    
        /*cell.setCellValue("错误状态");  */
        cell.setCellValue(new HSSFRichTextString("姓名"));
        cell.setCellStyle(style);  
          
        cell = row.createCell((short) 3);                   //第四个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("班号"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 4);                   //第五个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("班级"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 5);                   //第六个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("学期"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 6);                   //第七个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("课程类别"));
        cell.setCellStyle(style);  
          
        cell = row.createCell((short) 7);                   //第八个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("课程名"));
        cell.setCellStyle(style);
        
        cell = row.createCell((short) 8);                   //第九个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("课程ID"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 9);                   //第十个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("学分"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 10);                   //第十一个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("卷面成绩比例"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 11);                   //第十二个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("平时成绩比例"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 12);                   //第十三个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("卷面成绩"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 13);                   //第十四个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("平时成绩"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 14);                   //第十五个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("最终成绩"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 15);                   //第十六个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("重修1"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 16);                   //第十七个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("重修2"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 17);                   //第十八个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("重修3"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 18);                   //第十九个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("备注"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 19);                   //第二十个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("考试周"));
        cell.setCellStyle(style); 
        
        cell = row.createCell((short) 20);                   //第二十一个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("任课教师"));
        cell.setCellStyle(style); 
        
        cell = row.createCell((short) 21);                   //第二十二个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("学生身份证号"));
        cell.setCellStyle(style);
        
        cell = row.createCell((short) 22);                   //第二十三个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("院系名称"));
        cell.setCellStyle(style); 
        
        cell = row.createCell((short) 23);                   //第二十四个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("课程编码"));
        cell.setCellStyle(style); 
        
        //第五步插入数据  
        List<Object[]> scList = list; 
        for(Object[] scm:scList){
        	int i = 1;
        	 //创建行  
        	row = sheet.createRow(i);
        	
        }
        
        for (int i = 0; i < list.size(); i++) {  
        	Object[] scm = list.get(i);  
            //创建行  
            row = sheet.createRow(i+1);  
            //创建单元格并且添加数据  
            row.createCell((short) 0).setCellValue(scm[0] == null?"":scm[0].toString());  
            row.createCell((short) 1).setCellValue(scm[1] == null?"":scm[1].toString());  
            row.createCell((short) 2).setCellValue(scm[2] == null?"":scm[2].toString());  
            row.createCell((short) 3).setCellValue(scm[3] == null?"":scm[3].toString());  
            row.createCell((short) 4).setCellValue(scm[4] == null?"":scm[4].toString());  
            row.createCell((short) 5).setCellValue(scm[5] == null?"":scm[5].toString());  
            row.createCell((short) 6).setCellValue(scm[6] == null?"":scm[6].toString());  
            row.createCell((short) 7).setCellValue(scm[7] == null?"":scm[7].toString());  
            row.createCell((short) 8).setCellValue(scm[8] == null?"":scm[8].toString());  
            row.createCell((short) 9).setCellValue(scm[9] == null?"":nf.format(Float.parseFloat(scm[9].toString())));  
            row.createCell((short) 10).setCellValue(scm[10] == null?"":nf.format(Float.parseFloat(scm[10].toString())));  
            row.createCell((short) 11).setCellValue(scm[11] == null?"":nf.format(Float.parseFloat(scm[11].toString())));  
            row.createCell((short) 12).setCellValue(scm[12] == null?"":scm[12].toString());
            row.createCell((short) 13).setCellValue(scm[13] == null?"":scm[13].toString());
            row.createCell((short) 14).setCellValue(scm[14] == null?"":scm[14].toString());
            row.createCell((short) 15).setCellValue(scm[15] == null?"":scm[15].toString());
            row.createCell((short) 16).setCellValue(scm[16] == null?"":scm[16].toString());
            row.createCell((short) 17).setCellValue(scm[17] == null?"":scm[17].toString());
            row.createCell((short) 18).setCellValue(scm[18] == null?"":scm[18].toString());
            row.createCell((short) 19).setCellValue(scm[19] == null?"":scm[19].toString());
            row.createCell((short) 20).setCellValue(scm[20] == null?"":scm[20].toString());
            row.createCell((short) 21).setCellValue(scm[21] == null?"":scm[21].toString());
            row.createCell((short) 22).setCellValue(scm[22] == null?"":scm[22].toString());
            row.createCell((short) 23).setCellValue(scm[23] == null?"":scm[23].toString());
        }  
        
        //第六步将生成excel文件保存到指定路径下  
        try {  
            FileOutputStream fout = new FileOutputStream(URL);  
            wb.write(fout);  
            fout.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
          
        /*System.out.println("Excel文件生成成功..."); */ 
		return true;
	}
	public static boolean createStudentExcel(List<Object[]> list, String URL){
		 //第一步创建workbook  
       HSSFWorkbook wb = new HSSFWorkbook();  
         
       //第二步创建sheet  
       HSSFSheet sheet = wb.createSheet("最新学生库");  
         
       //第三步创建行row:添加表头0行  
       HSSFRow row = sheet.createRow(0);  
       HSSFCellStyle  style = wb.createCellStyle();      
       style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中  
         
         
       //第四步创建单元格  
       HSSFCell cell = row.createCell((short) 0); //第一个单元格 
       // 设置单元格内容为字符串型
       cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
       // 为了能在单元格中输入中文,设置字符集为UTF_16
       /*cell.setEncoding(HSSFCell.ENCODING_UTF_16);*/
       /*cell.setCellValue("姓名");  */
       cell.setCellValue(new HSSFRichTextString("序号"));
       cell.setCellStyle(style);                   //内容居中  
         
       cell = row.createCell((short) 1);                   //第二个单元格     
       /*cell.setCellValue("身份证"); */
       cell.setCellValue(new HSSFRichTextString("学号"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 2);                   //第三个单元格    
       /*cell.setCellValue("错误状态");  */
       cell.setCellValue(new HSSFRichTextString("姓名"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 3);                   //第四个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("英文名"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 4);                   //第五个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("性别"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 5);                   //第六个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("身份证号"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 6);                   //第七个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("政治面貌"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 7);                   //第八个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("民族"));
       cell.setCellStyle(style);
       
       cell = row.createCell((short) 8);                   //第九个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("入学时间"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 9);                   //第十个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("毕业时间"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 10);                   //第十一个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("班级代码"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 11);                   //第十二个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("班级"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 12);                   //第十三个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("专业代码"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 13);                   //第十四个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("专业"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 14);                   //第十五个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("院系编号"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 15);                   //第十六个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("院系"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 16);                   //第十七个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("备注"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 17);                   //第十八个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("状态"));
       cell.setCellStyle(style);  
       
       
       
       //第五步插入数据  
       List<Object[]> scList = list; 
       for(Object[] scm:scList){
       	int i = 1;
       	 //创建行  
       	row = sheet.createRow(i);
       	
       }
       
       for (int i = 0; i < list.size(); i++) {  
       	   Object[] obj = list.get(i);  
           //创建行  
       	   for(int t = 0;t<17;t++){
       		   if(obj[t] == null){
       			   obj[t]="";
       		   }
       	   }
           row = sheet.createRow(i+1);  
           //创建单元格并且添加数据  
           row.createCell((short) 0).setCellValue(i+1);  
           row.createCell((short) 1).setCellValue(obj[0].toString());  
           row.createCell((short) 2).setCellValue(obj[1].toString());  
           row.createCell((short) 3).setCellValue(obj[2].toString());  
           row.createCell((short) 4).setCellValue(obj[3].toString());  
           row.createCell((short) 5).setCellValue(obj[4].toString());  
           row.createCell((short) 6).setCellValue(obj[5].toString());  
           row.createCell((short) 7).setCellValue(obj[6].toString());  
           row.createCell((short) 8).setCellValue(obj[7].toString());  
           row.createCell((short) 9).setCellValue(obj[8].toString());  
           row.createCell((short) 10).setCellValue(obj[9].toString());  
           row.createCell((short) 11).setCellValue(obj[10].toString());  
           row.createCell((short) 12).setCellValue(obj[11].toString());
           row.createCell((short) 13).setCellValue(obj[12].toString());
           row.createCell((short) 14).setCellValue(obj[13].toString());
           row.createCell((short) 15).setCellValue(obj[14].toString());
           row.createCell((short) 16).setCellValue(obj[15].toString());
           row.createCell((short) 17).setCellValue(obj[16].toString());
       }  
       
       //第六步将生成excel文件保存到指定路径下  
       try {  
           FileOutputStream fout = new FileOutputStream(URL);  
           wb.write(fout);  
           fout.close();  
       } catch (IOException e) {  
           e.printStackTrace();  
       } 
         
       /*System.out.println("Excel文件生成成功..."); */ 
		return true;
	}
	public static boolean createLogsExcel(List<Log> list, String URL){
		 //第一步创建workbook  
       HSSFWorkbook wb = new HSSFWorkbook();  
         
       //第二步创建sheet  
       HSSFSheet sheet = wb.createSheet("最新系统操作日志");  
         
       //第三步创建行row:添加表头0行  
       HSSFRow row = sheet.createRow(0);  
       HSSFCellStyle  style = wb.createCellStyle();      
       style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中  
         
         
       //第四步创建单元格  
       HSSFCell cell = row.createCell((short) 0); //第一个单元格 
       // 设置单元格内容为字符串型
       cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
       // 为了能在单元格中输入中文,设置字符集为UTF_16
       /*cell.setEncoding(HSSFCell.ENCODING_UTF_16);*/
       /*cell.setCellValue("姓名");  */
       cell.setCellValue(new HSSFRichTextString("序号"));
       cell.setCellStyle(style);                   //内容居中  
         
       cell = row.createCell((short) 1);                   //第二个单元格     
       /*cell.setCellValue("身份证"); */
       cell.setCellValue(new HSSFRichTextString("操作时间"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 2);                   //第三个单元格    
       /*cell.setCellValue("错误状态");  */
       cell.setCellValue(new HSSFRichTextString("操作人工号"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 3);                   //第四个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("姓名"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 4);                   //第五个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("操作班级"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 5);                   //第六个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("操作课程"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 6);                   //第七个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("操作动作"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 7);                   //第八个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("用户级别"));
       cell.setCellStyle(style);
       
       
       
       //第五步插入数据  
       List<Log> scList = list; 
       for(Log log:scList){
       	int i = 1;
       	 //创建行  
       	row = sheet.createRow(i);
       	
       }
       
       for (int i = 0; i < list.size(); i++) {  
       		Log log = list.get(i);  
           //创建行  
           row = sheet.createRow(i+1);  
           //创建单元格并且添加数据  
           row.createCell((short) 0).setCellValue(log.getLid());  
           row.createCell((short) 1).setCellValue(log.getLtime());  
           row.createCell((short) 2).setCellValue(log.getLuid());  
           row.createCell((short) 3).setCellValue(log.getLuser());  
           row.createCell((short) 4).setCellValue(log.getLclass());  
           row.createCell((short) 5).setCellValue(log.getLcourse());  
           row.createCell((short) 6).setCellValue(log.getLcontrol());  
           row.createCell((short) 7).setCellValue(log.getLgenre());  
       }  
       
       //第六步将生成excel文件保存到指定路径下  
       try {  
           FileOutputStream fout = new FileOutputStream(URL);  
           wb.write(fout);  
           fout.close();  
       } catch (IOException e) {  
           e.printStackTrace();  
       } 
         
       /*System.out.println("Excel文件生成成功..."); */ 
		return true;
	}
	
	public static boolean createCoursePlanExcel(List<Object[]> list,String URL){
		//第一步创建workbook  
       HSSFWorkbook wb = new HSSFWorkbook();  
         
       //第二步创建sheet  
       HSSFSheet sheet = wb.createSheet("最新教学计划库");  
         
       //第三步创建行row:添加表头0行  
       HSSFRow row = sheet.createRow(0);  
       HSSFCellStyle  style = wb.createCellStyle();      
       style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中  
         
         
       //第四步创建单元格  
       HSSFCell cell = row.createCell((short) 0); //第一个单元格 
       // 设置单元格内容为字符串型
       cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
       // 为了能在单元格中输入中文,设置字符集为UTF_16
       /*cell.setEncoding(HSSFCell.ENCODING_UTF_16);*/
       /*cell.setCellValue("姓名");  */
       cell.setCellValue(new HSSFRichTextString("序号"));
       cell.setCellStyle(style);                   //内容居中  
         
       cell = row.createCell((short) 1);                   //第二个单元格     
       /*cell.setCellValue("身份证"); */
       cell.setCellValue(new HSSFRichTextString("课程代码"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 2);                   //第三个单元格    
       /*cell.setCellValue("错误状态");  */
       cell.setCellValue(new HSSFRichTextString("课程名"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 3);                   //第四个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("课程类别"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 4);                   //第五个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("学分"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 5);                   //第六个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("总学时"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 6);                   //第七个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("学期学年"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 7);                   //第八个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("开始周"));
       cell.setCellStyle(style);
       
       cell = row.createCell((short) 8);                   //第九个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("结束周"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 9);                   //第十个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("任课教师工号"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 10);                   //第十一个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("任课教师姓名"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 11);                   //第十二个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("考试周"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 12);                   //第十三个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("班级代码"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 13);                   //第十四个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("班级名"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 14);                   //第十五个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("课程编码"));
       cell.setCellStyle(style);
       
       
       
       //第五步插入数据  
       List<Object[]> data = list; 
       for(Object[] obj:data){
    	   int i = 1;
    	   //创建行  
    	   row = sheet.createRow(i);
       	
       }
       
       for (int i = 0; i < list.size(); i++) {  
       	   Object[] obj = list.get(i);  
           //创建行  
           row = sheet.createRow(i+1);  
           //创建单元格并且添加数据  
           row.createCell((short) 0).setCellValue(i+1);  
           row.createCell((short) 1).setCellValue(obj[0].toString());  
           row.createCell((short) 2).setCellValue(obj[1].toString());  
           row.createCell((short) 3).setCellValue(obj[2].toString());  
           row.createCell((short) 4).setCellValue(nf.format(Float.parseFloat(obj[3].toString())));  
           row.createCell((short) 5).setCellValue(obj[4].toString());  
           row.createCell((short) 6).setCellValue(obj[5].toString());  
           row.createCell((short) 7).setCellValue(obj[6].toString());  
           row.createCell((short) 8).setCellValue(obj[7].toString());  
           row.createCell((short) 9).setCellValue(obj[8].toString());  
           row.createCell((short) 10).setCellValue(obj[9].toString());  
           row.createCell((short) 11).setCellValue(obj[10].toString());  
           row.createCell((short) 12).setCellValue(obj[11].toString());
           row.createCell((short) 13).setCellValue(obj[12].toString());
           row.createCell((short) 14).setCellValue(obj[13].toString());
       }  
       
       //第六步将生成excel文件保存到指定路径下  
       try {  
           FileOutputStream fout = new FileOutputStream(URL);  
           wb.write(fout);  
           fout.close();  
       } catch (IOException e) {  
           e.printStackTrace();  
       } 
         
       /*System.out.println("Excel文件生成成功..."); */ 
		return true;
	}
	public static boolean createSelectCoursePlanExcel(List<Object[]> list,String URL){
		//第一步创建workbook  
       HSSFWorkbook wb = new HSSFWorkbook();  
         
       //第二步创建sheet  
       HSSFSheet sheet = wb.createSheet("最新教学计划库");  
         
       //第三步创建行row:添加表头0行  
       HSSFRow row = sheet.createRow(0);  
       HSSFCellStyle  style = wb.createCellStyle();      
       style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中  
         
         
       //第四步创建单元格  
       HSSFCell cell = row.createCell((short) 0); //第一个单元格 
       // 设置单元格内容为字符串型
       cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
       // 为了能在单元格中输入中文,设置字符集为UTF_16
       /*cell.setEncoding(HSSFCell.ENCODING_UTF_16);*/
       /*cell.setCellValue("姓名");  */
       cell.setCellValue(new HSSFRichTextString("序号"));
       cell.setCellStyle(style);                   //内容居中  
         
       cell = row.createCell((short) 1);                   //第二个单元格     
       /*cell.setCellValue("身份证"); */
       cell.setCellValue(new HSSFRichTextString("课程代码"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 2);                   //第三个单元格    
       /*cell.setCellValue("错误状态");  */
       cell.setCellValue(new HSSFRichTextString("课程名"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 3);                   //第四个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("课程类别"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 4);                   //第五个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("学分"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 5);                   //第六个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("总学时"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 6);                   //第七个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("学期学年"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 7);                   //第八个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("开始周"));
       cell.setCellStyle(style);
       
       cell = row.createCell((short) 8);                   //第九个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("结束周"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 9);                   //第十个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("任课教师工号"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 10);                   //第十一个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("任课教师姓名"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 11);                   //第十二个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("考试周"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 12);                   //第十三个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("课程编码"));
       cell.setCellStyle(style);  
       
       
       
       
       //第五步插入数据  
       List<Object[]> data = list; 
       for(Object[] obj:data){
    	   int i = 1;
    	   //创建行  
    	   row = sheet.createRow(i);
       	
       }
       
       for (int i = 0; i < list.size(); i++) {  
       	   Object[] obj = list.get(i);  
           //创建行  
           row = sheet.createRow(i+1);  
           //创建单元格并且添加数据  
           row.createCell((short) 0).setCellValue(i+1);  
           row.createCell((short) 1).setCellValue(obj[0].toString());  
           row.createCell((short) 2).setCellValue(obj[1].toString());  
           row.createCell((short) 3).setCellValue(obj[2].toString());  
           row.createCell((short) 4).setCellValue(nf.format(Float.parseFloat(obj[3].toString())));  
           row.createCell((short) 5).setCellValue(obj[4].toString());  
           row.createCell((short) 6).setCellValue(obj[5].toString());  
           row.createCell((short) 7).setCellValue(obj[6].toString());  
           row.createCell((short) 8).setCellValue(obj[7].toString());  
           row.createCell((short) 9).setCellValue(obj[8].toString());  
           row.createCell((short) 10).setCellValue(obj[9].toString());  
           row.createCell((short) 11).setCellValue(obj[10].toString());  
           row.createCell((short) 12).setCellValue(obj[11].toString()); 
       }  
       
       //第六步将生成excel文件保存到指定路径下  
       try {  
           FileOutputStream fout = new FileOutputStream(URL);  
           wb.write(fout);  
           fout.close();  
       } catch (IOException e) {  
           e.printStackTrace();  
       } 
         
       /*System.out.println("Excel文件生成成功..."); */ 
		return true;
	}
	public static boolean createTeacherExcel(List<Object[]> list,String URL){
		//第一步创建workbook  
       HSSFWorkbook wb = new HSSFWorkbook();  
         
       //第二步创建sheet  
       HSSFSheet sheet = wb.createSheet("最新教师信息库");  
         
       //第三步创建行row:添加表头0行  
       HSSFRow row = sheet.createRow(0);  
       HSSFCellStyle  style = wb.createCellStyle();      
       style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中  
         
         
       //第四步创建单元格  
       HSSFCell cell = row.createCell((short) 0); //第一个单元格 
       // 设置单元格内容为字符串型
       cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
       // 为了能在单元格中输入中文,设置字符集为UTF_16
       /*cell.setEncoding(HSSFCell.ENCODING_UTF_16);*/
       /*cell.setCellValue("姓名");  */
       cell.setCellValue(new HSSFRichTextString("序号"));
       cell.setCellStyle(style);                   //内容居中  
         
       cell = row.createCell((short) 1);                   //第二个单元格     
       /*cell.setCellValue("身份证"); */
       cell.setCellValue(new HSSFRichTextString("教师工号"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 2);                   //第三个单元格    
       /*cell.setCellValue("错误状态");  */
       cell.setCellValue(new HSSFRichTextString("教师姓名"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 3);                   //第四个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("职务"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 4);                   //第五个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("职称"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 5);                   //第六个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("所属部门"));
       cell.setCellStyle(style);  
       
       
       
       
       
       
       //第五步插入数据  
       List<Object[]> data = list; 
       for(Object[] obj:data){
    	   int i = 1;
    	   //创建行  
    	   row = sheet.createRow(i);
       	
       }
       
       for (int i = 0; i < list.size(); i++) {  
       	   Object[] obj = list.get(i);  
           //创建行  
           row = sheet.createRow(i+1);  
           //创建单元格并且添加数据  
           row.createCell((short) 0).setCellValue(i+1);  
           if(obj[0] == null){
        	   row.createCell((short) 1).setCellValue(""); 
           }else{
        	   row.createCell((short) 1).setCellValue(obj[0].toString());  
           }
           if(obj[1] == null){
        	   row.createCell((short) 2).setCellValue("");  
           }else{
        	   row.createCell((short) 2).setCellValue(obj[1].toString());
           }
           if(obj[2] == null){
        	   row.createCell((short) 3).setCellValue(""); 
           }else{
        	   row.createCell((short) 3).setCellValue(obj[2].toString());  
           }
           if(obj[3] == null){
        	   row.createCell((short) 4).setCellValue("");
           }else{
        	   row.createCell((short) 4).setCellValue(obj[3].toString());  
           }
           if(obj[4] == null){
        	   row.createCell((short) 5).setCellValue("");  
        	   
           }else{
        	   row.createCell((short) 5).setCellValue(obj[4].toString());
           }
       }  
       
       //第六步将生成excel文件保存到指定路径下  
       try {  
           FileOutputStream fout = new FileOutputStream(URL);  
           wb.write(fout);  
           fout.close();  
       } catch (IOException e) {  
           e.printStackTrace();  
       } 
         
       /*System.out.println("Excel文件生成成功..."); */ 
		return true;
	}
	
	public static boolean createElectiveStudentExcel(List<ElectiveStudentVO> list, String URL){
		 //第一步创建workbook  
       HSSFWorkbook wb = new HSSFWorkbook();  
         
       //第二步创建sheet  
       HSSFSheet sheet = wb.createSheet("选课学生信息表");  
         
       //第三步创建行row:添加表头0行  
       HSSFRow row = sheet.createRow(0);  
       HSSFCellStyle  style = wb.createCellStyle();      
       style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中  
         
         
       //第四步创建单元格  
       HSSFCell cell = row.createCell((short) 0); //第一个单元格 
       // 设置单元格内容为字符串型
       cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
       // 为了能在单元格中输入中文,设置字符集为UTF_16
       /*cell.setEncoding(HSSFCell.ENCODING_UTF_16);*/
       /*cell.setCellValue("姓名");  */
       cell.setCellValue(new HSSFRichTextString("序号"));
       cell.setCellStyle(style);                   //内容居中  
         
       cell = row.createCell((short) 1);                   //第二个单元格     
       /*cell.setCellValue("身份证"); */
       cell.setCellValue(new HSSFRichTextString("学号"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 2);                   //第三个单元格    
       /*cell.setCellValue("错误状态");  */
       cell.setCellValue(new HSSFRichTextString("姓名"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 3);                   //第四个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("课程代码"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 4);                   //第五个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("课程名称"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 5);                   //第六个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("班级代码"));
       cell.setCellStyle(style);  
       
       cell = row.createCell((short) 6);                   //第七个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("班级名称"));
       cell.setCellStyle(style);  
         
       cell = row.createCell((short) 7);                   //第八个单元格    
       /*cell.setCellValue("错误信息"); */ 
       cell.setCellValue(new HSSFRichTextString("学年/学期"));
       cell.setCellStyle(style);
       
       
       
       //第五步插入数据  
       List<ElectiveStudentVO> scList = list; 
       for(ElectiveStudentVO eso:scList){
       	int i = 1;
       	 //创建行  
       	row = sheet.createRow(i);
       	
       }
       
       for (int i = 0; i < list.size(); i++) {  
    	   ElectiveStudentVO eso = list.get(i);  
           //创建列
           row = sheet.createRow(i+1);  
           //创建单元格并且添加数据  
           row.createCell((short) 0).setCellValue(i+1);  
           row.createCell((short) 1).setCellValue(eso.getStudentId());  
           row.createCell((short) 2).setCellValue(eso.getStudentName());  
           row.createCell((short) 3).setCellValue(eso.getCourseId());  
           row.createCell((short) 4).setCellValue(eso.getCourseName());  
           row.createCell((short) 5).setCellValue(eso.getClassNameId());  
           row.createCell((short) 6).setCellValue(eso.getClassName());  
           row.createCell((short) 7).setCellValue(eso.getYears());  
       }  
       
       //第六步将生成excel文件保存到指定路径下  
       try {  
           FileOutputStream fout = new FileOutputStream(URL);  
           wb.write(fout);  
           fout.close();  
       } catch (IOException e) {  
           e.printStackTrace();  
       } 
         
       /*System.out.println("Excel文件生成成功..."); */ 
		return true;
	}
	
	
	public static void main(String[] args) {
		File file = new File("D:/中台-需求记录表.xlsx");
		ArrayList<ArrayList<Object>> result = ExcelUtil.readExcel(file);
		for(int i = 0 ;i < result.size() ;i++){
			for(int j = 0;j<result.get(i).size(); j++){
				System.out.print(result.get(i).get(j).toString()+"  ");
			}
			System.out.println();
		}
		
		
	}

}
