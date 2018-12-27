package uk.ac.uof.i2p.coms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MailManTest {

    @Test
    void getFirstURLTest() {

        MailMan mailMan1 = new MailMan("s195237");
        String url = mailMan1.getFirstURL();

        Assertions.assertEquals("http://i2j.openode.io/student?id=s195237",url);

        MailMan mailMan0 = new MailMan();
        String url0 = mailMan1.getFirstURL();

        Assertions.assertEquals("http://i2j.openode.io/student?id=s195237",url0);
    }




}