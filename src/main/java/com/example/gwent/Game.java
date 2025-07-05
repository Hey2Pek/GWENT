package com.example.gwent;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private List<Card> playerHand;
    private List<Card> computerHand;
    private Deck playerDeck;
    private Deck computerDeck;
    private GameBoard playerBoard;
    private GameBoard computerBoard;
    private String[] deckTypes = {"Nilfgaard", "Northern Realms", "Scoia'tael", "Monsters"};

    public Game() {
        playerBoard = new GameBoard(this);
        computerBoard = new GameBoard(this);
    }

    public void setupGame(String playerDeckType) {
        playerDeck = new Deck(playerDeckType);
        playerHand = playerDeck.drawHand();

        String computerDeckType = deckTypes[new Random().nextInt(deckTypes.length)];
        while (computerDeckType.equals(playerDeckType)) {
            computerDeckType = deckTypes[new Random().nextInt(deckTypes.length)];
        }

        computerDeck = new Deck(computerDeckType);
        computerHand = computerDeck.drawHand();
    }

    public VBox renderGameBoard() {
        VBox board = new VBox();
        board.getChildren().add(new javafx.scene.control.Label("Player Board"));
        board.getChildren().add(playerBoard.renderGameBoard());
        board.getChildren().add(new javafx.scene.control.Label("Computer Board"));
        board.getChildren().add(computerBoard.renderGameBoard());
        return board;
    }

    public int getPlayerTotalPower() {
        return playerBoard.calculateTotalPower();
    }

    public int getComputerTotalPower() {
        return computerBoard.calculateTotalPower();
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public List<Card> getComputerHand() {
        return computerHand;
    }

    public void playCard(Card card, boolean isPlayer) {
        if (isPlayer) {
            if (card.isSpy()) {
                computerBoard.playCard(card);
                drawMultipleCards(playerHand, playerDeck, 2);
            } else {
                playerBoard.playCard(card);
            }
        } else {
            if (card.isSpy()) {
                playerBoard.playCard(card);
                drawMultipleCards(computerHand, computerDeck, 2);
            } else {
                computerBoard.playCard(card);
            }
        }
    }

    public void applyWeather(Card card) {
        switch (card.getName()) {
            case "ICE":
                playerBoard.setMeleeWeatherActive(true);
                computerBoard.setMeleeWeatherActive(true);
                break;
            case "RAIN":
                playerBoard.setRangedWeatherActive(true);
                computerBoard.setRangedWeatherActive(true);
                break;
            case "FOGGY":
                playerBoard.setSiegeWeatherActive(true);
                computerBoard.setSiegeWeatherActive(true);
                break;
            case "SUN":
                playerBoard.setMeleeWeatherActive(false);
                playerBoard.setRangedWeatherActive(false);
                playerBoard.setSiegeWeatherActive(false);
                computerBoard.setMeleeWeatherActive(false);
                computerBoard.setRangedWeatherActive(false);
                computerBoard.setSiegeWeatherActive(false);
                break;
            default:
                System.out.println("Invalid weather card.");
        }
    }

    private void drawMultipleCards(List<Card> hand, Deck deck, int count) {
        for (int i = 0; i < count; i++) {
            if (!deck.getRemainingCards().isEmpty()) {
                hand.add(deck.drawCard());
            } else {
                break;
            }
        }
    }
}