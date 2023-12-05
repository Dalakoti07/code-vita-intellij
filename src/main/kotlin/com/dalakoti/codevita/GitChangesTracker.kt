package com.dalakoti.codevita

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.OSProcessHandler
import com.intellij.execution.process.ProcessAdapter
import com.intellij.execution.process.ProcessEvent
import com.intellij.openapi.application.ApplicationManager
import org.eclipse.jgit.api.errors.GitAPIException
import java.io.IOException
import com.intellij.openapi.util.Key


class GitChangesTracker {

    private fun runCommandInPlugin(onTrueHOF: (String)-> Unit) {
        val changeDirCommand = GeneralCommandLine("cd","/Users/saurabhdalakoti/IdeaProjects/code-vita-intellij")
        val processHandler = OSProcessHandler(changeDirCommand)
        processHandler.startNotify()

        processHandler.addProcessListener(object : ProcessAdapter() {
            override fun onTextAvailable(event: ProcessEvent, outputType: Key<*>) {
                // Show a dialog with the result
                seeGitStatus(onTrueHOF)
            }
        })
    }

    private fun seeGitStatus(onTrueHOF: (String) -> Unit) {
        val changeDirCommand = GeneralCommandLine("pwd")
        val processHandler = OSProcessHandler(changeDirCommand)
        processHandler.startNotify()

        processHandler.addProcessListener(object : ProcessAdapter() {
            override fun onTextAvailable(event: ProcessEvent, outputType: Key<*>) {
                val result = event.text
                // Show a dialog with the result
                ApplicationManager.getApplication().invokeLater {
                    onTrueHOF(result)
                }
            }
        })
    }

    fun getModifiedFileCount(onTrueHOF: (String)-> Unit): Int{
        try {
            // core logic to tell
            runCommandInPlugin(onTrueHOF)
            return 0
        } catch (e: IOException) {
            e.printStackTrace()
            return -1
        } catch (e: GitAPIException) {
            e.printStackTrace()
            return -1
        }
    }

}
