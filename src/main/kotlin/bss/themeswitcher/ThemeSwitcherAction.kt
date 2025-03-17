package bss.themeswitcher

import com.intellij.ide.ui.LafManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class ThemeSwitcherAction : AnAction() {
    private val lightTheme = "Light" // Customize this
    private val darkTheme = "Dark" // Customize this

    override fun actionPerformed(event: AnActionEvent) {

        val lafManager = LafManager.getInstance()
        val currentTheme = lafManager.currentLookAndFeel?.name ?: "Unknown"
        val newTheme = if (currentTheme == darkTheme) lightTheme else darkTheme
        val availableThemes = lafManager.installedLookAndFeels.map { it.name }

        // Use UIManager to access available Look and Feels instead of the deprecated method
        if (newTheme in availableThemes) {
            val targetLaf = lafManager.installedLookAndFeels.firstOrNull { it.name == newTheme }
            if (targetLaf != null) {
                lafManager.setCurrentLookAndFeel(targetLaf) // Set the Look and Feel
                lafManager.updateUI() // Apply the theme change
            }
        } else {
            Messages.showErrorDialog("Theme not available: $newTheme", "Error")
        }
    }
}