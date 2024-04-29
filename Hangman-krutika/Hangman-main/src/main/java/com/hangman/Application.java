package com.hangman;

import com.hangman.contoller.HangmanController;
import com.hangman.contoller.HangmanGameState;
import com.hangman.model.Hangman;
import com.hangman.view.HangmanView;
import com.hangman.view.HangmanViewController;

import java.io.IOException;
import java.util.*;

/**
 * Hangman game, user has to guess word which is randomly chosen from words at start of game.
 * Game ends if user guess the word or mismatch ten times. Special behavior comes if
 * user sends end of transmission character, that will provide applications end.
 * @author krutika
 * @version 1.0
 */
public class Application {

    /**
     * In main are initialized words table, model, view and controllers. Word to guess
     * is randomly picked from table. HangmanController is used as main controller
     * in game loop, which is refreshing view, taking users input and checking state
     * of game.
     * @param args  Are not used
     */
    public static void main(String[] args) {
/*        List<String> words = new ArrayList<>();
        words.add("forest");
        words.add("sword");
        words.add("union");
        words.add("collection");
        words.add("company");
        words.add("city"};*/
    List<String> words = new ArrayList<>();
        words.add("krutika");
        words.add("tanvi");
        words.add("santosh");
        words.add("jayshreeram");
        words.add("siddharth");
        words.add("srushti");
        words.add("android");
        words.add("backend");
        words.add("waterbottle");
        words.add("box");
        words.add("stella");
        words.add("max");
        words.add("india");
        words.add("laptop");
        words.add("chair");
        words.add("table");
        words.add("home");
        words.add("charger");
        words.add("dashmi");
        words.add("shravni");
        words.add("clothes");
        words.add("bed");
        words.add("burger");
        words.add("pizza");
        words.add("kfc");
        words.add("baggyjeans");
        words.add("japan");
        words.add("anime");

        Random random = new Random(new Date().getTime());
        Hangman hangman = new Hangman(words.get(Math.abs(random.nextInt() % words.size())));
        HangmanView hangmanView = new HangmanView();
        HangmanViewController hangmanViewController = new HangmanViewController(new Scanner(System.in));
        HangmanController hangmanController = new HangmanController(hangman, hangmanView, hangmanViewController);

        try {
            hangmanController.printFirstView();

            do {
                hangmanController.refresh();
                hangmanController.guess();
                hangmanController.checkIfGameIsComplete();
            } while (hangmanController.getHangmanGameState().equals(HangmanGameState.IN_PROGRESS));

            hangmanController.printFinalView();

            System.out.println("Press enter key to close application.");
            new Scanner(System.in).nextLine();
        }
        catch (IllegalArgumentException | IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}