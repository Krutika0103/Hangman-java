package com.hangman.contoller;

import org.junit.jupiter.api.Test;
import com.hangman.model.Hangman;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests only HangmanController independent methods, it is checking game state
 */
class HangmanControllerTest {

    Hangman hangman = new Hangman("test");
    HangmanController hangmanController = new HangmanController(hangman, null, null);

    @Test
    void getHangmanGameStateShouldReturnInProgressState() {
        assertEquals(HangmanGameState.IN_PROGRESS, hangmanController.getHangmanGameState());
    }

    @Test
    void getHangmanGameStateShouldReturnFinishedState() {
        hangman.handleGuessedValue("test");
        hangmanController.checkIfGameIsComplete();
        assertEquals(HangmanGameState.FINISHED, hangmanController.getHangmanGameState());
    }

}