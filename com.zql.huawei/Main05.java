package com.zql.huawei;

//https://mp.weixin.qq.com/s/i8CXFWWkAIlStggTVfEq1Q

import java.util.*;

/**
 *
 * 我们将云服务看做一棵树，每个云服务在发布前尚未解决的问题称为云服务的遗留问题（云服务的遗留问题包含以该云服务为根节点的树上所有节点的问题），DI值（遗留问题缺陷密度）可以作为评估云服务发布的指标，当云服务DI值小于等于阈值时才准许云服务发布，否则视为风险云服务，需要问题整改完成后重新进行发布评估。现有一批云服务树，已给出云服务树各节点的问题数量，请通过计算输出风险云服务的个数。
 *
 * 计算公式：DI值≤5×严重问题数＋2×一般问题数，其中每个节点的不同级别问题数量需要将该节点及该节点为根节点的所有子节点的相应级别问题数量求和。
 *
 *
 * 第一行输入M和N(M≤100000，N≤1000)，使用空格分隔，M表示代表云服务阈值，N表示接下来有N行问题统计数据；
 * 接下来输入一个N∗4的矩阵表，行内使用空格分隔，第一列Ai为服务节点，第二列Bi为Ai的父节点，如果Ai为云服务则无父节点，
 * 此时Bi用∗号表示(Ai和Bi取值为字符串，1≤字符串长度≤5，均由小写英文字母或∗号组成)，第三列Ci为问题级别（Ci取值为{0,1}，
 * 0表示严重问题，1表示一般问题），第四列Di为该节点该级别的问题数量(Di≤1000)。
 * 说明：输入保证只出现树的关系，不会出现连通图的情况。
 *
 *40 12
 * a * 0 2
 * a * 1 2
 * b a 0 3
 * b a 1 5
 * c a 1 3
 * d a 0 1
 * d a 1 3
 * e b 0 2
 * f * 0 8
 * f * 1 10
 * g f 1 2
 * h * 0 4
 *
 * 2
 *
 */
public class Main05 {
      private static class Node {
        String name;
        Node parent;
        List<Node> children = new ArrayList<>();
        int severeProblems = 0;
        int generalProblems = 0;
        Node(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        Map<String, Node> nodes = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String Ai = in.next();
            String Bi = in.next();
            int Ci = in.nextInt();
            int Di = in.nextInt();
            // 为了实例化非静态内部类Node，需要先有外部类的实例
//            Main05 instance = new Main05();
//            Node node = instance.new Node(Ai); // 通过外部类实例创建内部类实例
            Node node = nodes.getOrDefault(Ai, new Node(Ai));
            if (Ci == 0) {
                node.severeProblems += Di;
            } else {
                node.generalProblems += Di;
            }
            nodes.put(Ai, node);
            if (!Bi.equals("*")) {
                Node parent = nodes.getOrDefault(Bi, new Node(Bi));
                parent.children.add(node);
                node.parent = parent;
                nodes.put(Bi, parent);
            }
        }
        int riskyServices = 0;
        for (Node node : nodes.values()) {
            if (node.parent == null) {
                int totalSevere = getTotalProblems(node, 0);
//                getTotalProblems(node, 0);
                int totalGeneral = new Main05().getTotalProblems(node, 1);
                if (5 * totalSevere + 2 * totalGeneral > M) {
                    riskyServices++;
                }
            }
        }
        System.out.print(riskyServices);
    }

    public static int getTotalProblems(Node node, int type) {
        int total = (type == 0) ? node.severeProblems : node.generalProblems;
        for (Node child : node.children) {
            total += getTotalProblems(child, type);
        }
        return total;
    }

}
