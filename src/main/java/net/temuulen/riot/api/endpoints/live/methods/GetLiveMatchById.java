package main.java.net.temuulen.riot.api.endpoints.live.methods;

import main.java.net.temuulen.riot.api.ApiConfiguration;
import main.java.net.temuulen.riot.api.Method;
import main.java.net.temuulen.riot.api.endpoints.live.dto.CurrentGame;
import main.java.net.temuulen.riot.api.endpoints.summoner.dto.Summoner;
import main.java.net.temuulen.riot.constants.Platform;

public class GetLiveMatchById extends Method {

    public GetLiveMatchById(Platform platform, ApiConfiguration apiConfiguration, long accountId) {
        super(platform.getHost() + "/lol/spectator/v3/active-games/by-summoner/" + accountId + "?api_key=" + apiConfiguration.getKey(), CurrentGame.class);
    }

}
