package com.capella.apache.tika;


import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

/**
 * Metadata parser
 */
public class MetadataParser {

    public static Map<String, Object> getMetadata(InputStream inputStream, String fileName) {
        Parser parser = new AutoDetectParser();

        ContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        metadata.add(Metadata.RESOURCE_NAME_KEY, fileName);
        Map<String, Object> metadataMap = new TreeMap<String, Object>();
        try {
            parser.parse(inputStream, handler, metadata, new ParseContext());

            String[] names = metadata.names();
            for (String name : names) {
                String value = metadata.get(name);
                metadataMap.put(name, value);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }

        return metadataMap;
    }
}
