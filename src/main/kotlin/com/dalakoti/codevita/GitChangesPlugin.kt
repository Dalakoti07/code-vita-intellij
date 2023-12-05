package com.dalakoti.codevita

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.Service
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import org.jetbrains.annotations.NotNull


@Service
class GitChangesService(@param:NotNull private val project: Project) {

    /*init {
        ApplicationManager.getApplication().messageBus.connect().subscribe(
            FileEditorManagerListener.FILE_EDITOR_MANAGER,
            FileChangeListener(
                project = project
            ),
        )
    }*/

  /*  val modifiedFileCount: Int
        get() {
            val gitChangesTracker = GitChangesTracker(project.basePath!!)
            return gitChangesTracker.getModifiedFileCount()
        } // Your other service methods go here
*/


}
