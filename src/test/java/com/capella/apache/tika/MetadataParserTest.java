package com.capella.apache.tika;

import org.apache.tika.metadata.Metadata;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test for simple MetadataParser.
 */
public class MetadataParserTest {

    @Test
    public void testGetMetaData() {
        InputStream inputStream = MetadataParserTest.class.getClassLoader().getResourceAsStream("poi.doc");
        Map<String, Object> meatadata = MetadataParser.getMetadata(inputStream,"poi.doc");
        System.out.println(meatadata);
        assertThat(meatadata.get(Metadata.CONTENT_TYPE), CoreMatchers.<Object>is("application/msword"));


        inputStream = MetadataParserTest.class.getClassLoader().getResourceAsStream("sample.pdf");
        meatadata = MetadataParser.getMetadata(inputStream, "sample.pdf");
        System.out.println(meatadata);
        assertThat(meatadata.get(Metadata.CONTENT_TYPE), CoreMatchers.<Object>is("application/pdf"));
    }
}
