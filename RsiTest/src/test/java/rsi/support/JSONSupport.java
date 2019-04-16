package rsi.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.json.internal.LazyMap;

import java.io.File;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author Lucas
 */
public class JSONSupport {
    private static Function<String, File> getCustomerFileReader = filename -> {
        final ClassLoader cl = JSONSupport.class.getClassLoader();
        return new File(Objects.requireNonNull(cl.getResource(filename)).getFile());
    };

    public static LazyMap getLazyMap(String fileName, String basePath) throws java.io.IOException {
        final File jsonFile = getCustomerFileReader.apply(basePath + fileName);
        return new ObjectMapper().readValue(jsonFile, LazyMap.class);
    }
}
