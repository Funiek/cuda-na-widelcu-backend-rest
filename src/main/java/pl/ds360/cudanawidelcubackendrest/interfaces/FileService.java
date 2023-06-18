package pl.ds360.cudanawidelcubackendrest.interfaces;

import java.io.IOException;

public interface FileService {
    byte[] downloadImage(String recipeName);
    byte[] downloadRecipeProductsPdf(String recipeName, String products) throws IOException;
}
