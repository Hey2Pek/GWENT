package com.example.gwent;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private List<Card> meleeRow;
    private List<Card> rangedRow;
    private List<Card> siegeRow;
    private boolean meleeWeatherActive = false;
    private boolean rangedWeatherActive = false;
    private boolean siegeWeatherActive = false;
    private Game game;

    public GameBoard(Game game) {
        this.game = game;
        this.meleeRow = new ArrayList<>();
        this.rangedRow = new ArrayList<>();
        this.siegeRow = new ArrayList<>();
    }

    public void playCard(Card card) {
        if (card.isWeather()) {
            game.applyWeather(card);
        } else {
            switch (card.getRange()) {
                case "MELEE":
                    meleeRow.add(card);
                    break;
                case "RANGED":
                    rangedRow.add(card);
                    break;
                case "SIEGE":
                    siegeRow.add(card);
                    break;
                default:
                    System.out.println("Invalid card range.");
            }
        }
    }

    public HBox renderRow(String rowType) {
        HBox rowBox = new HBox();
        rowBox.setStyle("-fx-border-color: black; -fx-padding: 10;");
        List<Card> row;
        switch (rowType) {
            case "MELEE":
                row = meleeRow;
                break;
            case "RANGED":
                row = rangedRow;
                break;
            case "SIEGE":
                row = siegeRow;
                break;
            default:
                throw new IllegalArgumentException("Invalid row type.");
        }
        int rowPower = calculateRowPower(row, isWeatherActive(rowType));
        rowBox.getChildren().add(new Label(rowType + " Row (Power: " + rowPower + ")"));
        row.forEach(card -> {
            int power = calculateCardPower(card, rowType);
            rowBox.getChildren().add(new CardView(new Card(card.getName(), power, card.getRange()), game));
        });
        return rowBox;
    }

    private int calculateCardPower(Card card, String rowType) {
        if (card.isHero()) {
            return card.getPower();
        }

        if ((meleeWeatherActive && rowType.equals("MELEE")) ||
                (rangedWeatherActive && rowType.equals("RANGED")) ||
                (siegeWeatherActive && rowType.equals("SIEGE"))) {
            return 1;
        } else {
            return card.getPower();
        }
    }

    private boolean isWeatherActive(String rowType) {
        switch (rowType) {
            case "MELEE":
                return meleeWeatherActive;
            case "RANGED":
                return rangedWeatherActive;
            case "SIEGE":
                return siegeWeatherActive;
            default:
                return false;
        }
    }

    public VBox renderGameBoard() {
        VBox board = new VBox();
        board.getChildren().add(renderRow("MELEE"));
        board.getChildren().add(renderRow("RANGED"));
        board.getChildren().add(renderRow("SIEGE"));
        return board;
    }

    public int calculateTotalPower() {
        return calculateRowPower(meleeRow, meleeWeatherActive) +
                calculateRowPower(rangedRow, rangedWeatherActive) +
                calculateRowPower(siegeRow, siegeWeatherActive);
    }

    private int calculateRowPower(List<Card> row, boolean weatherActive) {
        if (weatherActive) {
            return row.stream().mapToInt(card -> card.isHero() ? card.getPower() : 1).sum();
        } else {
            return row.stream().mapToInt(Card::getPower).sum();
        }
    }

    public void setMeleeWeatherActive(boolean active) {
        this.meleeWeatherActive = active;
    }

    public void setRangedWeatherActive(boolean active) {
        this.rangedWeatherActive = active;
    }

    public void setSiegeWeatherActive(boolean active) {
        this.siegeWeatherActive = active;
    }
}
