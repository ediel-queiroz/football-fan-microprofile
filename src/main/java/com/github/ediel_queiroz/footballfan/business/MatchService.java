package com.github.ediel_queiroz.footballfan.business;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class MatchService {

    private final SimpleCacheManager<String, Match> cacheManager;

    public MatchService(final SimpleCacheManager<String, Match> cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void add(final Match match) {
        cacheManager.put(match.id(), match);
    }

    public Match get(final String id) {
        return cacheManager.get(id);
    }

    public List<Match> listAll() {
        return cacheManager.listValues();
    }
}
