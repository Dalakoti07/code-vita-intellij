package com.dalakoti.codevita

import com.intellij.ide.impl.ProjectUtil
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.EditorSettings
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.project.ProjectManagerListener
import com.intellij.psi.PsiElement
import com.intellij.util.ui.JBUI

class MyApplicationComponent : ApplicationComponent, ProjectManagerListener {
    private lateinit var project: Project

    override fun initComponent() {
        // Register the FileChangeListener when the application starts
        ApplicationManager.getApplication().messageBus.connect().subscribe(
            FileEditorManagerListener.FILE_EDITOR_MANAGER,
            FileChangeListener(project = ProjectManager.getInstance().openProjects.firstOrNull()),
        )
    }

    override fun disposeComponent() {
        // Cleanup code, if any
    }

    override fun getComponentName(): String {
        return "MyApplicationComponent"
    }
}