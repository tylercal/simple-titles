package com.roomj.simpletitles;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class TitleSettingComponent {

    private final JPanel myMainPanel;
    private final JBTextField projectFormatText = new JBTextField();
    private final JBTextField fileFormatText = new JBTextField();

    public TitleSettingComponent() {
        myMainPanel = FormBuilder.createFormBuilder()
                .addComponent(new JBLabel("Customize how the title of your IDE is formatted."))
                .addComponent(new JBLabel("You can use arbitrary characters and the following variables:"))
                .addComponent(new JBLabel("{DEFAULT} - Use the IDE default"))
                .addComponent(new JBLabel("{SIMPLE} - Just the name (not the path of the project or file)"))
                .addComponent(new JBLabel(" "))
                .addComponent(new JBLabel(" "))
                .addLabeledComponent(new JBLabel("Project Format"), projectFormatText, 1, false)
                .addLabeledComponent(new JBLabel("File Format"), fileFormatText, 1, false)
                .addComponent(new JBLabel(" "))
                .addComponent(new JBLabel("Leave format blank to omit that data from the title"))
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return myMainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return projectFormatText;
    }

    @NotNull
    public String getProjectFormat() {
        return projectFormatText.getText();
    }

    public void setProjectFormatText(@NotNull String newText) {
        projectFormatText.setText(newText);
    }

    @NotNull
    public String getFileFormat() {
        return fileFormatText.getText();
    }

    public void setFileFormatText(@NotNull String newText) {
        fileFormatText.setText(newText);
    }
}
