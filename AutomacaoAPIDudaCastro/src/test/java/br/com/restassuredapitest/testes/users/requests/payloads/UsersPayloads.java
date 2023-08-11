package br.com.restassuredapitest.testes.users.requests.payloads;

import org.json.JSONObject;

public class UsersPayloads {
        public JSONObject payloadValidoCreateUser(String name,String job){
            JSONObject payload = new JSONObject();

            payload.put("name",name);
            payload.put("job",job);

        return payload;
        }

    public JSONObject payloadPatch (String name,String job){
        JSONObject payload = new JSONObject();


        payload.put("name",name);
        payload.put("job",job);



        return payload;
    }



}
