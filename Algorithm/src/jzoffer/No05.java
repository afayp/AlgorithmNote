package jzoffer;

public class No05 {


    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"。
     * 例如输入"We are happy"，则输出"We%20are%20happy"
     */
    public static void main(String[] args) {
        String str = "We are happy";
        System.out.println(replaceSpace(str.toCharArray()));
    }


    public static String replaceSpace(char[] charArray) {
        int spaceNum = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                spaceNum++;
            }
        }
        if (spaceNum == 0) {
            return new String(charArray);
        }

        int indexOld = charArray.length - 1;
        int newLength = charArray.length + 2 * spaceNum;
        int indexNew = newLength - 1;

        char[] newChar = new char[newLength];

        while (indexOld >= 0) {

            if (charArray[indexOld] == ' ') {
                newChar[indexNew] = '0';
                newChar[indexNew - 1] = '2';
                newChar[indexNew - 2] = '%';
                indexNew = indexNew - 3;
            } else {
                newChar[indexNew] = charArray[indexOld];
                indexNew--;
            }
            indexOld--;
        }
        return new String(newChar);
    }
}
