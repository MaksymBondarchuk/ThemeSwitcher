package bss.themeswitcher

import com.intellij.ide.ui.LafManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages
import javax.swing.UIManager

class ThemeSwitcherAction : AnAction() {
    private val lightTheme = "IntelliJ Light" // Customize this
    private val darkTheme = "Darcula" // Customize this

    override fun actionPerformed(event: AnActionEvent) {
        val lafManager = LafManager.getInstance()
        val currentTheme = lafManager.currentUIThemeLookAndFeel?.name ?: "Unknown"
        val newTheme = if (currentTheme == darkTheme) lightTheme else darkTheme

        // Use UIManager to access available Look and Feels instead of the deprecated method
        val availableThemes = UIManager.getInstalledLookAndFeels().map { it.name }
        if (newTheme in availableThemes) {
            val targetLaf = UIManager.getInstalledLookAndFeels().firstOrNull { it.name == newTheme }
            if (targetLaf != null) {
                lafManager.currentLookAndFeel = targetLaf // Set the Look and Feel
                lafManager.updateUI() // Apply the theme change
            }
        } else {
            Messages.showErrorDialog("Theme not available: $newTheme", "Error")
        }
    }
}
