package view.panels;

import model.Group;
import view.frames.MainWindow;

public class GroupComponent {
    private GroupTemplate groupTemplate;

    public GroupComponent(Group group) {
        //groupTemplate = new GroupTemplate(MainWindow mn = new MainWindow(), group);
    }

    public GroupTemplate getGroupTemplate() {
        return groupTemplate;
    }
}
