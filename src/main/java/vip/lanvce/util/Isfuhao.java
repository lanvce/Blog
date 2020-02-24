package vip.lanvce.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: lanvce$
 * @date: 2020/2/24$ 上午12:35$
 * Description:
 **/
public class Isfuhao {
    public static boolean canshu(String text) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(text);

        return m.find();

    }


    public static int call(String content1){

        char[] cons=content1.toCharArray();
        int i ;
        for (i=0;i<cons.length;i++ )
        {

             char s1=cons[i];
            if (isChinese(s1)){
                return i;
            }

        }

        return i;
    }


    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
       String  s="!bfh&一就#jbsjhvbcjks";
//        System.out.println(call(s));
        int i=call(s);
        System.out.println(i);
    }
}