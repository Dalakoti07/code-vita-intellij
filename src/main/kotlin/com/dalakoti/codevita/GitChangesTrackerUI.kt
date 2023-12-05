package com.dalakoti.codevita

import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JOptionPane


class GitChangesTrackerUI {
    private val infoLabel: JLabel = JLabel()

    fun updateInfo(modifiedFileCount: Int) {
        infoLabel.text = "Modified files: $modifiedFileCount"
        if (modifiedFileCount > 20) {
            JOptionPane.showMessageDialog(null, "More than 20 files modified!")
        }
    }

    val component: JComponent
        get() = infoLabel
}
