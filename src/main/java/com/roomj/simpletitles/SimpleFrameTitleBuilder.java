package com.roomj.simpletitles;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.impl.PlatformFrameTitleBuilder;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SimpleFrameTitleBuilder extends PlatformFrameTitleBuilder {

  TitleSettingsState state = TitleSettingsState.getInstance();

  @Override
  public @NotNull String getProjectTitle(@NotNull Project project) {
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
  public @Nullable Object getFileTitleAsync(@NotNull Project project, @NotNull VirtualFile file, @NotNull Continuation<? super String> $completion) {
    String defaultTitle = (String) super.getFileTitleAsync(project, file, $completion);
    if (defaultTitle == null) defaultTitle = "";
    return customizeTitle(file, defaultTitle);
  }

  @Override
  public @NotNull String getFileTitle(@NotNull Project project, @NotNull VirtualFile virtualFile) {
    return customizeTitle(virtualFile, super.getFileTitle(project, virtualFile));
  }

  private @NotNull String customizeTitle(@NotNull VirtualFile file, @NotNull String original) {
    String title = state.fileFormat;
    if (title.contains("{DEFAULT}")) {
      title = title.replace("{DEFAULT}", original);
    }
    if (title.contains("{SIMPLE}")) {
      title = title.replace("{SIMPLE}", file.getName());
    }
    return title;
  }
}