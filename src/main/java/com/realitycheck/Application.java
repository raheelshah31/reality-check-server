package com.realitycheck;

import com.realitycheck.classifiers.VectorSpaceModel;
import com.realitycheck.parser.Parser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class Application {
    public static void main(String[] args){

        Parser docParser = new Parser("classpath:train.csv", "classpath:stopwords.txt");
        VectorSpaceModel vsm = new VectorSpaceModel(docParser.myDocsContentMap, docParser.stopWords, docParser.trainLabels);
       vsm.printTestStats(docParser.myDocsTestContentMap);
        SpringApplication.run(Application.class, args);

    }

}
