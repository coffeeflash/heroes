package ch.bfh.coffeeflash.promoter.client;

import ch.bfh.coffeeflash.promoter.model.Party;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArenaClientFallback implements ArenaClient{
    @Override
    public String battle(List<Party> challengers) {
        return "Sorry the arena is somehow busy ..., try again later";
    }
}
