package com.roomj.simpletitles;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "com.roomj.simpletitles.TitleSettingsState", storages = @Storage("SdkSettingsPlugin.xml"))
public class TitleSettingsState implements PersistentStateComponent<TitleSettingsState> {

    public String projectFormat = "{DEFAULT}";
    public String fileFormat = "{SIMPLE}";

    public static TitleSettingsState getInstance() {
        return ApplicationManager.getApplication().getService(TitleSettingsState.class);
    }

    @Nullable
    @Override
    public TitleSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull TitleSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}
