package main.java.net.temuulen.riot.api.endpoints.live.dto;

public class CurrentGameParticipant {

    private long profileIconId;
    private long championId;
    private String summonerName;
    private GameCustomizationObject[] gameCustomizationObjects;
    private boolean bot;
    private Perks perks;
    private long spell2Id;
    private long teamId;
    private long spell1Id;
    private long summonerId;


    public long getProfileIconId() {
        return profileIconId;
    }

    public long getChampionId() {
        return championId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public GameCustomizationObject[] getGameCustomizationObjects() {
        return gameCustomizationObjects;
    }

    public boolean isBot() {
        return bot;
    }

    public Perks getPerks() {
        return perks;
    }

    public long getSpell2Id() {
        return spell2Id;
    }

    public long getTeamId() {
        return teamId;
    }

    public long getSpell1Id() {
        return spell1Id;
    }

    public long getSummonerId() {
        return summonerId;
    }
}
