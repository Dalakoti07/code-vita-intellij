package com.dalakoti.codevita

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.api.errors.GitAPIException
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import java.io.File
import java.io.IOException


class GitChangesTracker(
    private var gitDirectory: String = ""
) {

    fun getModifiedFileCount(): Int{
        try {
            FileRepositoryBuilder().setGitDir(File(gitDirectory, ".git")).build().use { repository ->
                Git(repository).use { git ->
                    return git.status().call().modified.size
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            return -1
        } catch (e: GitAPIException) {
            e.printStackTrace()
            return -1
        }
    }

}
