package org.example.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/** */
public class MstNewsListener implements EntityListener<MstNews> {

  @Override
  public void preInsert(MstNews entity, PreInsertContext<MstNews> context) {}

  @Override
  public void preUpdate(MstNews entity, PreUpdateContext<MstNews> context) {}

  @Override
  public void preDelete(MstNews entity, PreDeleteContext<MstNews> context) {}

  @Override
  public void postInsert(MstNews entity, PostInsertContext<MstNews> context) {}

  @Override
  public void postUpdate(MstNews entity, PostUpdateContext<MstNews> context) {}

  @Override
  public void postDelete(MstNews entity, PostDeleteContext<MstNews> context) {}
}
