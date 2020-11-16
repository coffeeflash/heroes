package ch.bfh.coffeeflash.camp.model;

import org.springframework.hateoas.RepresentationModel;

import java.util.List;

public class Party extends RepresentationModel {

    private String name;
    private List<Hero> members;

    public Party(String name, List<Hero> members) {
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hero> getMembers() {
        return members;
    }

    public void setMembers(List<Hero> members) {
        this.members = members;
    }
}
