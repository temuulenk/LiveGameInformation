package main.java.net.temuulen.riot.api.endpoints.live.dto;

public class CurrentGame {

    private long gameId;
    private long gameStartTime;
    private String platformId;
    private String gameMode;
    private long mapId;
    private String gameType;
    private BannedChampion[] bannedChampions;
    private Observer observers;
    private CurrentGameParticipant[] participants;
    private long gameLength;
    private long gameQueueConfigId;


    public long getGameId() {
        return gameId;
    }

    public long getGameStartTime() {
        return gameStartTime;
    }

    public String getPlatformId() {
        return platformId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public long getMapId() {
        return mapId;
    }

    public String getGameType() {
        return gameType;
    }

    public BannedChampion[] getBannedChampions() {
        return bannedChampions;
    }

    public Observer getObservers() {
        return observers;
    }

    public CurrentGameParticipant[] getParticipants() {
        return participants;
    }

    public long getGameLength() {
        return gameLength;
    }

    public long getGameQueueConfigId() {
        return gameQueueConfigId;
    }



}
