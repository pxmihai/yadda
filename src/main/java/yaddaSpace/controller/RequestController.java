package yaddaSpace.controller;

import java.util.*;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yaddaSpace.helpers.dataField;
import yaddaSpace.model.Request;
import yaddaSpace.helpers.secret.api;


@Controller
@RequestMapping(value = "/request")
public class RequestController {

        @RequestMapping(method = RequestMethod.GET)
        public String viewRegistration(Map<String, Object> model) {
            Request requestForm = new Request();
            model.put("requestForm", requestForm);

            List<String> procList = new ArrayList<>();
            procList.add("No");
            procList.add("25");
            procList.add("50");
            procList.add("75");
            model.put("procList", procList);

            return "Request";
        }

        @RequestMapping(method = RequestMethod.POST)
        public String processRegistration(@ModelAttribute("requestForm") Request request, Model model) {

            String output   ="";
            String segmented="";
            try {
                HttpResponse<JsonNode> response2 = Unirest.post("https://textanalysis.p.mashape.com/nltk-sentence-segmentation")
                        .header("X-Mashape-Key", api.apiKey)
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .header("Accept", "application/json")
                        .field("text",request.text)
                        .asJson();

                segmented=response2.getBody().toString();
            }
            catch (UnirestException e) {
                e.printStackTrace();
            }

            Integer count;
            JSONObject obj2 = new JSONObject(segmented);
            JSONArray jsonArray2 = obj2.getJSONArray("sentences");
            count = jsonArray2.length();

            try {
                if(request.num==null&&request.procent.equals("No"))request.num=1;
                if(request.num==null||request.num==0&& request.procent.equals("25")){ Double d=0.25*count; request.num= d.intValue();}
                if(request.num==null||request.num==0&& request.procent.equals("50")){ Double d=0.50*count; request.num= d.intValue();}
                if(request.num==null||request.num==0&& request.procent.equals("75")){ Double d=0.75*count; request.num= d.intValue();}


                HttpResponse<JsonNode> response1 = Unirest.post("https://textanalysis-text-summarization.p.mashape.com/text-summarizer-text")
                        .header("X-Mashape-Key", dataField.apiKey)
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .header("Accept", "application/json")
                        .field("sentnum", request.num)
                        .field("text", request.text )
                        .asJson();

                output = response1.getBody().toString();
            } catch (UnirestException e) {
                e.printStackTrace();
            }


            model.addAttribute("summary",output);
            model.addAttribute("snum",count);
            model.addAttribute("output",segmented);


            JSONObject split1 = new JSONObject(segmented);// segmented split
            ArrayList<String> splitList = new ArrayList<>();
            JSONArray jsonArray1 = split1.getJSONArray("sentences");
            if (jsonArray1 != null) {
                int len = jsonArray1.length();
                for (int i = 0; i < len; i++) {
                    splitList.add(jsonArray1.get(i).toString());
                }
            }
            model.addAttribute("splitList", splitList);


            JSONObject split2 = new JSONObject(output);//output split
            ArrayList<String> splitList2 = new ArrayList<>();
            JSONArray jsonArray3 = split2.getJSONArray("sentences");
            if (jsonArray3 != null) {
                int len = jsonArray3.length();
                for (int i = 0; i < len; i++) {
                    splitList2.add(jsonArray3.get(i).toString());
                }
            }

            Set<String> foo = new HashSet<String>(splitList2);

            model.addAttribute("splitList2", foo); // the b
            model.addAttribute("request.procent",request.procent);

            return "RequestSuccess";
        }
    }



