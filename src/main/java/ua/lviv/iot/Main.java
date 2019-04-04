package ua.lviv.iot;

import java.io.IOException;

final class Main {

    private Main() {
    }

    public static void main(final String[] args) throws IOException {

        StringProcessor manager = new StringProcessor();
        manager.readInputText();
        manager.findMatch();
        manager.showResults();
    }
}
