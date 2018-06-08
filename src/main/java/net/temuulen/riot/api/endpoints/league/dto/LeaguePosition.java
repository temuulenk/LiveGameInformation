package main.java.net.temuulen.riot.api.endpoints.league.dto;

public class LeaguePosition {

    private String rank;
    private String queueType;
    private boolean hotStreak;
    private MiniSeries miniSeries;
    private int wins;
    private boolean veteran;
    private int losses;
    private boolean freshBlood;
    private String leagueId;
    private String playerOrTeamName;
    private boolean inactive;
    private String leagueName;
    private String tier;
    private int leaguePoints;

    public String getRank() {
        return rank;
    }

    public String getQueueType() {
        return queueType;
    }

    public boolean isHotStreak() {
        return hotStreak;
    }

    public MiniSeries getMiniSeries() {
        return miniSeries;
    }

    public int getWins() {
        return wins;
    }

    public boolean isVeteran() {
        return veteran;
    }

    public int getLosses() {
        return losses;
    }

    public boolean isFreshBlood() {
        return freshBlood;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    public boolean isInactive() {
        return inactive;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public String getTier() {
        return tier;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }
}
