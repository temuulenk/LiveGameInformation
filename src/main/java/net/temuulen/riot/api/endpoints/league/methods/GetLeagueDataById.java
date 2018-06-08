package main.java.net.temuulen.riot.api.endpoints.league.methods;

import main.java.net.temuulen.riot.api.ApiConfiguration;
import main.java.net.temuulen.riot.api.Method;
import main.java.net.temuulen.riot.api.endpoints.league.dto.LeaguePosition;
import main.java.net.temuulen.riot.constants.Platform;

public class GetLeagueDataById extends Method {

    public GetLeagueDataById(Platform platform, ApiConfiguration apiConfiguration, long accountId) {
        super(platform.getHost() + "/lol/league/v3/positions/by-summoner/" + accountId + "?api_key=" + apiConfiguration.getKey(), LeaguePosition[].class);
    }

}
