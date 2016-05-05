package com.capella.apache.tika;

import org.hamcrest.CoreMatchers;

import java.io.InputStream;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test for simple MetadataParser.
 */
public class MetadataParserTest {

    @org.junit.Test
    public void testGetMetaData() {
        InputStream inputStream = MetadataParserTest.class.getClassLoader().getResourceAsStream("poi.doc");
        Map<String, Object> meatadata = MetadataParser.getMeatadata(inputStream);
        assertThat(meatadata.get("Content-Type"), CoreMatchers.<Object>is("application/msword"));
    }
}
