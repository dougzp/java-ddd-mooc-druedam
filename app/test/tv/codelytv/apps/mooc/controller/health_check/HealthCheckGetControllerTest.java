package tv.codelytv.apps.mooc.controller.health_check;

import org.junit.jupiter.api.Test;

import tv.codelytv.apps.mooc.controller.RequestTestCase;


final class HealthCheckGetControllerTest extends RequestTestCase {

    @Test
    void check_health_check_is_working() throws Exception {
        assertResponse("/health-check", 200, "{'status':'ok'}");
    }

}
