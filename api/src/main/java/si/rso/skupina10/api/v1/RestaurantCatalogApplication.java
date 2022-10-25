package si.rso.skupina10.api.v1;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("v1")
@OpenAPIDefinition(info = @Info(title="Restaurant Catalog API", version="v1",
        contact = @Contact(email="@rso.si"),
        license = @License(name="dev"), description = "API for managing nad getting restaurant info."))
public class RestaurantCatalogApplication extends javax.ws.rs.core.Application {
}
