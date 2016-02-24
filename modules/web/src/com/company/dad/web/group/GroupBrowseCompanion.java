package com.company.dad.web.group;

import com.company.dad.gui.group.GroupBrowseExt;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.Tree;
import com.haulmont.cuba.security.entity.Group;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.web.gui.components.WebComponentsHelper;
import com.haulmont.cuba.web.gui.data.ItemWrapper;
import com.haulmont.cuba.web.toolkit.ui.CubaTree;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.event.DataBoundTransferable;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.event.dd.acceptcriteria.And;
import com.vaadin.ui.AbstractSelect;

import javax.annotation.Nullable;

public class GroupBrowseCompanion implements GroupBrowseExt.Companion {
    @Override
    public void initDragAndDrop(Table<User> usersTable, Tree<Group> groupsTree, GroupBrowseExt.MoveAction moveAction) {
        com.vaadin.ui.Table webTable = (com.vaadin.ui.Table) WebComponentsHelper.unwrap(usersTable);
        CubaTree webTree = (CubaTree) WebComponentsHelper.unwrap(groupsTree);
        initializerTree(webTree, moveAction);
        webTable.setDragMode(com.vaadin.ui.Table.TableDragMode.ROW);
    }

    private void initializerTree(com.vaadin.ui.Tree webTree, GroupBrowseExt.MoveAction moveAction) {
        webTree.setDragMode(com.vaadin.ui.Tree.TreeDragMode.NODE);
        webTree.setDropHandler(new DropHandler() {
            @Override
            public void drop(DragAndDropEvent dropEvent) {
                DataBoundTransferable transferable = (DataBoundTransferable) dropEvent.getTransferable();

                AbstractSelect.AbstractSelectTargetDetails dropData =
                        ((AbstractSelect.AbstractSelectTargetDetails) dropEvent.getTargetDetails());


                Object itemId = transferable.getItemId();
                Container sourceContainer = transferable.getSourceContainer();
                User user = convertToEntity(sourceContainer.getItem(itemId), User.class);
                if (user == null) {
                    return;
                }

                final Object targetItemId = dropData.getItemIdOver();
                if (targetItemId == null) {
                    return;
                }
                Group group = convertToEntity(webTree.getItem(targetItemId), Group.class);
                if (group == null) {
                    return;
                }

                moveAction.userToGroup(user, group);
            }

            @Override
            public AcceptCriterion getAcceptCriterion() {
                return new And(AbstractSelect.AcceptItem.ALL);
            }
        });
    }

    @Nullable
    private <T extends Entity> T convertToEntity(@Nullable Item item, Class<T> entityClass) {
        if (!(item instanceof ItemWrapper)) {
            return null;
        }
        Entity entity = ((ItemWrapper) item).getItem();
        if (!entityClass.isAssignableFrom(entity.getClass())) {
            return null;
        }
        return (T) entity;
    }
}
