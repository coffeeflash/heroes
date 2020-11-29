package ch.bfh.coffeeflash.arena.service;

import ch.bfh.coffeeflash.arena.model.Party;

public interface BattleService {
    public String battle(Party challengeeParty, Party challengerParty);
}
