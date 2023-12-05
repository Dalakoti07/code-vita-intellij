package com.dalakoti.codevita

import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.FileEditorManagerEvent
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.VirtualFile

class FileChangeListener(private val project: Project?) : FileEditorManagerListener {

    private var gitChangesTracker = GitChangesTracker("/Users/saurabhdalakoti/IdeaProjects/code-vita-intellij")

    override fun fileOpened(source: FileEditorManager, file: VirtualFile) {
        // File opened, you can add custom logic here if needed
//        showDialog("File was opened")
    }

    override fun fileClosed(source: FileEditorManager, file: VirtualFile) {
        // File closed, you can add custom logic here if needed
        showDialog("File was closed")
    }

    override fun selectionChanged(event: FileEditorManagerEvent) {
        calculateModifiedFileCount()
    }

    private fun calculateModifiedFileCount(): Int {
        // Implement logic to calculate the modified file count
        // This could involve checking version control status, timestamps, etc.
        // For simplicity, a dummy implementation is provided here.
        return gitChangesTracker.getModifiedFileCount(
            onTrueHOF = {
                showDialog(it)
            }
        )
    }

    private fun showDialog(message: String) {
        // Show a dialog with the specified message
        Messages.showMessageDialog(message, "File Changes Alert", Messages.getInformationIcon())
    }
}
