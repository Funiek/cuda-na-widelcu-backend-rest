package pl.ds360.cudanawidelcubackendrest.entities;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "Category")
public enum Category {
    BREAKFAST, LUNCH, DINNER
}
