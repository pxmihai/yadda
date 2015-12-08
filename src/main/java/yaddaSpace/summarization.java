package yaddaSpace;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class summarization {
    public String create() {
        String output="";
        try {

            // These code snippets use an open-source library. http://unirest.io/java
            HttpResponse<JsonNode> response = Unirest.post("https://textanalysis-text-summarization.p.mashape.com/text-summarizer-url")
                    .header("X-Mashape-Key", "sAqYRPqYO7mshcqrB1IKU1qWJmxfp1SdR29jsnHubfPfSILEfV")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Accept", "application/json")
                    .field("sentnum", 5)
                    .field("url", "http://en.wikipedia.org/wiki/Automatic_summarization")
                    .asJson();
            output=response.getBody().toString();


        } catch (UnirestException e) {
            e.printStackTrace();
        }
    return output;
    }
}

