package com.dalakoti.codevita

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.project.ProjectManager

class MyApplicationComponent : ApplicationComponent {

    override fun initComponent() {
        // Register the FileChangeListener when the application starts
        ApplicationManager.getApplication().messageBus.connect().subscribe(
            FileEditorManagerListener.FILE_EDITOR_MANAGER,
            FileChangeListener(project = ProjectManager.getInstance().openProjects[0]),
        )
    }

    override fun disposeComponent() {
        // Cleanup code, if any
    }

    override fun getComponentName(): String {
        return "MyApplicationComponent"
    }
}