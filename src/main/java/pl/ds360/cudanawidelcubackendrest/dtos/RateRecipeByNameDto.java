package pl.ds360.cudanawidelcubackendrest.dtos;

import java.io.Serializable;

public class RateRecipeByNameDto implements Serializable {
    private static final long serialVersionUID = 8286113212024201686L;
    private String name;
    private int vote;

    public RateRecipeByNameDto(String name, int vote) {
        super();
        this.name = name;
        this.vote = vote;
    }

    public RateRecipeByNameDto() {
        super();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
