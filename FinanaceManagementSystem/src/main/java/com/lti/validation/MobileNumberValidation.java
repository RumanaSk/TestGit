package com.lti.validation;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 
// @Email("MobileNumberValidation")
class MobileNumberValidation { 
    public static boolean isValid(String s) 
    { 
        // The given argument to compile() method  
        // is regular expression. With the help of  
        // regular expression we can validate mobile 
        // number.  
        // 1) Begins with 0 or 91 
        // 2) Then contains 7 or 8 or 9. 
        // 3) Then contains 9 digits 
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
  
        // Pattern class contains matcher() method 
        // to find matching between given number  
        // and regular expression 
        Matcher m = p.matcher(s); 
        return (m.find() && m.group().equals(s)); 
    } 
  
    public static void main(String[] args) 
    { 
        String s = "347873923408";
        if (isValid(s))  
            System.out.println("Valid Number");         
        else 
            System.out.println("Invalid Number");         
    } 
} 