package com.devturtle.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class Activity {
    private String id;
    private String type;
    private Actor actor;
    private Repo repo;
    private Payload payload;
    @SerializedName("public")
    private boolean isPublic;
    private String createdAt;

    @Getter
    public class Actor {
        private int id;
        private String login;
        private String display_login;
        private String url;
        private String avatar_url;
    }

    @Getter
    public class Repo {
        private int id;
        private String name;
        private String url;
    }

    @Getter
    public class Payload {
        private String action;
        private String ref;
        private String ref_type;
        private String master_branch;
        private String description;
        private String pusher_type;
        private long repository_id;
        private long push_id;
        private int size;
        private int distinct_size;
        private String refName;
        private String head;
        private String before;
        private List<Activity.Commit> commits;
    }

    @Getter
    public class Commit {
        private String sha;
        private Author author;
        private String message;
        private boolean distinct;
        private String url;
    }

    @Getter
    public class Author {
        private String email;
        private String name;
    }
}
