package net.slowvic.test;

import java.io.IOException;

import org.apache.ibatis.type.TypeAliasRegistry;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class ResouceTest {

    public static void main(String[] args) throws IOException,
        ClassNotFoundException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver
            .getResources("net/slowvic/webservice/entity/*");
        ClassLoader classLoader = ResouceTest.class.getClassLoader();
        TypeAliasRegistry registry = new TypeAliasRegistry();
        for (Resource resource : resources) {
            System.out.println(resource.getFilename());
            if (resource.getFilename().endsWith(".class")) {
                String classFilePath = resource.getURI().getPath();
                int index = classFilePath.indexOf("classes");
                String className = classFilePath.substring(index + 8,
                    classFilePath.length() - 6).replaceAll("/", ".");
                Class<?> clz = classLoader.loadClass(className);
                registry.registerAlias(clz);
            }
        }
    }

}
