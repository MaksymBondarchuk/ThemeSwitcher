package bss.themeswitcher

import com.intellij.ide.ui.LafManager
import com.intellij.openapi.ui.Messages

object ThemeSwitcherUtil {
    private const val LIGHT_THEME = "Light" // Customize this
    private const val DARK_THEME = "Dark" // Customize this

    fun switchTheme() {
        val lafManager = LafManager.getInstance()
        val currentTheme = lafManager.currentLookAndFeel?.name ?: "Unknown"
        val newTheme = if (currentTheme == DARK_THEME) LIGHT_THEME else DARK_THEME
        val availableThemes = lafManager.installedLookAndFeels.map { it.name }

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