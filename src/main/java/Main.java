import model.MyDoc;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String delimiter = "/";
        String dataset_file = "Dataset/doc-text";
        String queries_file = "Dataset/query-text";
        String relevance_assessments_file = "Dataset/rlv-ass";
        String index_directory = "./index";
        String query_field = "content";
        List<MyDoc> documents;
        List<MyDoc> queries;
        List<MyDoc> relevance_assessments;

        // Data parsing
        documents = Parser.parse(dataset_file, delimiter);
        queries = Parser.parse(queries_file, delimiter);
        relevance_assessments = Parser.parse(relevance_assessments_file, delimiter);


        // Indexing
        Indexer indexer = new Indexer(documents, index_directory);
        indexer.index();

        // Searching
        Searcher.executeQueries(index_directory, query_field, queries, 20);

    }
}
