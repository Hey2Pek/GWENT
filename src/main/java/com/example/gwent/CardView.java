package com.example.gwent;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CardView extends VBox {
    private Card card;
    private Game game;

    public CardView(Card card, Game game) {
        this.card = card;
        this.game = game;
        renderCard();
    }

    private void renderCard() {
        this.getChildren().clear();
        Label nameLabel = new Label("Name: " + card.getName());
        Label powerLabel = new Label("Power: " + card.getPower());
        Label rangeLabel = new Label("Range: " + card.getRange());
        this.getChildren().addAll(nameLabel, powerLabel, rangeLabel);
        this.setStyle("-fx-border-color: black; -fx-padding: 5; -fx-background-color: lightgray;");
    }
}
