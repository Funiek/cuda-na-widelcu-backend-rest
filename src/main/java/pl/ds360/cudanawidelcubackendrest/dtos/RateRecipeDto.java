package pl.ds360.cudanawidelcubackendrest.dtos;

import java.io.Serializable;

public class RateRecipeDto implements Serializable {
    private static final long serialVersionUID = 8286393212024201686L;
    private int id;
    private int vote;

    public RateRecipeDto(int id, int vote) {
        super();
        this.id = id;
        this.vote = vote;
    }

    public RateRecipeDto() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
