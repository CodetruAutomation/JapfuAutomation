package com.Japfu.utils;


import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.Japfu.helpers.PropertiesHelpers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.TextFormat.ParseException;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider {

    private JiraClient jira;
    private String projectKey;

    String issueId;
    String issueKey;

    String jiraURL = PropertiesHelpers.getValue("jiraURL");
    String jiraUSERNAME = PropertiesHelpers.getValue("jiraUSERNAME");
    String jiraAPIKEY = PropertiesHelpers.getValue("jiraAPIKEY");
    String jiraPRODUCTKEY = PropertiesHelpers.getValue("jiraPRODUCTKEY");

    public JiraServiceProvider() {
        BasicCredentials creds = new BasicCredentials(jiraUSERNAME, jiraAPIKEY);
        jira = new JiraClient(jiraURL, creds);
    }

    public void createJiraIssue(String issueType, String summary, String description) {
        try {
            //Avoid Creating Duplicate Issue
            Issue.SearchResult sr = jira.searchIssues("description ~ \"" + description + "\"");

            if (sr.total != 0) {
                System.out.println("Same Issue Already Exists on Jira");
                return;
            }

            //Create issue if not exists
            FluentCreate fleuntCreate = jira.createIssue(jiraPRODUCTKEY, issueType);
            fleuntCreate.field(Field.SUMMARY, summary);
            fleuntCreate.field(Field.DESCRIPTION, description);
            //fleuntCreate.field(Field.COMMENT, comment);
            //fleuntCreate.field(Field.ASSIGNEE, assignee);

            Issue newIssue = fleuntCreate.execute();
            System.out.println("********************************************");
            System.out.println("New issue created in Jira with ID: " + newIssue);
            System.out.println("New issue URL is :" + jiraURL + "/browse/" + newIssue);
            System.out.println("*******************************************");

            issueId = newIssue.getId();
            issueKey = newIssue.getKey();

        } catch (JiraException e) {
            e.printStackTrace();
        }
    }

    //create Jira Issue as bug
    public String createJiraIssue(String ProjectName, String issueSummary, String issueDescription, String component, String priority, String label, String env, String assignee) throws ClientProtocolException, IOException, ParseException, ParseException, Exception {

        String issueId = null; //to store issue / bug id.

        HttpClient httpClient = new DefaultHttpClient();
        String url = jiraURL + "/rest/api/3/issue";
        HttpPost postRequest = new HttpPost(url);
        postRequest.addHeader("content-type", "application/json");

        String encoding = Base64.getEncoder().encodeToString((jiraUSERNAME + ":" + jiraAPIKEY).getBytes());
        postRequest.setHeader("Authorization", "Basic " + encoding);

        StringEntity params = new StringEntity(createPayloadForCreateJiraIssue(ProjectName, issueSummary, issueDescription, component, priority, label, env, assignee));
        postRequest.setEntity(params);
        HttpResponse response = httpClient.execute(postRequest);

        //convert httpresponse to string
        String jsonString = EntityUtils.toString(response.getEntity());
      //convert sring to Json
        JSONParser parser = new JSONParser();
        JSONObject json = null;
        json = (JSONObject) parser.parse(jsonString);

        //extract issuekey from Json
        issueId = (String) json.get("key");

        return issueId;

    }

    //Add attachment to already created bug / issue in JIRA
    public void addAttachmentToJiraIssue(String filePath) {
        String pathname = filePath;
        File fileUpload = new File(pathname);

        HttpClient httpClient = new DefaultHttpClient();
        String url = jiraURL + "/rest/api/3/issue/" + issueId + "/attachments";
        HttpPost postRequest = new HttpPost(url);

        String encoding = Base64.getEncoder().encodeToString((jiraUSERNAME + ":" + jiraAPIKEY).getBytes());

        postRequest.setHeader("Authorization", "Basic " + encoding);
        postRequest.setHeader("X-Atlassian-Token", "nocheck");

        MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        entity.addPart("file", new FileBody(fileUpload));
        postRequest.setEntity(entity);
        HttpResponse response = null;
        try {
            response = httpClient.execute(postRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.getStatusLine());

        if (response.getStatusLine().toString().contains("200 OK")) {
            System.out.println("Attachment uploaded");
        } else {
            System.out.println("Attachment not uploaded");
        }
    }

    //creates payload for create issue post request
    private static String createPayloadForCreateJiraIssue(String ProjectName, String issueSummary, String issueDescription, String componentId, String priority, String label, String env, String assigneeId) {
        return "{\r\n" +
                "    \"fields\": {\r\n" +
                "       \"project\":\r\n" +
                "       {\r\n" +
                "          \"key\": \"" + ProjectName + "\"\r\n" +
                "       },\r\n" +
                "       \"summary\": \"" + issueSummary + "\",\r\n" +
                "	   \"description\": {\r\n" +
                "          \"type\": \"doc\",\r\n" +
                "          \"version\": 1,\r\n" +
                "          \"content\": [\r\n" +
                "				{\r\n" +
                "                    \"type\": \"paragraph\",\r\n" +
                "                    \"content\": [\r\n" +
                "								{\r\n" +
                "                                    \"text\": \"" + issueDescription + "\",\r\n" +
                "                                    \"type\": \"text\"\r\n" +
                "								}\r\n" +
                "							   ]\r\n" +
                "				}\r\n" +
                "					]\r\n" +
                "						}, \r\n" +
                "		\"issuetype\": {\r\n" +
                "          \"name\": \"Bug\"\r\n" +
                "       },\r\n" +
                "      \"components\": [\r\n" +
                "      {\r\n" +
                "        \"id\": \"" + componentId + "\"\r\n" +
                "      }\r\n" +
                "    ],\r\n" +
                "    \"priority\": {\r\n" +
                "      \"id\": \"" + priority + "\"\r\n" +
                "    },\r\n" +
                "        \"labels\": [\r\n" +
                "      \"" + label + "\"\r\n" +
                "    ],\r\n" +
                "    	\"environment\": {\r\n" +
                "      \"type\": \"doc\",\r\n" +
                "      \"version\": 1,\r\n" +
                "      \"content\": [\r\n" +
                "        {\r\n" +
                "          \"type\": \"paragraph\",\r\n" +
                "          \"content\": [\r\n" +
                "            {\r\n" +
                "              \"text\": \"" + env + "\",\r\n" +
                "              \"type\": \"text\"\r\n" +
                "            }\r\n" +
                "          ]\r\n" +
                "        }\r\n" +
                "      ]\r\n" +
                "    },\r\n" +
                "    	\"assignee\": {\r\n" +
                "      \"id\": \"" + assigneeId + "\"\r\n" +
                "    }\r\n" +
                "}\r\n" +
                "}";
    }

    //Add attachment to already created bug / issue in JIRA
    public void addAttachmentToJiraIssue2(String filePath) throws ClientProtocolException, IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(PropertiesHelpers.getValue("jiraURL") + "/rest/api/latest/issue/" + issueId + "/attachments");
        httppost.setHeader("X-Atlassian-Token", "no-check");
        String encoding = Base64.getEncoder().encodeToString((jiraUSERNAME + ":" + jiraAPIKEY).getBytes());
        httppost.setHeader("Authorization", "Basic " + encoding);
        MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        FileBody fileBody = new FileBody(new File(filePath), "application/octet-stream");
        entity.addPart("file", fileBody);

        httppost.setEntity(entity);
        HttpResponse response = httpclient.execute(httppost);
    }

}