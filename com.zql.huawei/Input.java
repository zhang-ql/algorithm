package com.zql.huawei;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        System.out.println(str1);
        int i1 = in.nextInt();
        System.out.println(i1);
        in.nextLine();
        String s = in.nextLine();
        System.out.println("line"+s);
//        Main05 main05 = new Main05();
//        Main05.Node node = main05.new Node(str1);
//        node.name = s;
//        System.out.println(node.name);
    }
}
