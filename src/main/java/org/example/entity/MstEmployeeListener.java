package org.example.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/** */
public class MstEmployeeListener implements EntityListener<MstEmployee> {

  @Override
  public void preInsert(MstEmployee entity, PreInsertContext<MstEmployee> context) {}

  @Override
  public void preUpdate(MstEmployee entity, PreUpdateContext<MstEmployee> context) {}

  @Override
  public void preDelete(MstEmployee entity, PreDeleteContext<MstEmployee> context) {}

  @Override
  public void postInsert(MstEmployee entity, PostInsertContext<MstEmployee> context) {}

  @Override
  public void postUpdate(MstEmployee entity, PostUpdateContext<MstEmployee> context) {}

  @Override
  public void postDelete(MstEmployee entity, PostDeleteContext<MstEmployee> context) {}
}
