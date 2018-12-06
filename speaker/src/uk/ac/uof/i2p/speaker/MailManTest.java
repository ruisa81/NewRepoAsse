package uk.ac.uof.i2p.speaker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MailManTest {

    @Test
    void getFirstURLTest() {

        MailMan mailMan = new MailMan();
        String url = mailMan.getFirstURL();

        Assertions.assertEquals("http://i2j.openode.io/student?id=s195237",url);
    }
}