package pl.ds360.cudanawidelcubackendrest;

import pl.ds360.cudanawidelcubackendrest.exceptions.MyExceptionMapper;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class HelloApplication extends Application {
    /*@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(MyExceptionMapper.class);

        return classes;
    }*/
}