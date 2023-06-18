package pl.ds360.cudanawidelcubackendrest.entities;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlType(name = "Recipe")
public class Recipe implements Serializable {
    private static final long serialVersionUID = 1286393242028201686L;

    private int id;
    private int nextProductId;
    private String name;
    private String description;
    private byte[] image;
    private ArrayList<Product> products;
    private Double rating;
    private ArrayList<Integer> votes;
    private int countVotes;
    private Category category;

    private ArrayList<Link> links;

    public Recipe(int id, int nextProductId, String name, String description, byte[] image, ArrayList<Product> products, Double rating, ArrayList<Integer> votes, int countVotes, Category category, ArrayList<Link> links) {
        this.id = id;
        this.nextProductId = nextProductId;
        this.name = name;
        this.description = description;
        this.image = image;
        this.products = products;
        this.rating = rating;
        this.votes = votes;
        this.countVotes = countVotes;
        this.category = category;
        this.links = links;
    }

    public Recipe(int id, String name, String description) {
        this.id = id;
        this.nextProductId = -1;
        this.name = name;
        this.description = description;
        this.products = new ArrayList<>();
        this.rating = 0.0;
        this.votes = new ArrayList<>();
        this.countVotes = 0;
        this.links = new ArrayList<>();
    }

    public Recipe(int id, String name, String description, Category category) {
        this.id = id;
        this.nextProductId = -1;
        this.name = name;
        this.description = description;
        this.products = new ArrayList<>();
        this.rating = 0.0;
        this.votes = new ArrayList<>();
        this.countVotes = 0;
        this.category = category;
        this.links = new ArrayList<>();
    }

    public Recipe(int id, String name, String description, Category category, ArrayList<Product> products) {
        this.id = id;
        this.nextProductId = -1;
        this.name = name;
        this.description = description;
        this.products = products;
        this.rating = 0.0;
        this.votes = new ArrayList<>();
        this.countVotes = 0;
        this.category = category;
        this.links = new ArrayList<>();
    }

    public Recipe() {
        this.nextProductId = -1;
        this.products = new ArrayList<>();
        this.rating = 0.0;
        this.votes = new ArrayList<>();
        this.countVotes = 0;
        this.links = new ArrayList<>();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ArrayList<Integer> getVotes() {
        return votes;
    }

    public void setVotes(ArrayList<Integer> votes) {
        this.votes = votes;
    }

    public void addVote(Integer vote) {
        votes.add(vote);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getCountVotes() {
        return countVotes;
    }

    public void setCountVotes(int countVotes) {
        this.countVotes = countVotes;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getNextProductId() {
        return nextProductId;
    }

    public void setNextProductId(int nextProductId) {
        this.nextProductId = nextProductId;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if(product.getId() == -1) {
            product.setId(++this.nextProductId);
        }

        products.add(product);
    }

    public void deleteProduct(int id) {
        products.remove(id);
    }

    public ArrayList<Link> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<Link> links) {
        this.links = links;
    }

    public void addLink(String uri, String title) throws URISyntaxException {
        Link link = new MyLink(uri, title);

        for(Link l: links) {
            if(l.getTitle().equals(title))
                return;
        }
        links.add(link);
    }
}

