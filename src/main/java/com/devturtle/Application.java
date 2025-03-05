package com.devturtle;

import com.devturtle.helper.JsonMapper;
import com.devturtle.model.Activity;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 1) {
            System.out.println("No command line argument error!\n<username> should be included to run this program!");
            System.out.println("github-activity <username>");
            return;
        }

        String username = args[0];
        String url = "https://api.github.com/users/" + username + "/events";

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try (HttpClient httpClient = HttpClient.newHttpClient()) {

            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            String body = getResponse.body();
            JsonMapper jsonMapper = new JsonMapper();
            List<Activity> activities = jsonMapper.fromJson(body);

            System.out.println("Output :");
            for (Activity activity : activities) {
                printOnSwitch(activity);
            }
            System.out.println("...");
        }
    }

    private static void printOnSwitch(Activity activity) {
        String repoName = activity.getRepo().getName();

        switch (activity.getType()) {
            case "PushEvent" :
                int commitCount = activity.getPayload().getCommits().size();
                System.out.printf("Pushed %d commits to %s\n", commitCount, repoName);
                break;
            case "WatchEvent" :
                System.out.printf("Starred %s\n", repoName);
                break;
            case "IssuesEvent" :
                if (activity.getPayload().getAction().equals("opened")) {
                    System.out.printf("Opened a new issue in %s\n", repoName);
                }
                break;
            case "CreateEvent" :
                System.out.printf("Created a new %1$s in %2$s\n", activity.getPayload().getRef_type(), repoName);
        }
    }
}
