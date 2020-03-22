package com.example.demo.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@Data
public class RedisEntity {
    String id;
    String value;
    HashMap<String, String> hashMap;
    Long start;
    Long end;
    ArrayList<String> arrayList;
    HashSet<String> hashSet;
}
