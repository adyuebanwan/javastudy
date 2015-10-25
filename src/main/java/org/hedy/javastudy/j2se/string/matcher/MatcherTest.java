package org.hedy.javastudy.j2se.string.matcher;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/10/25.
 */
public class MatcherTest {
    String regex = "\\w(\\d\\d\\d)(\\w+)";//
    String str = "x123hdy,y456haha,z789heihei";//0(整串匹配的字符串)=x123hdy 1=123 2=hdy
    Pattern p = Pattern.compile(regex);
    Matcher matcher = p.matcher(str);
    @Test
    public void group(){
        while (matcher.find()){
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group(0));//0(整串匹配的字符串)=x123hdy
            System.out.println(matcher.group(1));//1=123
            System.out.println(matcher.group(2));//2=hdy
        }
        //可以重用matcher对象 否则上面的找完find()就为false了
        matcher.reset();
        while (matcher.find()){
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group(0));//0(整串匹配的字符串)=x123hdy
            System.out.println(matcher.group(1));//1=123
            System.out.println(matcher.group(2));//2=hdy

        }

    }

    @Test
    public void startEnd(){
        while (matcher.find()){
            System.out.println(matcher.start()+"-"+matcher.end());
        }
    }

    //如果想找到一篇文章 指定的关键词 变成其他词 但是又很灵活 最后返回整篇文章
    @Test
    public void appendMethod(){
        matcher.reset("houhou,x123hdy,y456haha,z789heihei,haha");//更换原字符串 其他对象照用
        StringBuffer sb = new StringBuffer();
        while (matcher.find()){
            matcher.appendReplacement(sb, "我被置换了");
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }

    @Test
    public void scanner() throws FileNotFoundException {
        InputStream in = new FileInputStream(new File("E:\\workspace\\idea\\javastudy\\src\\main\\java\\org\\hedy\\javastudy\\j2se\\string\\matcher\\MatcherTest.java"));
        Scanner s = new Scanner(in);
        while(s.hasNextLine()){
            System.out.println(s.nextLine());
        }
    }

}
