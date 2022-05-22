package com.graphql.user.util;

import graphql.GraphQLException;

import java.io.IOException;

public class GraphqlSchemaReaderUtil {
    
    public static String getSchemaFromFileName(final String filename) {
        try {
            return new String(GraphqlSchemaReaderUtil.class.getClassLoader()
                    .getResourceAsStream("graphql/integration/" + filename + ".graphqls").readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
            throw new GraphQLException("Error trying to featch schema file.");
        }
    }
}
