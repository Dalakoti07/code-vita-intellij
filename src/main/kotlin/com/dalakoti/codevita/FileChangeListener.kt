package com.dalakoti.codevita

import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.FileEditorManagerEvent
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.VirtualFile

class FileChangeListener(private val project: Project) : FileEditorManagerListener {

    private var gitChangesTracker = GitChangesTracker()

    override fun fileOpened(source: FileEditorManager, file: VirtualFile) {
        // File opened, you can add custom logic here if needed
    }

    override fun fileClosed(source: FileEditorManager, file: VirtualFile) {
        // File closed, you can add custom logic here if needed
    }

    override fun selectionChanged(event: FileEditorManagerEvent) {
        val modifiedFileCount = calculateModifiedFileCount()
        if (modifiedFileCount >= 20) {
            showDialog("More than 20 files modified!")
        }
    }

    private fun calculateModifiedFileCount(): Int {
        // Implement logic to calculate the modified file count
        // This could involve checking version control status, timestamps, etc.
        // For simplicity, a dummy implementation is provided here.
        return gitChangesTracker.getModifiedFileCount()
    }

    private fun showDialog(message: String) {
        // Show a dialog with the specified message
        Messages.showMessageDialog(project, message, "File Changes Alert", Messages.getInformationIcon())
    }
}
