package com.example.gwent;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private Label playerScoreLabel;
    private Label computerScoreLabel;
    private Label roundLabel;
    private Label matchStatusLabel;
    private Game game;
    private VBox playerBoardContainer;
    private HBox playerHandBox;
    private int playerRoundsWon = 0;
    private int computerRoundsWon = 0;
    private int currentRound = 1;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Scene scene = new Scene(root, 800, 600);

        Label selectDeckLabel = new Label("Select your deck:");
        ComboBox<String> deckSelection = new ComboBox<>();
        deckSelection.getItems().addAll("Nilfgaard", "Northern Realms", "Scoia'tael", "Monsters");
        Button startGameButton = new Button("Start Game");

        playerScoreLabel = new Label("Player Total Power: 0");
        computerScoreLabel = new Label("Computer Total Power: 0");
        roundLabel = new Label("Round: 1");
        matchStatusLabel = new Label();

        root.getChildren().addAll(selectDeckLabel, deckSelection, startGameButton);

        startGameButton.setOnAction(e -> {
            String selectedDeck = deckSelection.getValue();
            if (selectedDeck != null) {
                startNewRound(selectedDeck, root);
            }
        });

        primaryStage.setTitle("The Witcher 3: Gwent");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startNewRound(String selectedDeck, VBox root) {
        game = new Game();
        game.setupGame(selectedDeck);

        VBox gameBoard = game.renderGameBoard();
        playerHandBox = renderPlayerHand();

        playerBoardContainer = new VBox();
        playerBoardContainer.getChildren().addAll(gameBoard, playerHandBox);

        HBox scoreBoard = new HBox();
        scoreBoard.getChildren().addAll(playerScoreLabel, computerScoreLabel);

        root.getChildren().clear();
        root.getChildren().addAll(roundLabel, playerBoardContainer, scoreBoard, matchStatusLabel);

        updateScores();
    }

    private HBox renderPlayerHand() {
        HBox playerHandBox = new HBox();
        playerHandBox.getChildren().add(new Label("Player Hand"));
        game.getPlayerHand().forEach(card -> {
            Button cardButton = new Button(card.getName() + " (" + card.getPower() + ")");
            cardButton.setOnAction(e -> {
                game.playCard(card, true);
                game.getPlayerHand().remove(card);
                playerHandBox.getChildren().remove(cardButton);
                updatePlayerBoard();
                updatePlayerHand();
                if (!game.getComputerHand().isEmpty()) {
                    Card computerCard = game.getComputerHand().remove(0);
                    game.playCard(computerCard, false);
                    updateComputerBoard();
                }
                updateScores();
                checkRoundEnd();
            });
            playerHandBox.getChildren().add(cardButton);
        });
        return playerHandBox;
    }

    private void updatePlayerBoard() {
        playerBoardContainer.getChildren().set(0, game.renderGameBoard());
    }

    private void updateComputerBoard() {
        playerBoardContainer.getChildren().set(0, game.renderGameBoard());
    }

    private void updateScores() {
        playerScoreLabel.setText("Player Total Power: " + game.getPlayerTotalPower());
        computerScoreLabel.setText("Computer Total Power: " + game.getComputerTotalPower());
    }

    private void updatePlayerHand() {
        playerHandBox.getChildren().clear();
        playerHandBox.getChildren().add(new Label("Player Hand"));
        game.getPlayerHand().forEach(card -> {
            Button cardButton = new Button(card.getName() + " (" + card.getPower() + ")");
            cardButton.setOnAction(e -> {
                game.playCard(card, true);
                game.getPlayerHand().remove(card);
                playerHandBox.getChildren().remove(cardButton);
                updatePlayerBoard();
                updatePlayerHand();
                if (!game.getComputerHand().isEmpty()) {
                    Card computerCard = game.getComputerHand().remove(0);
                    game.playCard(computerCard, false);
                    updateComputerBoard();
                }
                updateScores();
                checkRoundEnd();
            });
            playerHandBox.getChildren().add(cardButton);
        });
    }

    private void checkRoundEnd() {
        if (game.getPlayerHand().isEmpty()) {
            int playerPower = game.getPlayerTotalPower();
            int computerPower = game.getComputerTotalPower();
            if (playerPower > computerPower) {
                playerRoundsWon++;
                displayRoundResult("Player wins this round!");
            } else if (computerPower > playerPower) {
                computerRoundsWon++;
                displayRoundResult("Computer wins this round!");
            } else {
                displayRoundResult("This round is a tie!");
            }

            updateMatchStatus();

            if (playerRoundsWon == 2 || computerRoundsWon == 2) {
                endMatch();
            } else {
                startNextRound();
            }
        }
    }

    private void displayRoundResult(String result) {
        Label resultLabel = new Label(result);
        resultLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: blue;");
        VBox root = (VBox) roundLabel.getScene().getRoot();
        root.getChildren().add(resultLabel);
    }

    private void updateMatchStatus() {
        matchStatusLabel.setText("Player Rounds Won: " + playerRoundsWon + " | Computer Rounds Won: " + computerRoundsWon);
        matchStatusLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
    }

    private void startNextRound() {
        currentRound++;
        roundLabel.setText("Round: " + currentRound);
        VBox root = (VBox) roundLabel.getScene().getRoot();
        Label selectDeckLabel = new Label("Select your deck:");
        ComboBox<String> deckSelection = new ComboBox<>();
        deckSelection.getItems().addAll("Nilfgaard", "Northern Realms", "Scoia'tael", "Monsters");
        Button nextRoundButton = new Button("Start Next Round");

        root.getChildren().clear();
        root.getChildren().addAll(selectDeckLabel, deckSelection, nextRoundButton);

        nextRoundButton.setOnAction(e -> {
            String selectedDeck = deckSelection.getValue();
            if (selectedDeck != null) {
                startNewRound(selectedDeck, root);
            }
        });
    }

    private void endMatch() {
        VBox root = (VBox) roundLabel.getScene().getRoot();
        String matchResult;
        if (playerRoundsWon == 2) {
            matchResult = "Player wins the match!";
        } else {
            matchResult = "Computer wins the match!";
        }

        Label matchResultLabel = new Label(matchResult);
        matchResultLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: red; -fx-font-weight: bold;");

        ImageView resultImageView = new ImageView(new Image("file:resources/trophy.png"));
        resultImageView.setFitWidth(100);
        resultImageView.setFitHeight(100);

        Button replayButton = new Button("Replay");
        Button closeButton = new Button("Close Game");

        replayButton.setOnAction(e -> resetGame(root));
        closeButton.setOnAction(e -> System.exit(0));

        root.getChildren().clear();
        root.getChildren().addAll(matchResultLabel, resultImageView, matchStatusLabel, replayButton, closeButton);
    }

    private void resetGame(VBox root) {
        playerRoundsWon = 0;
        computerRoundsWon = 0;
        currentRound = 1;
        roundLabel.setText("Round: 1");
        matchStatusLabel.setText("");
        root.getChildren().clear();
        root.getChildren().add(new Label("Select your deck:"));
        ComboBox<String> deckSelection = new ComboBox<>();
        deckSelection.getItems().addAll("Nilfgaard", "Northern Realms", "Scoia'tael", "Monsters");
        Button startGameButton = new Button("Start Game");

        root.getChildren().addAll(deckSelection, startGameButton);

        startGameButton.setOnAction(e -> {
            String selectedDeck = deckSelection.getValue();
            if (selectedDeck != null) {
                startNewRound(selectedDeck, root);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}