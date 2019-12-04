package com.sun.wordcute.controller;


import com.sun.wordcute.entity.pojo.WordBase;
import org.jxls.common.Context;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;


/**
 * @Author: 孙凯
 * @Date: 2019/12/4 13:27
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/wordcute/wordbase")
public class ExcelController {
    private static Logger logger = LoggerFactory.getLogger(ExcelController.class);

    @GetMapping("/downloadExcel")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response){
        List<WordBase> wordBases = listWordBase();

        try {
            /*String templatePath = this.getClass().getClassLoader().getResource("excel").getPath();
            File template = new File(templatePath, "new.xls");*/
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("excel/new.xls");
            //InputStream is = new FileInputStream(template);

            OutputStream os = new FileOutputStream("/data/new.xls");

            Map<String , Object> model=new HashMap<String , Object>();
            model.put("wordBases", wordBases);
            model.put("nowdate", new Date());

            Context context = new Context();
            if (model != null) {
                for (String key : model.keySet()) {
                    context.putVar(key, model.get(key));
                }
            }
            JxlsHelper jxlsHelper = JxlsHelper.getInstance();

            //将List<Exam>列表数据按照模板文件中的格式生成到scoreOutput.xls文件中
            JxlsHelper.getInstance().processTemplate(is, os, context);

            //下面步骤为浏览器下载部分
            //指定数据生成后的文件输入流（将上述out的路径作为文件的输入流）
            FileInputStream fileInputStream = new FileInputStream("/data/new.xls");

            //设置下载头
            response.setHeader("content-Type", "application/vnd.ms-excel");
            // 下载文件的默认名称
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("购物车数据","UTF-8") + ".xlsx");
            //编码
            response.setCharacterEncoding("UTF-8");
            ServletOutputStream outputStream = response.getOutputStream();
            //将文件写入浏览器
            byte[] bys = new byte[fileInputStream.available()];
            fileInputStream.read(bys);
            outputStream.write(bys);
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            logger.error("异常",e);
        }

    }

    private List<WordBase> listWordBase(){
        WordBase wordBase = new WordBase();
        wordBase.setId(1);
        wordBase.setWord("aaa");
        wordBase.setTranslation("字母a");
        WordBase wordBase2 = new WordBase();
        wordBase2.setId(2);
        wordBase2.setWord("bbb");
        wordBase2.setTranslation("字母b");
        WordBase wordBase3 = new WordBase();
        wordBase3.setId(3);
        wordBase3.setWord("ccc");
        wordBase3.setTranslation("字母c");
        List<WordBase> wordBases = new ArrayList<>();
        wordBases.add(wordBase);
        wordBases.add(wordBase2);
        wordBases.add(wordBase3);
        return wordBases;
    }
}
