package com.fangxin.siwei.fangzhi.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * http://bo-hai.iteye.com/blog/2049737
 * @Date:2017/11/29 0029 10:31
 * @Author lu.dong
 * @Description：
 **/
public class Calculator {
    private static final Logger logger= LoggerFactory.getLogger(Calculator.class);

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
       List<String> houzhuishi = houzhui("2");
        //List<String>houzhuishi = houzhui("(600+(30000-1))/(2+1)+3*2");
        //Double a = Calucate.recursiveCalStr("6+(3-1)/(2+1)+3*2");
        System.out.println(calcResult(houzhuishi));
    }

    public static BigDecimal calNum(String expressStr,BigDecimal longNum,BigDecimal widthNum,BigDecimal reqNum){
      try{
          BigDecimal s=longNum.add(widthNum);
          s=s.multiply(new BigDecimal(2));
          expressStr=expressStr.replace("c",longNum.toString());
          expressStr=expressStr.replace("k",widthNum.toString());
          expressStr=expressStr.replace("s1",s.toString());
          List<String> expresslists =houzhui(expressStr);
          return calcResult(expresslists).multiply(reqNum);
      }catch (Exception e){
          logger.error("计算异常:{}",e);
          return BigDecimal.ZERO;
      }

    }

    public static BigDecimal calcResult(List<String> houzhishi) throws Exception{
        Stack<BigDecimal> charStack = new Stack<BigDecimal>();
        for (String str : houzhishi) {
            if (getHuHao().contains(str)) {
                BigDecimal data1 = charStack.pop();
                BigDecimal data2 = charStack.pop();
                charStack.push(cal(str.charAt(0),data2,data1));
            } else {
                charStack.push(new BigDecimal(str));
            }
        }
        return charStack.peek();
    }
    public static List<String> getHuHao() {
        List<String> huhao = new ArrayList<String>(0);
        huhao.add("+");
        huhao.add("-");
        huhao.add("*");
        huhao.add("/");
        huhao.add("(");
        huhao.add(")");
        huhao.add("#");
        return huhao;
    }
    public static BigDecimal cal(char c,BigDecimal a,BigDecimal b) throws Exception{
        switch(c){
            case '+':
                return a.add(b);
            case '-':
                return a.subtract(b);
            case '*':
                return a.multiply(b);
            case '/':
                return a.divide(b,2, BigDecimal.ROUND_HALF_UP);
            default:
                throw new Exception("非法运算符");
        }
    }

    public static List<String> houzhui(String val) {
        List<String> result = new ArrayList<String>();
        Stack<String> charStack = new Stack<String>();
        charStack.push("#");
        val = val + "#";
        int[][] dir = {
                {1,1,0,0,0,1,1},
                {1,1,0,0,0,1,1},
                {1,1,1,1,0,1,1},
                {1,1,1,1,0,1,1},
                {0,0,0,0,0,2,-1},
                {1,1,1,1,-1,1,1},
                {0,0,0,0,0,-1,2},
        };
        List<String> test = new ArrayList<String>();
        StringBuilder temp = new StringBuilder();
        for(int i = 0 ,length = val.length(); i < length ; i++) {
            String chr = String.valueOf(val.charAt(i));
            if (getHuHao().contains(chr) ) {
                if (temp.length() > 0) {
                    test.add(temp.toString());
                }
                test.add(chr);
                temp.delete(0, temp.length());
            } else {
                temp.append(chr);
            }
        }

        for (int i = 0 ,size = test.size(); i < size ; i++) {
            String str = test.get(i);
            try {
                Double.valueOf(str);
                result.add(str);
            } catch (NumberFormatException e) {
                int x = getHuHao().indexOf(str);
                int y = getHuHao().indexOf(charStack.peek());
                if (dir[y][x] == 0) {
                    charStack.push(str);
                } else if (dir[y][x] == 1) {
                    result.add(charStack.pop());
                    i --;
                } else if (dir[y][x] == 2 && (x == 5 && y == 4 )) {
                    charStack.pop();
                } else if (dir[y][x] == 2 && (x == 6 && y == 6 )) {
                    break;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
