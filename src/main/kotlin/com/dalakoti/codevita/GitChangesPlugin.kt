package com.dalakoti.codevita

import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import org.jetbrains.annotations.NotNull


@Service
class GitChangesService(@param:NotNull private val project: Project) {

    val modifiedFileCount: Int
        get() {
            val gitChangesTracker = GitChangesTracker(project.basePath!!)
            return gitChangesTracker.getModifiedFileCount()
        } // Your other service methods go here



}
