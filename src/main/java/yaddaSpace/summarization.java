package yaddaSpace;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;


@Controller
public class summarization {


        public String text1="The book is about a young lad, Nils Holgersson, whose \"chief delight was to eat and sleep, and after that he liked best to make mischief\". He takes great delight in hurting the animals in his family farm. Nils captures a tomte in a net while his family is at church and have left him home to memorize chapters from the Bible. The tomte proposes to Nils that if Nils frees him, the tomte will give him a huge gold coin. Nils rejects the offer and the tomte turns Nils into a tomte, which leaves him shrunken and able to talk with animals, who are thrilled to see the boy reduced to their size and are angry and hungry for revenge. While this is happening, wild geese are flying over the farm on one of their migrations, and a white farm goose attempts to join the wild ones. In an attempt to salvage something before his family returns, Nils holds on to the bird's neck as it successfully takes off and joins the wild birds.";
        public String text2="In Treasure Island, Long John Silver is a cunning and opportunistic pirate who was quartermaster under the notorious Captain Flint. Long John Silver had a pet parrot called Captain Flint, often seen sitting on his shoulder where she would nibble on seeds. Silver claims to have served in the Royal Navy and lost his leg under \"the immortal Hawke\". \"His left leg was cut off close by the hip, and under the left shoulder he carried a crutch, which he managed with wonderful dexterity, hopping about upon it like a bird. He was very tall and strong, with a face as big as a ham – plain and pale, but intelligent and smiling.\"[1] He claims to have been the only man whom Flint ever feared. Like many of Stevenson's characters, there is more than a modicum of duality in the character; ostensibly Silver is a hardworking and likeable seaman, and it is only as the plot unfolds that his villainous nature is gradually revealed. His relationship with Jim Hawkins, the novel's protagonist and narrator, is interesting, as he serves as a mentor and eventually father-figure to Jim, creating much shock and emotion when it is discovered that he is in charge of the mutiny, and especially when Jim must confront and fight him later on. Although willing to change sides at any time to further his own interests, Silver has compensating virtues: he is wise enough to pay attention to money management, in contrast to the spendthrift ways of most of the pirates, and is physically courageous despite his disability; for instance, when Flint's cache is found to be empty, he coolly stands his ground against five grown men despite having only Jim, a boy in his teens, to back him.";
        public String text3="The plot focuses on the adventures of five Americans on an uncharted island in the South Pacific. During the American Civil War, five northern prisoners of war decide to escape, during the siege of Richmond, Virginia, by hijacking a balloon. The escapees are Cyrus Smith, a railroad engineer in the Union army (named Cyrus Harding in Kingston's version); his ex-slave and loyal follower Neb (short for Nebuchadnezzar); Bonadventure Pencroff, a sailor (who is addressed only by his surname. In Kingston's translation, he is named Pencroft); his protégé and adopted son Harbert Brown (called Herbert in some translations); and the journalist Gedéon Spilett (Gideon Spilett in English versions). The company is completed by Cyrus' dog . After flying in a great storm for several days, the group crash-lands on a cliff-bound, volcanic, unknown island, described as being located at , about 2,500 kilometres (1,600 mi) east of New Zealand. They name it  in honor of their president, Abraham Lincoln. With the knowledge of the brilliant engineer Smith, the five are able to sustain themselves on the island, producing fire, pottery, bricks, nitroglycerin, iron, a simple electric telegraph, a home on a stony cliffside called , and even a seaworthy ship. They also manage to figure out their geographical location.";
        public String text4="Ayrton's former companions arrive by chance on Lincoln Island, and try to make it into their lair. After some fighting with the protagonists, the pirate ship is mysteriously destroyed by an explosion. Six of the pirates survive and kidnap Aryton. When the colonists go to look for him, the pirates shoot Harbert, seriously injuring him. Harbert survives, but suffers from his injury, narrowly cheating death. The colonists at first assume Ayrton to have been killed, but later they find evidence that he was not instantly killed, making it possible for him to be alive. When the colonists rashly attempt to return to Granite House before Harbert fully recovers, Harbert contracts malaria and is saved by a box of quinine sulphate, which mysteriously appears on the table in Granite House. After Harbert recovers, they attempt to rescue Aryton and destroy the pirates. They discover Ayrton at the sheepfold, and the pirates dead, without any visible wounds.";
        public int num =7;
    @RequestMapping(value="/summary",method=RequestMethod.GET)
    public String summary(Model model){
        String output = "";
        try {
            HttpResponse<JsonNode> response = Unirest.post("https://textanalysis-text-summarization.p.mashape.com/text-summarizer-text")
                    .header("X-Mashape-Key", "sAqYRPqYO7mshcqrB1IKU1qWJmxfp1SdR29jsnHubfPfSILEfV")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Accept", "application/json")
                    .field("sentnum", num)
                    .field("text",text4 )
                    .asJson();

            output = response.getBody().toString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }


        /*
        * check to see if output is empty and if so return error
        * if output noy empty then split output in a vector of strings
        * check for each element in vector and return start and stop in each sentence
        * use data to color the background
        * increment counter for each sentence, split color in x and color each sentence
        * by its value
        *
        *
        *
        * */

        //split summary
        //JSONArray jsonArray = new JSONArray(output);

        JSONObject obj = new JSONObject(output);

        ArrayList<String> list = new ArrayList<String>();
        JSONArray jsonArray = obj.getJSONArray("sentences");
        if (jsonArray != null) {
            int len = jsonArray.length();
            for (int i=0;i<len;i++){
                list.add(jsonArray.get(i).toString());
            }
        }





        model.addAttribute("num",num); // send number of sentences
        model.addAttribute("original",text4); // send original text
        model.addAttribute("summary",output); // send the output
       // model.addAttribute("array",list.toArray());
        model.addAttribute("array",list.get(3)); //works
        return "summary";
    }
}


