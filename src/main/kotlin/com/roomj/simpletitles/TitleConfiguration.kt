package com.roomj.simpletitles

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.project.ex.ProjectEx
import org.jetbrains.annotations.Nls
import javax.swing.JComponent

class TitleConfiguration : Configurable {
    private var settingComponent: TitleSettingComponent? = null

    @Nls(capitalization = Nls.Capitalization.Title)
    override fun getDisplayName(): String = "Simple Title Format"

    override fun getPreferredFocusedComponent(): JComponent? = settingComponent?.preferredFocusedComponent

    override fun createComponent(): JComponent? {
        settingComponent = TitleSettingComponent()
        return settingComponent?.panel
    }

    override fun isModified(): Boolean {
        val state = TitleSettingsState.getInstance()
        return settingComponent?.projectFormat != state.projectFormat ||
                settingComponent?.fileFormat != state.fileFormat
    }

    override fun apply() {
        TitleSettingsState.getInstance().apply {
            fileFormat = settingComponent?.fileFormat ?: fileFormat
            projectFormat = settingComponent?.projectFormat ?: projectFormat
        }
        triggerTitleRefresh()
    }

    private fun triggerTitleRefresh() {
        val firstProject = ProjectManager.getInstance().openProjects.firstOrNull() ?: return
        if (firstProject is ProjectEx) {
            val oldName = firstProject.name
            firstProject.setProjectName("")
            firstProject.setProjectName(oldName)
        }
    }

    override fun reset() {
        val state = TitleSettingsState.getInstance()
        settingComponent?.apply {
            setProjectFormatText(state.projectFormat)
            setFileFormatText(state.fileFormat)
        }
    }

    override fun disposeUIResources() {
        settingComponent = null
    }
}
