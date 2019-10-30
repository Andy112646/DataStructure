package com.wjx.sort;

/**
 * @Auther:wjx
 * @Date:2019/5/24
 * @Description:com.wjx.sort
 * @version:1.0
 */
public class Test {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("helloworld");
        System.out.println(sb.capacity());
        System.out.println(sb.length());
        sb.append("12345678909871233");
        System.out.println(sb.capacity());
        System.out.println(sb.length());

    }
}
