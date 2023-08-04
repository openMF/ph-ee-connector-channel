package org.mifos.connector.channel;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUtil {

    private Logger log = LoggerFactory.getLogger(TestUtil.class);

    @Test
    public void test1() {
        log.info(" {}", UUID.randomUUID().toString());
    }
}
