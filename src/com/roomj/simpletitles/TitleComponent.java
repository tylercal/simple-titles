package com.roomj.simpletitles;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.wm.impl.FrameTitleBuilder;
import org.jetbrains.annotations.NotNull;
import org.picocontainer.MutablePicoContainer;

public class TitleComponent implements ApplicationComponent {

  public static final String FRAME_TITLE_BUILDER = "com.intellij.openapi.wm.impl.FrameTitleBuilder";

  @Override
  public void initComponent() {
    // use https://github.com/Steve-Murphy/mavenversion-plugin as a template.
    MutablePicoContainer picoContainer = (MutablePicoContainer) ApplicationManager.getApplication().getPicoContainer();
    SimpleFrameTitleBuilder.setDefaultBuilder((FrameTitleBuilder) picoContainer.getComponentInstance(FRAME_TITLE_BUILDER));
    picoContainer.unregisterComponent(FRAME_TITLE_BUILDER);
    picoContainer.registerComponentImplementation(FRAME_TITLE_BUILDER, SimpleFrameTitleBuilder.class);
  }

  @Override
  public void disposeComponent() {}

  @NotNull
  @Override
  public String getComponentName() {
    return getClass().getSimpleName();
  }
}
