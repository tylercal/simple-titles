package com.roomj.simpletitles

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.wm.impl.PlatformFrameTitleBuilder

class SimpleFrameTitleBuilder : PlatformFrameTitleBuilder() {
    private val state: TitleSettingsState = TitleSettingsState.getInstance()

    override fun getProjectTitle(project: Project): String {
        var title = state.projectFormat
        if (title.contains("{DEFAULT}")) {
            title = title.replace("{DEFAULT}", super.getProjectTitle(project))
        }
        if (title.contains("{SIMPLE}")) {
            title = title.replace("{SIMPLE}", project.name)
        }
        return title
    }

    override suspend fun getFileTitleAsync(project: Project, file: VirtualFile): String {
        return customizeTitle(file, super.getFileTitleAsync(project, file))
    }

    override fun getFileTitle(project: Project, file: VirtualFile): String {
        return customizeTitle(file, super.getFileTitle(project, file))
    }

    private fun customizeTitle(file: VirtualFile, original: String): String {
        var title = state.fileFormat
        if (title.contains("{DEFAULT}")) {
            title = title.replace("{DEFAULT}", original)
        }
        if (title.contains("{SIMPLE}")) {
            title = title.replace("{SIMPLE}", file.name)
        }
        return title
    }
}