package bss.themeswitcher

import com.intellij.ide.ui.LafManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidgetFactory
import com.intellij.openapi.wm.impl.status.TextPanel
import com.intellij.util.Consumer
import java.awt.event.MouseEvent
import javax.swing.JComponent

class ThemeSwitcherStatusBarWidget : StatusBarWidget, StatusBarWidget.TextPresentation {
    private val lightTheme = "Light" // Customize this
    private val darkTheme = "Dark" // Customize this

    override fun ID(): String = "ThemeSwitcherStatusBarWidget"

    override fun getPresentation(): StatusBarWidget.WidgetPresentation = this

    override fun install(statusBar: com.intellij.openapi.wm.StatusBar) {}

    override fun dispose() {}

    override fun getText(): String = "Switch Theme"

    override fun getAlignment(): Float = JComponent.CENTER_ALIGNMENT

    override fun getTooltipText(): String = "Click to switch theme"

    override fun getClickConsumer(): Consumer<MouseEvent>? = Consumer {
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