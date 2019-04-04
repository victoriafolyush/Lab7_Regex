package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {
    private String line;
    private String number;
    private List<String> list;

    public StringProcessor() {

    }

    StringProcessor(final String lineTemp, final String numberTemp) {
        this.line = lineTemp;
        this.number = numberTemp;
    }

    public final String getLine() {
        return line;
    }

    public final void setLine(final String lineTemp) {
        this.line = lineTemp;
    }

    public final String getNumber() {
        return number;
    }

    public final void setNumber(final String numberTemp) {
        this.number = numberTemp;
    }

    public final List<String> getList() {
        return list;
    }

    public final void setList(final List<String> listTemp) {
        this.list = listTemp;
    }

    public final void readInputText() throws IOException {

        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the text: ");
        this.line = bufReader.readLine();
        System.out.print("Enter the number: ");
        this.number = bufReader.readLine();
        bufReader.close();
    }

    public final List<String> findMatch() {
        list = new LinkedList<String>();
        Pattern wordsWithNumbers = Pattern.compile("\\b\\w" + this.number + "(\\w+)??\\b");
        Matcher matcher = wordsWithNumbers.matcher(this.getLine());
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    public final void showResults() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Show words with number (" + this.number + ") in the text.");

        if (list.isEmpty()) {
            System.out.println("There is no matches found :( ");
        } else {
            System.out.println("Result: " + list);
        }
    }
}
