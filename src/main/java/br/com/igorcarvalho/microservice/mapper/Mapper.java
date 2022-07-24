package br.com.igorcarvalho.microservice.mapper;

import java.util.List;

public interface Mapper<Entity, Dto> {
    Entity toEntity(Dto dto);

    Dto toDto(Entity entity);

    List<Entity> toEntity(List<Dto> dtos);

    List<Dto> toDto(List<Entity> entities);
}
