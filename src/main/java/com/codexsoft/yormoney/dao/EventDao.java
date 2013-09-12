package com.codexsoft.yormoney.dao;

import com.codexsoft.yormoney.domain.Event;

import java.util.List;

public interface EventDao extends DaoInterface<Event> {

    public List<Event> getListEvents(long userId, long typeId);
}
