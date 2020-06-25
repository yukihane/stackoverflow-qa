package com.example.en62574231;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/claims", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class Controller {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private String userId;
        private String id;
    }

    /**
     * @param policyIdentifier
     * @param lineOfBusiness
     * @param broker
     
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getClaimsBySearchCriteria(@RequestParam(value = "id") String userId )  {
                                          
//        Query query = new Query();
//       // int queryLimit = 1000;
//       
//        if (policyIdentifier != null && !policyIdentifier.isEmpty())
//            query.addCriteria(Criteria.where("Common.PolicyId").is(policyIdentifier));
//        
//        List<Claims> claims = mongoOps.find(query, Claims.class);
//        LOG.info("Claims returned: " + claims.toString());
//        return claims;
        return new Response(null, userId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void getClaimsService() {
//        LOG.info("Claims service is available");
    }

    @RequestMapping(value = "/id/", method = RequestMethod.GET)
    public String getClaims(@RequestParam(value = "userId") String userId,
                                      @RequestParam(value = "id") String id) throws JsonProcessingException {
//        MongoDatabase database = this.mongoClient.getDatabase(this.database);
//        MongoCollection<Document> collection = database.getCollection(this.collection);
//        Document query = new Document("_id", new ObjectId(id));
//        FindIterable<Document> documentCursor = collection.find(query);
//        List<Document> claimsUpdatedList = null;
//       
//        for (Document doc : documentCursor) {
//            claimsUpdatedList = new ArrayList<>();
//            if (null != doc.get("Common")) {
//                Document common = (Document) doc.get("Common");
//                if (null != common.get("EffectiveDate")) {
//                    Date date = (Date) common.get("EffectiveDate");
//                    common.put("EffectiveDate",convertDate(date));
//                }
//                if (null != common.get("ExpirationDate")) {
//                    Date date = (Date) common.get("ExpirationDate");
//                    common.put("ExpirationDate",convertDate(date));
//                }
//                doc.put("Common",common);
//                claimsUpdatedList.add(doc);
//            }
//        }
//        JsonWriterSettings writerSettings = JsonWriterSettings.builder().outputMode(JsonMode.SHELL).indent(true).build();
//        return claimsUpdatedList != null ? claimsUpdatedList.get(0).toJson(writerSettings) : null;
        return new Response(userId, id).toString();
    }


    
}
