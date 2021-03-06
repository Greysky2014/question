package com.example.question.common;

/**
 * @project: question
 * @description:
 * @author: Mr.Wang
 * @create: 2019-11-09 08:13
 * @modify:
 * @version: v1.0
 **/
public class Caculate {

    /**
     * 计算结果
     *
     * @param num1
     * @param num2
     * @param split
     * @return
     */
    private static int calResults(Integer num1, Integer num2, char split) {
        switch (split) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return (int) (num1 * Math.pow(num2, -1));
        }
        return 0;
    }

    protected static boolean isCalFlag(char c) {

        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    /**
     * 计算括弧里的优先级为最大的值返回计算玩的字符串
     *
     * @param expreesions
     * @return
     */
    private static final String calFirstPart(String expreesions) {
        String number1 = "";
        String number2 = "";
        int index1 = 0;
        int index2 = 0;
        while (index1 != -1 || index2 != -1) {
            int length = expreesions.length();
            char[] c = expreesions.toCharArray();
            index1 = expreesions.indexOf("*", 0);
            index2 = expreesions.indexOf("/", 0);
            if (index1 == -1 && index2 == -1) {
                break;
            }

            int cursor = 0;
            if (index1 == -1 && index2 != -1) {
                cursor = index2;
            } else if (index2 == -1 && index1 != -1) {
                cursor = index1;
            } else {
                cursor = index1 < index2 ? index1 : index2;
            }
            char split = c[cursor];

            int left = cursor - 1;
            int right = cursor + 1;
            while (left >= 0 && !isCalFlag(c[left])) {
                left--;
            }
            while (!isCalFlag(c[right]) && right < length - 1) {
                right++;
            }

            number1 = expreesions.substring(left + 1, cursor);
            number2 = expreesions.substring(cursor + 1, right == length - 1 ? right + 1 : right);
            String special = expreesions.substring(left + 1, right == length - 1 ? right + 1 : right);
            String result = calResults(new Integer(number1),
                    new Integer(number2), split) + "";
            expreesions = expreesions.replace(special, result);


        }

        return expreesions;

    }

    /**
     * 计算括弧内的结果
     *
     * @param expreesions
     * @return
     */
    private static final String calSecondPart(String expreesions) {
        char[] value = expreesions.toCharArray();
        String result = "";
        int index1 = expreesions.indexOf("-", 0);
        int index2 = expreesions.indexOf("+", 0);
        int indexFlag = index1 < index2 ? index1 : index2;
        if (index1 == -1 && index2 >= 0) {
            indexFlag = index2;
        }
        if (index2 == -1 && index1 >= 0) {
            indexFlag = index1;
        }
        if (indexFlag == -1) {
            return expreesions;
        }
        result = expreesions.substring(0,
                indexFlag);
        String number1 = "";
        char split = value[indexFlag];
        for (int i = indexFlag + 1, len = value.length; i < len; i++) {
            if (!isCalFlag(value[i])) {
                number1 += value[i];
            } else {
                result = calResults(new Integer(result), new Integer(number1), split) + "";
                split = value[i];
                number1 = "";
            }

        }

        result = calResults(new Integer(result), new Integer(number1), split) + "";


        return result + "";

    }

    /**
     * 思路是先算出括弧里的结果
     * 计算最后的结构
     *
     * @param expreesions 表达式
     *                    如(1+2)+3*4+(5*6+7)-8*5
     * @return 最后的结果 用字符串表示
     */
    public static String calFinalResult(String expreesions) {
        String innerPart = "";//截取包含括弧的表达式
        int rightBraket = 0;
        if (!expreesions.contains("(")) {
            expreesions = calFirstPart(expreesions);
            expreesions = calSecondPart(expreesions);
            return expreesions;
        }
        while (rightBraket != -1) {
            char[] value = expreesions.toCharArray();
            rightBraket = expreesions.indexOf(")");//右括弧出现的位置
            if (rightBraket != -1) {
                int moveLeft = rightBraket;
                while (value[moveLeft] != '(') {
                    moveLeft--;
                }

                innerPart = expreesions.substring(moveLeft + 1, rightBraket);
                String result = calFirstPart(innerPart);
                result = calSecondPart(result);
                Integer rs = new Integer(result);
                String kouhao = expreesions.substring(moveLeft = rs < 0 ? moveLeft - 1 : moveLeft, rightBraket + 1);
                expreesions = expreesions.replace(kouhao, result + "");
            }
        }
        expreesions = calFirstPart(expreesions);
        expreesions = calSecondPart(expreesions);

        return expreesions;
    }

    public static void main(String[] args) {
        System.out.println(calFinalResult("(10+10+10-11)/(1+1)"));
    }
}