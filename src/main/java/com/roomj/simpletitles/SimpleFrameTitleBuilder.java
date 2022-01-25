package com.roomj.simpletitles;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.impl.PlatformFrameTitleBuilder;
import org.jetbrains.annotations.NotNull;

public class SimpleFrameTitleBuilder extends PlatformFrameTitleBuilder {

  TitleSettingsState state = TitleSettingsState.getInstance();

  @Override
  public String getProjectTitle(@NotNull Project project) {
    String title = state.projectFormat;
    if (title.contains("{DEFAULT}")) {
      title = title.replace("{DEFAULT}", super.getProjectTitle(project));
    }
    if (title.contains("{SIMPLE}")) {
      title = title.replace("{SIMPLE}", project.getName());
    }
    return title;
  }

  @Override
  public String getFileTitle(@NotNull Project project, @NotNull VirtualFile virtualFile) {
    String title = state.fileFormat;
    if (title.contains("{DEFAULT}")) {
      title = title.replace("{DEFAULT}", super.getFileTitle(project, virtualFile));
    }
    if (title.contains("{SIMPLE}")) {
      title = title.replace("{SIMPLE}", virtualFile.getName());
    }
    return title;
  }
}