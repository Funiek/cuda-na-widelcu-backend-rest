package pl.ds360.cudanawidelcubackendrest.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Base64;

@Provider
public class MyRequestFilter implements ContainerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BASIC_AUTH_PREFIX = "Basic ";

    private String expectedUsername;
    private String expectedPassword;

    public MyRequestFilter() {
        expectedUsername = "root";
        expectedPassword = "root";
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Sprawdzenie, czy w nagłówku jest podane Basic Auth
        String authHeader = requestContext.getHeaderString(AUTHORIZATION_HEADER);
        if (authHeader != null && authHeader.startsWith(BASIC_AUTH_PREFIX)) {
            // Odczytanie danych Basic Auth i rozkodowanie ich
            String encodedCredentials = authHeader.substring(BASIC_AUTH_PREFIX.length());
            String credentials = new String(Base64.getDecoder().decode(encodedCredentials));
            String[] parts = credentials.split(":");
            if (parts.length == 2) {
                String username = parts[0];
                String password = parts[1];

                // Sprawdzenie zgodności odczytanych danych z oczekiwanymi
                if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
                    // Autoryzacja udana - przepuszczenie żądania dalej
                    return;
                }
            }
        }

        // Autoryzacja nieudana - zwrócenie kodu 401 Unauthorized
        Response unauthorizedResponse = Response.status(Response.Status.UNAUTHORIZED)
                .header(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"Restricted Area\"")
                .entity("Unauthorized")
                .build();
        requestContext.abortWith(unauthorizedResponse);
    }
}