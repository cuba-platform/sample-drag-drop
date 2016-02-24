package com.company.dad.gui.group;

import com.haulmont.cuba.gui.app.security.group.browse.GroupBrowser;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.Tree;
import com.haulmont.cuba.security.entity.Group;
import com.haulmont.cuba.security.entity.User;

import java.util.Collections;
import java.util.Map;

public class GroupBrowseExt extends GroupBrowser {
    public interface Companion {
        void initDragAndDrop(Table<User> usersTable, Tree<Group> groupsTree, MoveAction moveAction);
    }
    public interface MoveAction {
        void userToGroup(User user, Group newGroup);
    }

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        Companion companion = getCompanion();
        if (companion != null) {
            companion.initDragAndDrop(usersTable, groupsTree, (user, newGroup) -> {
                userManagementService.moveUsersToGroup(Collections.singletonList(user.getId()), newGroup.getId());
                usersTable.getDatasource().refresh();
            });
        }
    }
}