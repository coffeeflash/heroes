package ch.bfh.coffeeflash.promoter.client;

import ch.bfh.coffeeflash.promoter.model.Party;

import java.util.List;

public interface ArenaClient {
    String battle(List<Party> challangers);
}
