package com.roomj.simpletitles

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(name = "com.roomj.simpletitles.TitleSettingsState", storages = [Storage("SdkSettingsPlugin.xml")])
class TitleSettingsState : PersistentStateComponent<TitleSettingsState> {

    var projectFormat: String = "{DEFAULT}"
    var fileFormat: String = "{SIMPLE}"

    override fun getState(): TitleSettingsState = this

    override fun loadState(state: TitleSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }

    companion object {
        fun getInstance(): TitleSettingsState =
            ApplicationManager.getApplication().getService(TitleSettingsState::class.java)
    }
}