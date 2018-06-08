package application.controller;

import application.utility.ChampionCircle;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import main.java.net.temuulen.riot.api.ApiConfiguration;
import main.java.net.temuulen.riot.api.RiotApi;
import main.java.net.temuulen.riot.api.endpoints.league.dto.LeaguePosition;
import main.java.net.temuulen.riot.api.endpoints.live.dto.CurrentGame;
import main.java.net.temuulen.riot.api.endpoints.live.dto.CurrentGameParticipant;
import main.java.net.temuulen.riot.api.endpoints.summoner.dto.Summoner;
import main.java.net.temuulen.riot.constants.Platform;
import main.java.net.temuulen.riot.constants.champion.ChampionList;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private AnchorPane anchorPane;
    @FXML private Label gameModeLabel;
    @FXML private TextField enterSummonerName;

    private ApiConfiguration apiConfiguration;
    private RiotApi api;

    private ChampionList championList;


    public void initialize(URL location, ResourceBundle resources) {

        championList = new ChampionList();

        apiConfiguration = new ApiConfiguration("-");
        api = new RiotApi(apiConfiguration);

        enterSummonerName.setOnAction(e -> {
            searchSummoner(enterSummonerName.getText());
        });


    }

    private void searchSummoner(String summonerName) {

        System.out.println(anchorPane.getChildren().size());
        anchorPane.getChildren().clear();

        Summoner summoner = null;
        CurrentGame currentGame = null;
        try {
            summoner = api.getSummonerByName(Platform.NA, summonerName);
            currentGame = api.getLiveGameById(Platform.NA, summoner.getID());
        } catch (IOException e) {
            e.printStackTrace();
        }

        gameModeLabel.setText(currentGame.getGameMode());

        CurrentGameParticipant[] currentGameParticipants = currentGame.getParticipants();

        ArrayList<CurrentGameParticipant> teamOne = getCurrentGameParticipants(currentGameParticipants, 100);
        for(int i=0; i<teamOne.size(); i++) {
            new ChampionCircle(anchorPane, championList.getChampionKey(teamOne.get(i).getChampionId()), 340 + 150 * i, 250);

            LeaguePosition[] leaguePosition = null;
            try {
                leaguePosition = api.getLeaguePositionById(Platform.NA, teamOne.get(i).getSummonerId());
            } catch (IOException e) {
                e.printStackTrace();
            }

            Circle circle = new Circle(340 + 150 * i, 250, 64);
            circle.setFill(Paint.valueOf("#ffffff22"));
            circle.setStrokeWidth(0);

            Label label = new Label(leaguePosition[0].getTier().substring(0, 1).toUpperCase() + leaguePosition[0].getRank());
            label.setLayoutX((340 - 64) + 150 * i);
            label.setLayoutY(250 - 64);
            label.setFont(Font.font("MaisonNeue-Bold", 36));
            label.setPrefWidth(128);
            label.setPrefHeight(128);
            label.setAlignment(Pos.CENTER);
            label.setTextFill(Paint.valueOf("#000000"));
            anchorPane.getChildren().addAll(circle, label);
        }

        ArrayList<CurrentGameParticipant> teamTwo = getCurrentGameParticipants(currentGameParticipants, 200);
        for(int i=0; i<5; i++) {
            new ChampionCircle(anchorPane, championList.getChampionKey(teamTwo.get(i).getChampionId()), 340 + 150 * i, 486);

            LeaguePosition[] leaguePosition = null;
            try {
                leaguePosition = api.getLeaguePositionById(Platform.NA, teamTwo.get(i).getSummonerId());
            } catch (IOException e) {
                e.printStackTrace();
            }

            Circle circle = new Circle(340 + 150 * i, 486, 64);
            circle.setFill(Paint.valueOf("#ffffff22"));
            circle.setStrokeWidth(0);

            Label label = new Label(leaguePosition[0].getTier().substring(0, 1).toUpperCase() + leaguePosition[0].getRank());
            label.setLayoutX((340 - 64) + 150 * i);
            label.setLayoutY(486 - 64);
            label.setFont(Font.font("MaisonNeue-Bold", 36));
            label.setPrefWidth(128);
            label.setPrefHeight(128);
            label.setAlignment(Pos.CENTER);
            label.setTextFill(Paint.valueOf("#000000"));
            anchorPane.getChildren().addAll(circle, label);
        }
    }

    private Label createLabel(String text, int x, int y) {
        Label label = new Label(text);
        label.setFont(Font.font("MaisonNeue-Bold", 13));
        label.setTextFill(Paint.valueOf("#F35353"));
        label.setLayoutX(x);
        label.setLayoutY(y);
        return label;
    }

    private ArrayList<CurrentGameParticipant> getCurrentGameParticipants(CurrentGameParticipant[] currentGameParticipants, long teamId) {
        ArrayList<CurrentGameParticipant> participants = new ArrayList<>();
        for(CurrentGameParticipant p : currentGameParticipants) {
            if(p.getTeamId() == teamId)
                participants.add(p);
        }
        return participants;
    }

}
