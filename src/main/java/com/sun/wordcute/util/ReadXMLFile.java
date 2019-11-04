package com.sun.wordcute.util;

import com.sun.wordcute.entity.pojo.WordBase;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: 孙凯
 * @Date: 2019/11/4 11:30
 * @Description:
 * @Version 1.0
 */
public class ReadXMLFile {

    public static List<WordBase> initData() {
        String path = "C:\\Users\\14034\\Desktop\\大学英语四级（CET+4）有道词库.xml";
        File file = new File(path);
        SAXReader reader = new SAXReader();
        List<WordBase> wordList = new ArrayList<WordBase>();
        try {
            Document document = reader.read(file);
            Element bookstore = document.getRootElement();
            Iterator stores = bookstore.elementIterator();
            while(stores.hasNext()) {
                WordBase wordBase = new WordBase();
                Element bookElement = (Element) stores.next();
                Iterator bookit = bookElement.elementIterator();
                while(bookit.hasNext()) {
                    Element child = (Element) bookit.next();
                    String nodeName = child.getName();
                    if(nodeName.equals("word")) {
                        String word = child.getStringValue();
                        wordBase.setWord(word);
                    }else if(nodeName.equals("trans")){
                        String trans = child.getStringValue();
                        wordBase.setTranslation(trans);
                    }else if(nodeName.equals("phonetic")){
                        String phonetic = child.getStringValue();
                        wordBase.setPhonetic(phonetic);
                    }else if(nodeName.equals("tags")){
                        String tags = child.getStringValue();
                        if (tags.equals("CET4-EASY")){
                            wordBase.setTags(10);
                        }else if (tags.equals("CET4-HARD")){
                            wordBase.setTags(20);
                        }else {
                            System.out.println("别的级别为:"+tags);
                        }
                    }
                }
                wordList.add(wordBase);
            }

        }catch (Exception e){

        }
        return wordList;
    }


}
