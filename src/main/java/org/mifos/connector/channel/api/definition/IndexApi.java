package org.mifos.connector.channel.api.definition;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface IndexApi {

    @GetMapping("/")
    String index(HttpServletResponse response) throws Exception;

}
