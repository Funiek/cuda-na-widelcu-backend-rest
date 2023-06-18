package pl.ds360.cudanawidelcubackendrest.entities;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@XmlRootElement
public class MyLink extends Link {
    private URI href;
    private String title;

    public MyLink() {}

    public MyLink(String href, String title) throws URISyntaxException {
        this.href = new URI(href);
        this.title = title;
    }
    @Override
    public URI getUri() {
        return href;
    }

    @Override
    public UriBuilder getUriBuilder() {
        return null;
    }

    @Override
    public String getRel() {
        return null;
    }

    @Override
    public List<String> getRels() {
        return null;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public Map<String, String> getParams() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
