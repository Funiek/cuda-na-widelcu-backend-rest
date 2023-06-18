package pl.ds360.cudanawidelcubackendrest.entities;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement
@XmlType(name = "Product")
public class Product implements Serializable {
    private static final long serialVersionUID = 8286393242028201686L;

    private int id;
    private String name;
    private String measure;
    private Double qty;

    public Product(String name, String measure, Double qty) {
        super();
        this.id = -1;
        this.name = name;
        this.measure = measure;
        this.qty = qty;
    }

    public Product(int id, String name, String measure, Double qty) {
        super();
        this.id = id;
        this.name = name;
        this.measure = measure;
        this.qty = qty;
    }

    public Product() {
        super();
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }
}