package com.anjuxing.rabbit.mapper;

import com.anjuxing.rabbit.model.SpaceFailMessage;

import java.util.List;

public interface SpaceFailMessageMapper  {

    public SpaceFailMessage selectById(String id);

    public List<SpaceFailMessage> selectByIds(List<String> ids);

    public List<SpaceFailMessage> selectList(SpaceFailMessage model);

    public List<SpaceFailMessage> exists(SpaceFailMessage model);

    public void save(SpaceFailMessage model);

    public void saveBatch(List<SpaceFailMessage> list);

    public void update(SpaceFailMessage model);

    public void updateBatch(List<SpaceFailMessage> list);

    public void cancel(SpaceFailMessage model);

    public void cancelBatch(List<SpaceFailMessage> list);

    public void delete(String id);

    public void deleteBatch(List<String> ids);

}