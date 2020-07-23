package com.anjuxing.rabbit.mapper;

import com.anjuxing.rabbit.model.SpaceUser;

import java.util.List;

public interface SpaceUserMapper {

    public SpaceUser selectById(SpaceUser model);

    public List<SpaceUser> selectByIds(List<String> ids);

    public List<SpaceUser> selectList(SpaceUser model);

    public List<SpaceUser> exists(SpaceUser model);

    public void save(SpaceUser model);

    public void saveBatch(List<SpaceUser> list);

    public void update(SpaceUser model);

    public void updateBatch(List<SpaceUser> list);

    public void cancel(SpaceUser model);

    public void cancelBatch(List<SpaceUser> list);

    public void delete(String id);

    public void deleteBatch(List<String> ids);


}