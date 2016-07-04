package com.sunshine.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据格式校验工具
 * @author yaolang
 *
 */
public class DataCheckUtils {

	/**
	 * 邮箱格式校验
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email){
		String str="^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
        Pattern p = Pattern.compile(str);     
        Matcher m = p.matcher(email);
        return m.matches();     
	}
	
	/**
	 * 手机号码校验
	 * @param str
	 * @return
	 */
	public static boolean isMobile(String str) {   
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }
	
	/**
	 * 非空校验
	 * @param str
	 * @return
	 */
	public static boolean notNull(String str){
		return !(str==null||"".equals(str));
	}
	
	/**
	 * 长度校验
	 * @param str
	 * @param low
	 * @param high
	 * @return
	 */
	public static boolean length(String str,int low,int high){
		return !(str.length()<low)||(str.length()>high);
	}
	
	/**
	 * 用户名格式校验
	 * @param str
	 * @return
	 */
	public static boolean isUname(String str){
		String validateStr = "^[\\w\\-－＿[０-９]\u4e00-\u9fa5\uFF21-\uFF3A\uFF41-\uFF5A]+$";
        boolean rs = false;
        rs = matcher(validateStr, str);
        if (rs) {
            int strLenth = getStrLength(str);
            if (strLenth < 4 || strLenth > 20) {
                rs = false;
            }
        }
        return rs;
	}
	
	/**
	 * 密码格式校验
	 * @param str
	 * @return
	 */
	public static boolean isPassword(String str){
		return true;
	}
	
	/**
     * 获取字符串的长度，对双字符（包括汉字）按两位计数
     * 
     * @param value
     * @return
     */
    private static int getStrLength(String value) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        for (int i = 0; i < value.length(); i++) {
            String temp = value.substring(i, i + 1);
            if (temp.matches(chinese)) {
                valueLength += 2;
            } else {
                valueLength += 1;
            }
        }
        return valueLength;
    }
    
    private static boolean matcher(String reg, String string) {
        boolean tem = false;
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(string);
        tem = matcher.matches();
        return tem;
    }
}
