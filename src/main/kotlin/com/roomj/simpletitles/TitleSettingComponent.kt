package com.roomj.simpletitles

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel

class TitleSettingComponent {
    val panel: JPanel
    private val projectFormatText = JBTextField()
    private val fileFormatText = JBTextField()

    init {
        panel = FormBuilder.createFormBuilder()
            .addComponent(JBLabel("Customize how the title of your IDE is formatted."))
            .addComponent(JBLabel("You can use arbitrary characters and the following variables:"))
            .addComponent(JBLabel("{DEFAULT} - Use the IDE default"))
            .addComponent(JBLabel("{SIMPLE} - Just the name (not the path of the project or file)"))
            .addComponent(JBLabel(" "))
            .addComponent(JBLabel(" "))
            .addLabeledComponent(JBLabel("Project Format"), projectFormatText, 1, false)
            .addLabeledComponent(JBLabel("File Format"), fileFormatText, 1, false)
            .addComponent(JBLabel(" "))
            .addComponent(JBLabel("Leave format blank to omit that data from the title."))
            .addComponent(JBLabel("Changes to Project Format require IDE restart to take effect."))
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    val preferredFocusedComponent: JComponent
        get() = projectFormatText

    val projectFormat: String
        get() = projectFormatText.text

    fun setProjectFormatText(newText: String) {
        projectFormatText.text = newText
    }

    val fileFormat: String
        get() = fileFormatText.text

    fun setFileFormatText(newText: String) {
        fileFormatText.text = newText
    }
}
