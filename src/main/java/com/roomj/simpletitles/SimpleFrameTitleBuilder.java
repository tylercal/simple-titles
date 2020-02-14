package com.roomj.simpletitles;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.impl.PlatformFrameTitleBuilder;
import org.jetbrains.annotations.NotNull;

public class SimpleFrameTitleBuilder extends PlatformFrameTitleBuilder {

  @Override
  public String getFileTitle(@NotNull Project project, @NotNull VirtualFile virtualFile) {
    return virtualFile.getName();
  }
}