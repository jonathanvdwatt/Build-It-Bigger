package local.watt.javajokelib;

import java.util.Random;

public class JokeBook {

    public String[] mJokes = {
            "Programmer(noun.)\n\nA machine that turns coffee into code.",
            "Q: What is the object-oriented way to become wealthy?\n\nA: Inheritance.",
            "Q: What do you call a programmer from Finland?\n\nA: Nerdic.",
            "Q: What is a programmer's favorite hangout place?\n\nA: Foo Bar",
            "Q: Why did the programmer quit his job?\n\nA: Because he didn't get arrays."
    };

    public String getJoke() {
        String joke = "";

        Random random = new Random();
        int randomNumber = random.nextInt(mJokes.length);

        joke = mJokes[randomNumber];
        return joke;
    }
}