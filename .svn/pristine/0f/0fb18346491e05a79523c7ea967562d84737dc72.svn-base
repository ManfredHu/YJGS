package com.yjgs.controller.news;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	
	public static void main(String[] args) {
        String re = "../ProductPicture/20141211224047260.jpg你好，你是谁？../ProductPicture/20141211224047261.jpg";
        String str ="../ProductPicture/\\w+\\.jpg";
  
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(re);
       while(m.find()){
        System.out.println(m.group(0));
        
       }
   }

}
