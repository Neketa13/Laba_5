import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {


    public static void main(String[] args) throws Exception {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        FileReader input = new FileReader("input.txt");
        FileWriter output = new FileWriter("output.txt");
        Scanner scanner = new Scanner(input);
        int i = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            stringArrayList.add(line);
        }
        //System.out.println(stringArrayList);
        Pattern pattern = Pattern.compile("(http://|https://)?([a-z]{2,10})([^_]\\.)([a-z-/]{2,15})?([^-][^_]\\.)?([a-z/#]{2,16})?[^-][^_]([^-][^_]\\.)?([0-9:]{1,5})?([a-z0-9-%&/_=?.])*");
        for (String element : stringArrayList) {
            Matcher mather = pattern.matcher(element);
            if (mather.matches()) output.write( element + " -- OK\n");
            else output.write( element + " -- ERROR\n");
            i++;
        }

        output.close();
        input.close();

    }
}












