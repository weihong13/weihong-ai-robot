package com.wh.ai.robot.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * @Author: ghw
 * @Date: 2025/10/16 10:50
 * @Version: v1.0.0
 * @Description: 演员 - 电影集合
 **/
@JsonPropertyOrder({"actor", "movies"})
public record ActorFilmography(String actor, List<String> movies) {
}

