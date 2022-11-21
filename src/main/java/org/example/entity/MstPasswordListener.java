package org.example.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/** */
public class MstPasswordListener implements EntityListener<MstPassword> {

  @Override
  public void preInsert(MstPassword entity, PreInsertContext<MstPassword> context) {}

  @Override
  public void preUpdate(MstPassword entity, PreUpdateContext<MstPassword> context) {}

  @Override
  public void preDelete(MstPassword entity, PreDeleteContext<MstPassword> context) {}

  @Override
  public void postInsert(MstPassword entity, PostInsertContext<MstPassword> context) {}

  @Override
  public void postUpdate(MstPassword entity, PostUpdateContext<MstPassword> context) {}

  @Override
  public void postDelete(MstPassword entity, PostDeleteContext<MstPassword> context) {}
}
