package org.example.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/** */
public class MstRoleListener implements EntityListener<MstRole> {

  @Override
  public void preInsert(MstRole entity, PreInsertContext<MstRole> context) {}

  @Override
  public void preUpdate(MstRole entity, PreUpdateContext<MstRole> context) {}

  @Override
  public void preDelete(MstRole entity, PreDeleteContext<MstRole> context) {}

  @Override
  public void postInsert(MstRole entity, PostInsertContext<MstRole> context) {}

  @Override
  public void postUpdate(MstRole entity, PostUpdateContext<MstRole> context) {}

  @Override
  public void postDelete(MstRole entity, PostDeleteContext<MstRole> context) {}
}
