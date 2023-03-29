package org.mifos.connector.channel.GSMA_API;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

public interface GSMA_API {
    @GetMapping("/channel/gsma")
    String gsma(HttpServletResponse response) throws Exception;
}
