package com.roomj.simpletitles;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.project.ex.ProjectEx;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class TitleConfiguration implements Configurable {

    private TitleSettingComponent settingComponent;

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Simple Title Format";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return settingComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        settingComponent = new TitleSettingComponent();
        return settingComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        TitleSettingsState state = TitleSettingsState.getInstance();
        return !settingComponent.getProjectFormat().equals(state.projectFormat) || !settingComponent.getFileFormat().equals(state.fileFormat);
    }

    @Override
    public void apply() {
        TitleSettingsState.getInstance().fileFormat = settingComponent.getFileFormat();
        TitleSettingsState.getInstance().projectFormat = settingComponent.getProjectFormat();

        triggerTitleRefresh();
    }

    private void triggerTitleRefresh() {
        Project firstProject = ProjectManager.getInstance().getOpenProjects()[0];
        if (firstProject instanceof ProjectEx) {
            String oldName = firstProject.getName();
            ((ProjectEx) firstProject).setProjectName("");
            ((ProjectEx) firstProject).setProjectName(oldName);
        }
    }

    @Override
    public void reset() {
        TitleSettingsState state = TitleSettingsState.getInstance();
        settingComponent.setProjectFormatText(state.projectFormat);
        settingComponent.setFileFormatText(state.fileFormat);
    }

    @Override
    public void disposeUIResources() {
        settingComponent = null;
    }
}
