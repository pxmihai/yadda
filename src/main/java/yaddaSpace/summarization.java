package yaddaSpace;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class summarization {
public String text1="The book is about a young lad, Nils Holgersson, whose \"chief delight was to eat and sleep, and after that he liked best to make mischief\". He takes great delight in hurting the animals in his family farm. Nils captures a tomte in a net while his family is at church and have left him home to memorize chapters from the Bible. The tomte proposes to Nils that if Nils frees him, the tomte will give him a huge gold coin. Nils rejects the offer and the tomte turns Nils into a tomte, which leaves him shrunken and able to talk with animals, who are thrilled to see the boy reduced to their size and are angry and hungry for revenge. While this is happening, wild geese are flying over the farm on one of their migrations, and a white farm goose attempts to join the wild ones. In an attempt to salvage something before his family returns, Nils holds on to the bird's neck as it successfully takes off and joins the wild birds.";
public String text2="In Treasure Island, Long John Silver is a cunning and opportunistic pirate who was quartermaster under the notorious Captain Flint. Long John Silver had a pet parrot called Captain Flint, often seen sitting on his shoulder where she would nibble on seeds. Silver claims to have served in the Royal Navy and lost his leg under \"the immortal Hawke\". \"His left leg was cut off close by the hip, and under the left shoulder he carried a crutch, which he managed with wonderful dexterity, hopping about upon it like a bird. He was very tall and strong, with a face as big as a ham – plain and pale, but intelligent and smiling.\"[1] He claims to have been the only man whom Flint ever feared. Like many of Stevenson's characters, there is more than a modicum of duality in the character; ostensibly Silver is a hardworking and likeable seaman, and it is only as the plot unfolds that his villainous nature is gradually revealed. His relationship with Jim Hawkins, the novel's protagonist and narrator, is interesting, as he serves as a mentor and eventually father-figure to Jim, creating much shock and emotion when it is discovered that he is in charge of the mutiny, and especially when Jim must confront and fight him later on. Although willing to change sides at any time to further his own interests, Silver has compensating virtues: he is wise enough to pay attention to money management, in contrast to the spendthrift ways of most of the pirates, and is physically courageous despite his disability; for instance, when Flint's cache is found to be empty, he coolly stands his ground against five grown men despite having only Jim, a boy in his teens, to back him.";
    @RequestMapping(value="/summary")
    public String summarize(){
        String output = "";
        try {
            HttpResponse<JsonNode> response = Unirest.post("https://textanalysis-text-summarization.p.mashape.com/text-summarizer-text")
                    .header("X-Mashape-Key", "sAqYRPqYO7mshcqrB1IKU1qWJmxfp1SdR29jsnHubfPfSILEfV")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Accept", "application/json")
                    .field("sentnum", 3)
                    .field("text",text2 )
                    .asJson();

            output = response.getBody().toString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return output;
    }
}


