package OOP;

import java.util.ArrayList;

public class Application {
    private static String TEXT = "Bitcoin: The first ten years\n" +
            "Ten years ago today, Bitcoin was born. A mysterious person going by the fictitious name Satoshi Nakamoto released a paper, saying how his new money would work. It was meant to be a global, digital currency that governments and banks couldn't interfere with.\n" +
            "\n" +
            "So, a decade on, who uses it to trade? And why is Bitcoin itself - which started trading at 30 cents apiece - nowadays worth thousands of dollars?\n" +
            "\n" +
            "Video journalist: Jeremy Howell.";

    public static void main(String[] args) {
        int lenghtFilter = InputParsing.wordLengthInput();
        ArrayList<String> sentenses = InputParsing.getSentenses(TEXT);
        ArrayList<String> wordsInRange = InputParsing.getWordsWithGivenLength(sentenses,lenghtFilter);
        InputParsing.Output(wordsInRange);
    }
}
